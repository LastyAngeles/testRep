package com.company.springproject;

import com.company.springproject.service.MegaServiceBean;
import com.company.springproject.service.TestBeanSpecial;
import com.company.springproject.service.TestBeanNonSpecial;
import com.company.springproject.config.ConfigurationPackageTest;
import com.company.springproject.config.ConfigurationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationPackageTest.class);
        MegaServiceBean megaBean = context.getBean(MegaServiceBean.class);
        System.out.println(megaBean.getCustomService().getTypeValue());

    }

    private static void newBasedTypeSecondary() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationPackageTest.class);
        TestBeanSpecial one = context.getBean(TestBeanSpecial.class);
        TestBeanNonSpecial two = context.getBean(TestBeanNonSpecial.class);
    }

    private static void newBasedType() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationTest.class);
        TestBeanSpecial one = context.getBean(TestBeanSpecial.class);
        TestBeanNonSpecial two = context.getBean(TestBeanNonSpecial.class);
    }

    private static void oldXmlType() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        TestBeanSpecial one = context.getBean(TestBeanSpecial.class);
        TestBeanNonSpecial two = context.getBean(TestBeanNonSpecial.class);
    }
}
