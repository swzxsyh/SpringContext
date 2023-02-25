package com.test.application.designPatten.behavioralPattern.chainOfResponsibilityPattern.middleware;

import java.util.Objects;

/**
 * 基础验证接口
 *
 * @author swzxsyh
 */
public abstract class Middleware {

    private Middleware next;

    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(String email, String password);

    protected boolean checkNext(String email, String password) {
        return Objects.isNull(next) ? Boolean.TRUE : next.check(email, password);
    }
}
