package com.test.loop.loop.impl;

import com.test.loop.loop.LoopBeanB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoopBeanBImpl implements LoopBeanB {

    @Autowired
    private LoopBeanAImpl loopBeanA;

}
