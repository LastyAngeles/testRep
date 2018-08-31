package com.company.springproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// not used
//@Configuration
public class ConfigurationTest {
    @Bean
    public TestBeanOne createBeanOne(){
        return new TestBeanOne(Constant.SPECIAL_VALUE);
    }
    @Bean
    public TestBeanTwo createBeanTwo(TestBeanOne bean){
        return new TestBeanTwo(Constant.NON_SPECIAL_VALUE, bean);
    }
}
