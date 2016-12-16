package com.GoodsSite.server.impl;

import com.GoodsSite.client.service.parameterService.ParameterService;
import com.GoodsSite.controller.ParameterSpringDataService;
import com.GoodsSite.server.AutowiringRemoteServiceServlet;
import com.GoodsSite.view.ParameterView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParameterServiceImpl extends AutowiringRemoteServiceServlet implements ParameterService {

    @Autowired
    private transient ParameterSpringDataService service;

    @Override
    public ParameterView addOrUpdate(ParameterView parameterView) {
        return service.addOrUpdate(parameterView);
    }
}
