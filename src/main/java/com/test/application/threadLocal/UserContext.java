package com.test.application.threadLocal;

import com.test.infrastructure.utils.SpringUtils;

import java.util.HashMap;
import java.util.Map;

public class UserContext {

    private static final ThreadLocal<String> THREAD_LOCAL = new ThreadLocal<>();

    public void test() {
        try {
            String value = SpringUtils.getValue("test", "test");
            THREAD_LOCAL.set(value);
        } catch (Exception e) {
            System.out.println(THREAD_LOCAL.get());
        } finally {
            THREAD_LOCAL.remove();
        }
    }
}
