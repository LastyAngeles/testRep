package com.company.springproject.service;

import com.company.springproject.consts.Constant;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestBeanNonSpecial {

    @Value(Constant.NON_SPECIAL_VALUE)
    private String type;

    //field without inject for test special
    private TestBeanSpecial beanOne;

    public TestBeanNonSpecial(String type, TestBeanSpecial beanOne) {
        this.type = type;
        this.beanOne = beanOne;
    }

    public TestBeanNonSpecial(String type) {
        this.type = type;
    }

    public TestBeanNonSpecial( ) {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TestBeanSpecial getBeanOne() {
        return beanOne;
    }

    public void setBeanOne(TestBeanSpecial beanOne) {
        this.beanOne = beanOne;
    }
}
