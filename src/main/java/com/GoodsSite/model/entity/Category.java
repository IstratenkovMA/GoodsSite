package com.GoodsSite.model.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    private Set<GoodsType> goodsTypes;

    public Category(){
    }

    public Category(String categoryName){
        this.categoryName = categoryName;
    }

    public Category(Long categoryId,String categoryName){
        this.categoryId = categoryId;
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

    public Set<GoodsType> getGoodsTypes() {
        return goodsTypes;
    }

    public void setGoodsTypes(Set<GoodsType> goodsTypes) {
        this.goodsTypes = goodsTypes;
    }
}
