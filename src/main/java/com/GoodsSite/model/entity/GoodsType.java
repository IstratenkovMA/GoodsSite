package com.GoodsSite.model.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "goods_type")
public class GoodsType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goods_type_id")
    private Long goodsTypeId;

    @Column(name = "goods_type_name")
    private String goodsTypeName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "goodsType")
    private List<Goods> goodsList;

    public GoodsType() {
    }

    public GoodsType(String goodsTypeName, Category category) {
        this.goodsTypeName = goodsTypeName;
        this.category = category;
    }

    public GoodsType(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }
}
