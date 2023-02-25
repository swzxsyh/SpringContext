package com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.middleware;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 检查用户角色
 *
 * @author swzxsyh
 */
@Slf4j
public class RoleCheckMiddleware extends Middleware {

    @Override
    public boolean check(String email, String password) {
        if(Objects.equals(email, "admin@example.com")){
            log.info("Hello, admin!");
            return true;
        }
        log.info("Hello, user!");
        return checkNext(email,password);
    }
}
