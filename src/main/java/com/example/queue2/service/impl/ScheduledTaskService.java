package com.example.queue2.service.impl;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ScheduledTaskService {

    private final ScheduledExecutorService scheduler;

    public ScheduledTaskService() {
        this.scheduler = Executors.newScheduledThreadPool(5);
    }

    public void scheduleTask(Runnable task, long delay, TimeUnit timeUnit) {
        scheduler.schedule(task, delay, timeUnit);
    }

    @PreDestroy
    public void shutdown() {
        scheduler.shutdown();
    }
}