package com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.middleware;

import lombok.extern.slf4j.Slf4j;

/**
 * 检查请求数量限制
 *
 * @author swzxsyh
 */
@Slf4j
public class ThrottlingMiddleware extends Middleware {

    private int requestPerMinute;
    private int request;
    private long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }

    @Override
    public boolean check(String email, String password) {
        if (System.currentTimeMillis() > currentTime + 60_000) {
            request = 0;
            currentTime = System.currentTimeMillis();
        }

        request++;

        if (request > requestPerMinute) {
            log.info("Request limit exceeded!");
            Thread.currentThread().stop();
        }

        return checkNext(email, password);
    }
}
