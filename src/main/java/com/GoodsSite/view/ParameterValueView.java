package com.GoodsSite.view;

import java.io.Serializable;
import java.util.List;


public class ParameterValueView implements Serializable {

    private Long parameterValueId;

    private String parameterValueValue;

    private List<ParameterView> parameters;

    public ParameterValueView() {
    }

    public ParameterValueView(String parameterValueValue) {
        this.parameterValueValue = parameterValueValue;
    }

    public ParameterValueView(String parameterValueValue, List<ParameterView> parameters) {
        this.parameterValueValue = parameterValueValue;
        this.parameters = parameters;
    }

    public Long getParameterValueId() {
        return parameterValueId;
    }

    public void setParameterValueId(Long parameterValueId) {
        this.parameterValueId = parameterValueId;
    }

    public String getParameterValueValue() {
        return parameterValueValue;
    }

    public void setParameterValueValue(String parameterValueValue) {
        this.parameterValueValue = parameterValueValue;
    }

    public List<ParameterView> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterView> parameters) {
        this.parameters = parameters;
    }
}
