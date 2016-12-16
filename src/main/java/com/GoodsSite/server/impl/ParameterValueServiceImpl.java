package com.GoodsSite.server.impl;

import com.GoodsSite.client.service.parameterValueService.ParameterValueService;
import com.GoodsSite.controller.ParameterValueSpringDataService;
import com.GoodsSite.server.AutowiringRemoteServiceServlet;
import com.GoodsSite.view.ParameterValueView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParameterValueServiceImpl extends AutowiringRemoteServiceServlet implements ParameterValueService {

    @Autowired
    private transient ParameterValueSpringDataService service;

    @Override
    public ParameterValueView addOrUpdate(ParameterValueView parameterValue) {
        return service.addOrUpdate(parameterValue);
    }

    @Override
    public ParameterValueView findByValue(String value) {
        return service.findByValue(value);
    }
}
