package com.test.domain;

public class BaseService extends AbstractBaseService{

    private String currentUser;

    protected String getCurrentUser(){
        return currentUser;
    }
}
