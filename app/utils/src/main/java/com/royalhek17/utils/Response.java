package com.royalhek17.utils;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Response<T> {
    private boolean success;
    private String message;
    private LocalDateTime timestamp;
    private T data;

    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.timestamp = LocalDateTime.now();
    }

    public static <T> Response<T> success(String message) {
        return new Response<>(true, message, null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(true, "Api Success", data);
    }

    public static <T> Response<T> success(String message, T data) {
        return new Response<>(true, message, data);
    }

    public static <T> Response<T> error(String message) {
        return new Response<>(false, message, null);
    }
}
