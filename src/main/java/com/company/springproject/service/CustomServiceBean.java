package com.company.springproject.service;

import com.company.springproject.consts.Constant;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class CustomServiceBean implements CustomService{

    private String typeValue = Constant.NON_BASE_TYPE_VALUE;

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
}
