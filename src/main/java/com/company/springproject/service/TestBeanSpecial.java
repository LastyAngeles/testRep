package com.company.springproject.service;

import com.company.springproject.consts.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBeanSpecial {

    @Value(Constant.SPECIAL_VALUE)
    private String type;

    @Autowired
    private TestBeanNonSpecial beanTwo;

    public TestBeanSpecial(String type) {
        this.type = type;
    }

    public TestBeanSpecial(String type, TestBeanNonSpecial beanTwo) {
        this.type = type;
        this.beanTwo = beanTwo;
    }

    public TestBeanSpecial( ) {

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TestBeanNonSpecial getBeanTwo() {
        return beanTwo;
    }

    public void setBeanTwo(TestBeanNonSpecial beanTwo) {
        this.beanTwo = beanTwo;
    }
}
