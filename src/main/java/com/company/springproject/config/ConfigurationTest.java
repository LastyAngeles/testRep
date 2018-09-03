package com.company.springproject.config;

import com.company.springproject.service.TestBeanSpecial;
import com.company.springproject.service.TestBeanNonSpecial;
import com.company.springproject.consts.Constant;
import org.springframework.context.annotation.Bean;

// not used
//@Configuration
public class ConfigurationTest {
    @Bean
    public TestBeanSpecial createBeanOne(){
        return new TestBeanSpecial(Constant.SPECIAL_VALUE);
    }
    @Bean
    public TestBeanNonSpecial createBeanTwo(TestBeanSpecial bean){
        return new TestBeanNonSpecial(Constant.NON_SPECIAL_VALUE, bean);
    }
}
