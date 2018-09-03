package com.company.springproject.processor;

import com.company.springproject.service.CustomServiceBean;
import com.company.springproject.service.CustomServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class ApplicationBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        final String[] names= configurableListableBeanFactory.getBeanDefinitionNames();
        for (String name : names){
            final BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            final String className = beanDefinition.getBeanClassName();
            try {
                final Class originalClass = Class.forName(className);
                if (CustomServiceBean.class.equals(originalClass)){
                    beanDefinition.setBeanClassName(CustomServiceImpl.class.getName());
                }
            }
            catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }
        }
    }

}