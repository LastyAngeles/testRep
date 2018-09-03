package com.company.springproject;

import static org.junit.Assert.*;

import com.company.springproject.service.MegaServiceBean;
import com.company.springproject.service.TestBeanSpecial;
import com.company.springproject.service.TestBeanProtScope;
import com.company.springproject.service.TestBeanNonSpecial;
import com.company.springproject.config.ConfigurationPackageTest;
import com.company.springproject.consts.Constant;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTests {
    TestBeanSpecial beanOne;
    TestBeanSpecial beanOneXml;
    TestBeanNonSpecial beanTwo;
    TestBeanNonSpecial beanTwoXml;
    MegaServiceBean megaServiceBean;
    ApplicationContext javaBasedContext;
    ApplicationContext xmlBasedContext;

    @Before
    public void initTests(){
        javaBasedContext = new AnnotationConfigApplicationContext(ConfigurationPackageTest.class);
        xmlBasedContext = new ClassPathXmlApplicationContext("config.xml");
        beanOne = javaBasedContext.getBean(TestBeanSpecial.class);
        beanOneXml = xmlBasedContext.getBean(TestBeanSpecial.class);
        beanTwo = javaBasedContext.getBean(TestBeanNonSpecial.class);
        beanTwoXml = xmlBasedContext.getBean(TestBeanNonSpecial.class);
        megaServiceBean = javaBasedContext.getBean(MegaServiceBean.class);
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
        assertEquals(javaBasedContext.getBean(TestBeanSpecial.class), javaBasedContext.getBean(TestBeanSpecial.class));
        assertEquals(javaBasedContext.getBean(TestBeanNonSpecial.class), javaBasedContext.getBean(TestBeanNonSpecial.class));
    }

    @Test
    public void beanThreeIsPrototype(){
        assertNotEquals(javaBasedContext.getBean(TestBeanProtScope.class), javaBasedContext.getBean(TestBeanProtScope.class));
    }

    @Test
    public void xmlBeansNotNull(){
        assertNotNull(xmlBasedContext.getBean(TestBeanSpecial.class));
        assertNotNull(xmlBasedContext.getBean(TestBeanNonSpecial.class));
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
        assertNotEquals(xmlBasedContext.getBean(TestBeanSpecial.class), xmlBasedContext.getBean(TestBeanSpecial.class));
    }

    @Test
    public void xmlBeanTwoIsSingleton(){
        assertEquals(xmlBasedContext.getBean(TestBeanNonSpecial.class), xmlBasedContext.getBean(TestBeanNonSpecial.class));
    }

    @Test
    public void xmlBeansTypeIsCorrect(){
        assertEquals(Constant.XML_NON_SPECIAL_VALUE, beanTwoXml.getType());
        assertEquals(Constant.XML_SPECIAL_VALUE, beanOneXml.getType());
    }

    @Test
    public void beanFactoryTestForServiceBeanReplacement(){
        assertEquals(Constant.BASE_TYPE_VALUE, megaServiceBean.getCustomService().getTypeValue());
    }

    @Test
    public void injectBeforeInitIsCorrect(){
        assertNotNull(megaServiceBean.getSpecialIdNum());
    }

}
