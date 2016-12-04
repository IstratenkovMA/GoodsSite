package com.GoodsSite.view;

import java.io.Serializable;
import java.util.List;


public class GoodsTypeView implements Serializable {

    private Long goodsTypeId;

    private String goodsTypeName;

    private CategoryView category;

    private List<GoodsView> goodsSet;

    public GoodsTypeView() {
    }

    public GoodsTypeView(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Long getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Long goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public CategoryView getCategory() {
        return category;
    }

    public void setCategory(CategoryView category) {
        this.category = category;
    }

    public List<GoodsView> getGoodsSet() {
        return goodsSet;
    }

    public void setGoodsSet(List<GoodsView> goodsSet) {
        this.goodsSet = goodsSet;
    }
}
