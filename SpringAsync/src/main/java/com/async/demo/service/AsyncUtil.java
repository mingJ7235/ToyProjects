package com.async.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncUtil {

    @Async
    public void run (Runnable runnable) {
        runnable.run();
    }
}
