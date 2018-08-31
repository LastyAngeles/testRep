package com.company.springproject;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTests {
    TestBeanOne beanOne;
    TestBeanOne beanOneXml;
    TestBeanTwo beanTwo;
    TestBeanTwo beanTwoXml;
    ApplicationContext javaBasedContext;
    ApplicationContext xmlBasedContext;

    @Before
    public void initTests(){
        javaBasedContext = new AnnotationConfigApplicationContext(ConfigurationTestTwo.class);
        xmlBasedContext = new ClassPathXmlApplicationContext("config.xml");
        beanOne = javaBasedContext.getBean(TestBeanOne.class);
        beanOneXml = xmlBasedContext.getBean(TestBeanOne.class);
        beanTwo = javaBasedContext.getBean(TestBeanTwo.class);
        beanTwoXml = xmlBasedContext.getBean(TestBeanTwo.class);
    }

    @Test
    public void beansNotNull(){
        assertNotNull(beanOne);
        assertNotNull(beanTwo);
    }

    @Test
    public void beanTwoIncludedIntoBeanOne(){
        assertNotNull(beanOne.getBeanTwo());
    }

    @Test
    public void beanOneNotIncludedIntoBeanTwo(){
        assertNull(beanTwo.getBeanOne());
    }

    @Test
    public void beanOneTypeIsSpecial(){
        assertEquals(Constant.SPECIAL_VALUE, beanOne.getType());
    }

    @Test
    public void beanOneTypeIsNotSpecial(){
        assertEquals(Constant.NON_SPECIAL_VALUE, beanTwo.getType());
    }

    @Test
    public void beanOneAndTwoIsSingleton(){
        assertEquals(javaBasedContext.getBean(TestBeanOne.class), javaBasedContext.getBean(TestBeanOne.class));
        assertEquals(javaBasedContext.getBean(TestBeanTwo.class), javaBasedContext.getBean(TestBeanTwo.class));
    }

    @Test
    public void beanThreeIsPrototype(){
        assertNotEquals(javaBasedContext.getBean(TestBeanThree.class), javaBasedContext.getBean(TestBeanThree.class));
    }

    @Test
    public void xmlBeansNotNull(){
        assertNotNull(xmlBasedContext.getBean(TestBeanOne.class));
        assertNotNull(xmlBasedContext.getBean(TestBeanTwo.class));
    }

    @Test
    public void xmlBeanOneTypeIsSpecial(){
        assertEquals(Constant.XML_SPECIAL_VALUE, beanOneXml.getType());
    }

    @Test
    public void xmlBeanTwoTypeIsNonSpecial(){
        assertEquals(Constant.XML_NON_SPECIAL_VALUE, beanTwoXml.getType());
    }

    @Test
    public void xmlBeanOneIsPrototype(){
        assertNotEquals(xmlBasedContext.getBean(TestBeanOne.class), xmlBasedContext.getBean(TestBeanOne.class));
    }

    @Test
    public void xmlBeanTwoIsSingleton(){
        assertEquals(xmlBasedContext.getBean(TestBeanTwo.class), xmlBasedContext.getBean(TestBeanTwo.class));
    }

    @Test
    public void xmlBeansTypeIsCorrect(){
        assertEquals(Constant.XML_NON_SPECIAL_VALUE, beanTwoXml.getType());
        assertEquals(Constant.XML_SPECIAL_VALUE, beanOneXml.getType());
    }

}
