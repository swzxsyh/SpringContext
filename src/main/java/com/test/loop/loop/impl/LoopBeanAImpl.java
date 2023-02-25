package com.test.loop.loop.impl;

import com.test.loop.loop.LoopBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoopBeanAImpl implements LoopBeanA {

    @Autowired
    private LoopBeanBImpl loopBeanB;
}
