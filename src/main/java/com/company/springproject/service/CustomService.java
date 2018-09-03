package com.company.springproject.service;

import com.company.springproject.consts.Constant;

public interface CustomService {
    String typeValue = Constant.INTERFACE_TYPE_VALUE;
    public String getTypeValue();
    public void setTypeValue(String typeValue);
}
