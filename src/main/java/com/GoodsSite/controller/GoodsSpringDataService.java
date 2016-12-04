package com.GoodsSite.controller;


import com.GoodsSite.model.entity.Goods;
import com.GoodsSite.view.GoodsView;
import com.GoodsSite.model.repository.GoodsRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GoodsSpringDataService {
    @Autowired
    private GoodsRepository repository;

    @Autowired
    private transient Mapper mapper;

    public GoodsSpringDataService() {
    }

    public GoodsView mapEntity(Goods goods){
        return mapper.map(goods, GoodsView.class);
    }

    private List<GoodsView> mapEntity(List<Goods> goods){
        ArrayList<GoodsView> goodsViewList = new ArrayList<GoodsView>();
        for(Goods g : goods){
            goodsViewList.add(mapper.map(g, GoodsView.class));
        }
        return goodsViewList;
    }

    public GoodsView addOrUpdate(Goods goods){
        return mapEntity(repository.save(goods));
    }

    public void delete(long id){
        repository.delete(id);
    }

    public GoodsView getById(long id){
        return mapEntity(repository.findOne(id));
    }

    public List<GoodsView> getAllByGoodsTypeId(Long goodsTypeId){
        return mapEntity(repository.findAllByGoodsTypeId(goodsTypeId));
    }

    public List<GoodsView> getAll(){
        return mapEntity(repository.findAll());
    }
}
