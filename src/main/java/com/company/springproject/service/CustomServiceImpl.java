package com.company.springproject.service;

import com.company.springproject.consts.Constant;
import org.springframework.stereotype.Component;

@Component
public class CustomServiceImpl implements CustomService{

    private String typeValue = Constant.BASE_TYPE_VALUE;

    public CustomServiceImpl() {

    }

    public CustomServiceImpl(String typeValue) {
        this.typeValue = typeValue;
    }

    public String getTypeValue() {
        return typeValue;
    }

    public void setTypeValue(String typeValue) {
        this.typeValue = typeValue;
    }
}
