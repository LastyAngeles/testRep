package com.company.springproject.processor;

import com.company.springproject.annotation.InjectSpecialID;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.UUID;

@Component
public class ApplicationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field tmpField : fields){
            if (tmpField.isAnnotationPresent(InjectSpecialID.class)){
                tmpField.setAccessible(true);
                ReflectionUtils.setField(tmpField, bean, UUID.randomUUID().toString());
            }
        }
        return bean;
    }
}
