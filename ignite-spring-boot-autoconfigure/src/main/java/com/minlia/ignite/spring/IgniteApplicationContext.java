package com.minlia.ignite.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IgniteApplicationContext extends AnnotationConfigApplicationContext {

    public IgniteApplicationContext() {
        super(new IgniteBeanFactory());
    }
}
