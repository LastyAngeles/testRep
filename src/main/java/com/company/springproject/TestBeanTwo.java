package com.company.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBeanTwo {

    @Value(Constant.NON_SPECIAL_VALUE)
    private String type;

    //field without inject for test special
    private TestBeanOne beanOne;

    public TestBeanTwo(String type, TestBeanOne beanOne) {
        this.type = type;
        this.beanOne = beanOne;
    }

    public TestBeanTwo(String type) {
        this.type = type;
    }

    public TestBeanTwo( ) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TestBeanOne getBeanOne() {
        return beanOne;
    }

    public void setBeanOne(TestBeanOne beanOne) {
        this.beanOne = beanOne;
    }
}
