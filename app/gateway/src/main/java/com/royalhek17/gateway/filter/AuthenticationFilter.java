package com.royalhek17.gateway.filter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class AuthenticationFilter implements GlobalFilter, Ordered {

    @Autowired
    private RouterValidator routerValidator;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String path = request.getURI().getPath();


        if (routerValidator.isSecured(path)) {
            String token = headers.getFirst("Authorization");

            if (token == null || !token.startsWith("Bearer ")) {
                return responseError(exchange, "Authorization header is missing in request");
            }

            token = token.substring(7);
            String username = null;

            try {
                username = jwtUtil.getUsername(token);
            } catch (ExpiredJwtException ex) {
                return responseError(exchange, "Token is expired");
            } catch (SignatureException ex) {
                return responseError(exchange, "Signature is error");
            } catch (Exception ex) {
                return responseError(exchange, "Error is unknown");
            }

            if (jwtUtil.isInvalid(token)) {
                return responseError(exchange, "Authorization header is invalid");
            }

            request.mutate()
                    .header("username", username)
                    .build();
        }

        return chain.filter(exchange);
    }

    private Mono<Void> responseError(ServerWebExchange exchange, String message) {
        ServerHttpResponse response = exchange.getResponse();
        DataBuffer buffer = response.bufferFactory().wrap(message.getBytes());
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.writeWith(Mono.just(buffer));
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
