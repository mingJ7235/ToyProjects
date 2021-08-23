package com.async.demo.controller;

import com.async.demo.service.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AsyncController {


    private final AsyncService service;

    @GetMapping ("/async")
    public String async () {
        service.onAsync();
        String result = "Async spring boot";
        log.info(result);
        log.info("-----------------------------");
        return result;
    }


    @GetMapping ("/sync")
    public String sync () {
        service.onSync();
        String result = "Sync spring boot";
        log.info(result);
        log.info("-----------------------------");
        return result;
    }

    @GetMapping ("/blocking")
    public String blockingProcess (@RequestParam (value = "time") Long time) {
        log.info("blocking process start");
        service.onSyncBlockingTest(time);
        return "blocking test end";
    }

    @GetMapping ("/nonBlocking")
    public String nonBlockingProcess (@RequestParam (value = "time") Long time) {
        log.info("nonBlocking process start");
        service.onAsyncBlockingTest(time);
        return "non blocking test end";
    }
}
