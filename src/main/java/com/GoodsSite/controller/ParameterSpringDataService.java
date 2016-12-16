package com.GoodsSite.controller;


import com.GoodsSite.model.entity.Parameter;
import com.GoodsSite.model.entity.ParameterValue;
import com.GoodsSite.model.repository.ParameterRepository;
import com.GoodsSite.model.repository.ParameterValueRepository;
import com.GoodsSite.view.ParameterView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ParameterSpringDataService {

    @Autowired
    private ParameterRepository repository;

    @Autowired
    private ParameterValueRepository valueRepository;

    @Autowired
    private Mapper mapper;

    public ParameterSpringDataService() {
    }

    public ParameterView mapEntity(Parameter parameter){
        return mapper.map(parameter, ParameterView.class);
    }

    public List<ParameterView> mapEntity(List<Parameter> parameters){
        List<ParameterView> viewList = new ArrayList<>();
        for(Parameter parameter : parameters)
            viewList.add(mapper.map(parameter, ParameterView.class));
        return viewList;
    }

    public ParameterView addOrUpdate(ParameterView parameterView){
        if(valueRepository.findByValue(parameterView.getValue().getParameterValueValue()) != null) {
            return mapEntity(repository.save(new Parameter(parameterView.getParameterName(),
                    valueRepository.findByValue(parameterView.getValue().getParameterValueValue()))));
        }
        else{
            return mapEntity(repository.save(new Parameter(parameterView.getParameterName(),
                    new ParameterValue(parameterView.getValue().getParameterValueValue()))));
        }

    }
}
