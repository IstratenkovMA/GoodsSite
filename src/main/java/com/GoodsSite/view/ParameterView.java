package com.GoodsSite.view;


import java.io.Serializable;
import java.util.List;

public class ParameterView implements Serializable {

    private Long parameterId;

    private String parameterName;

    private ParameterValueView value;

    private List<GoodsView> goods;

    public ParameterView() {
    }

    public ParameterView(String parameterName, ParameterValueView value, List<GoodsView> goods) {
        this.parameterName = parameterName;
        this.value = value;
        this.goods = goods;
    }

    public ParameterView(String parameterName, ParameterValueView value) {
        this.parameterName = parameterName;
        this.value = value;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public ParameterValueView getValue() {
        return value;
    }

    public void setValue(ParameterValueView value) {
        this.value = value;
    }

    public List<GoodsView> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsView> goods) {
        this.goods = goods;
    }
}
