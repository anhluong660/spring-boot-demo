package com.royalhek17.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Configuration
public class AsyncConfig {
    public static final String SINGLE_THREAD_EXECUTOR = "single_thread_executor";
    public static final String MULTI_THREAD_EXECUTOR = "multi_thread_executor";
    public static final String SINGLE_SCHEDULE = "single_schedule";
    public static final String MULTI_SCHEDULE = "multi_schedule";

    @Bean(SINGLE_THREAD_EXECUTOR)
    public Executor singleThreadConfig() {
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setName("SingleThread");
            return thread;
        };

        return Executors.newSingleThreadExecutor(threadFactory);
    }

    @Bean(MULTI_THREAD_EXECUTOR)
    public Executor multiThreadConfig() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // Initial number of threads
        executor.setMaxPoolSize(10); // Maximum number of threads
        executor.setQueueCapacity(25); // Capacity of the queue before creating new threads
        executor.setThreadNamePrefix("MultiThread-");
        executor.initialize();
        return executor;
    }

    @Bean(SINGLE_SCHEDULE)
    public ThreadPoolTaskScheduler singleSchedule() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1); // Set the pool size
        taskScheduler.setThreadNamePrefix("SingleSchedule-");
        return taskScheduler;
    }

    @Bean(MULTI_SCHEDULE)
    public ThreadPoolTaskScheduler multiSchedule() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(10); // Set the pool size
        taskScheduler.setThreadNamePrefix("MultiSchedule-");
        return taskScheduler;
    }

}
