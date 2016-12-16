package com.GoodsSite.view;


import java.io.Serializable;
import java.util.List;

public class GoodsView implements Serializable{

    private Long goodsId;

    private String goodsName;

    private GoodsTypeView goodsType;

    private List<ParameterView> parameters;

    public GoodsView() {
    }

    public GoodsView(String goodsName, GoodsTypeView goodsType, List<ParameterView> parameters) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.parameters = parameters;
    }

    public GoodsView(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public GoodsTypeView getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsTypeView goodsType) {
        this.goodsType = goodsType;
    }

    public List<ParameterView> getParameters() {
        return parameters;
    }

    public void setParameters(List<ParameterView> parameters) {
        this.parameters = parameters;
    }
}
