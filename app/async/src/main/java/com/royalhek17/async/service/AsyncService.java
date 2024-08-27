package com.royalhek17.async.service;

import com.royalhek17.async.config.AsyncConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncService {

    @Async(AsyncConfig.SINGLE_THREAD_EXECUTOR)
    public void runSingleThread(int id) {
        try {
            Thread.sleep(1000);
            log.info("Run single thread => id = {}", id);
        } catch (Exception e) {

        }
    }

    @Async(AsyncConfig.MULTI_THREAD_EXECUTOR)
    public void runMultiThread(int id) {
        try {
            Thread.sleep(1000);
            log.info("Run multi thread => id = {}", id);
        } catch (Exception e) {

        }
    }

    @Scheduled(scheduler = AsyncConfig.SINGLE_SCHEDULE, initialDelay = 1, fixedDelay = 1, timeUnit = TimeUnit.HOURS)
    public void schedule() {
        log.info(">>> Run Schedule");
    }
}
