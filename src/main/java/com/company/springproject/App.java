package com.company.springproject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args ) {

    }

    private static void newBasedTypeSecondary() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationTestTwo.class);
        TestBeanOne one = context.getBean(TestBeanOne.class);
        TestBeanTwo two = context.getBean(TestBeanTwo.class);
    }

    private static void newBasedType() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationTest.class);
        TestBeanOne one = context.getBean(TestBeanOne.class);
        TestBeanTwo two = context.getBean(TestBeanTwo.class);
    }

    private static void oldXmlType() {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        TestBeanOne one = context.getBean(TestBeanOne.class);
        TestBeanTwo two = context.getBean(TestBeanTwo.class);
    }
}
