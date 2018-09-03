package com.company.springproject.service;

import com.company.springproject.annotation.InjectSpecialID;
import com.company.springproject.consts.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MegaServiceBean {

    @InjectSpecialID
    private String specialIdNum;

    @Value(Constant.NON_SPECIAL_VALUE)
    private String type;

    @Autowired
    private CustomService customService;

    public MegaServiceBean(String type, CustomService customService) {
        this.customService = customService;
    }

    public MegaServiceBean() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CustomService getCustomService() {
        return customService;
    }

    public String getSpecialIdNum() {
        return specialIdNum;
    }

    public void setSpecialIdNum(String specialIdNum) {
        this.specialIdNum = specialIdNum;
    }
}
