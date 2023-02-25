package com.test.application.designPatten.creationalPattern.singletonPattern;

import java.util.Objects;

public final class Singleton {

    private static volatile Singleton instance;

    public String value;

    public Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value){
        Singleton result = instance;
        if(Objects.nonNull(result)){
            return result;
        }

        synchronized (Singleton.class){
            if(Objects.isNull(instance)){
                instance = new Singleton(value);
            }
            return instance;
        }
    }
}
