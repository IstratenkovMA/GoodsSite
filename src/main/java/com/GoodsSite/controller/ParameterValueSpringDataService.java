package com.GoodsSite.controller;

import com.GoodsSite.model.entity.ParameterValue;
import com.GoodsSite.model.repository.ParameterRepository;
import com.GoodsSite.model.repository.ParameterValueRepository;
import com.GoodsSite.view.ParameterValueView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParameterValueSpringDataService {

    @Autowired
    private ParameterValueRepository repository;

    @Autowired
    private ParameterRepository parameterRepository;

    @Autowired
    private Mapper mapper;

    private ParameterValueView mapEntity(ParameterValue parameterValue){
        return mapper.map(parameterValue, ParameterValueView.class);
    }

    private List<ParameterValueView> mapEntity(List<ParameterValue> values){
        List<ParameterValueView> viewList = new ArrayList<ParameterValueView>();
        for(ParameterValue parameterValue : values){
            viewList.add(mapEntity(parameterValue));
        }
        return viewList;
    }

    public ParameterValueView addOrUpdate(ParameterValueView parameterValue){
        if(repository.findByValue(parameterValue.getParameterValueValue()).getParameterValueValue()
                .equals(parameterValue.getParameterValueValue()))
            return findByValue(parameterValue.getParameterValueValue());
        return mapEntity(repository.save(new ParameterValue(parameterValue.getParameterValueValue())));
    }

    public ParameterValueView findByValue(String value){
        return mapEntity(repository.findByValue(value));
    }
}
