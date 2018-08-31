package com.company.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBeanOne {

    @Value(Constant.SPECIAL_VALUE)
    private String type;

    @Autowired
    private TestBeanTwo beanTwo;

    public TestBeanOne(String type) {
        this.type = type;
    }

    public TestBeanOne(String type, TestBeanTwo beanTwo) {
        this.type = type;
        this.beanTwo = beanTwo;
    }

    public TestBeanOne( ) {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TestBeanTwo getBeanTwo() {
        return beanTwo;
    }

    public void setBeanTwo(TestBeanTwo beanTwo) {
        this.beanTwo = beanTwo;
    }
}
