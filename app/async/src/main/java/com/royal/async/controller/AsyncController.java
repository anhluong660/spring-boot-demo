package com.royal.async.controller;

import com.royal.utils.Response;
import com.royal.async.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/{mode}")
    private Response<String> runAsync(@PathVariable String mode) {

        for (int i = 1; i <= 10; i++) {
            if ("single_thread".equals(mode)) {
                asyncService.runSingleThread(i);
            }

            if ("multi_thread".equals(mode)) {
                asyncService.runMultiThread(i);
            }
        }

        return Response.success("Async Test Ok");
    }
}
