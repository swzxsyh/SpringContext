package com.test.facade.controller;

import com.test.ioc.aop.use.cglib.log.LogAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/async")
public class AsyncController {

    @LogAdvice
    @GetMapping("/get")
    public Callable<String> asyncGet() {
        return () -> {
            log.info("Thread start");
            return "Success";
        };
    }

    @GetMapping("/deferredGet")
    public DeferredResult<String> deferredGet() {
        DeferredResult<String> result = new DeferredResult<>((long) 3000);
        result.setResult("Success");
        return result;
    }

    @GetMapping("/{id}")
    public Callable<?> getById(@PathVariable Integer id) {
        return () -> "Success";
    }

    @Async
    @GetMapping("/thread-pool/async")
    public CompletableFuture<String> async() throws ExecutionException {
        log.info("Thread:{}", Thread.currentThread().getName());
        return CompletableFuture.completedFuture(new AsyncResult<>("Success").get());
    }
}
