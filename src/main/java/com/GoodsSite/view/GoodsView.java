package com.GoodsSite.view;


import java.io.Serializable;

public class GoodsView implements Serializable{

    private Long goodsId;

    private String goodsName;

    private GoodsTypeView goodsType;

    public GoodsView() {
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

}
