package com.async.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {


    @Async
    public void onAsync () {
        try {
            Thread.sleep(5000);
            log.info("on Async");
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Async
    public void onAsyncBlockingTest (Long time) {
        log.info("Async blocking test start");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("Async blocking test end");
    }

    public void onSync() {
        try {
            Thread.sleep(5000);
            log.info("on Sync");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void onSyncBlockingTest (Long time) {
        log.info("Sync blocking test start");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Sync blocking test end");
    }

}
