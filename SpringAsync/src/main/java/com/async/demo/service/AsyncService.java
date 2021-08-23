package com.async.demo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncService {

    private final AsyncUtil asyncUtil;

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

    public void onAsyncBlockingTestWrapping (Long time) {
        //onAsyncBlockingTest(time);
        asyncUtil.run(() -> onAsyncBlockingTest(time));
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
