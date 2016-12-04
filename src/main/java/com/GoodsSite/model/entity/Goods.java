package com.GoodsSite.model.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "goods_name")
    private String goodsName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "goods_type_id", nullable = false)
    private GoodsType goodsType;

    @ManyToMany
    @JoinTable(name="goods_parameter",
            joinColumns = @JoinColumn(name="goods_id", referencedColumnName="goods_id"),
            inverseJoinColumns = @JoinColumn(name="parameter_id", referencedColumnName="parameter_id")
    )
    private List<Parameter> parameters;

    public Goods(){
    }

    public Goods(String goodsName) {
        this.goodsName = goodsName;
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

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }
}
