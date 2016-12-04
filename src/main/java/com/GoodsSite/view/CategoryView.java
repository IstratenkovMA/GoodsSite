package com.GoodsSite.view;

import java.io.Serializable;
import java.util.List;


public class CategoryView implements Serializable {

    private Long categoryId;

    private String categoryName;

    private List<GoodsTypeView> goodsTypeSet;

    public CategoryView() {
    }

    public CategoryView(Long categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryView(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<GoodsTypeView> getGoodsTypeSet() {
        return goodsTypeSet;
    }

    public void setGoodsTypeSet(List<GoodsTypeView> goodsTypeSet) {
        this.goodsTypeSet = goodsTypeSet;
    }
}
