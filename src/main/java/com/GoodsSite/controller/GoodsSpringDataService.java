package com.GoodsSite.controller;


import com.GoodsSite.model.entity.Goods;
import com.GoodsSite.model.entity.Parameter;
import com.GoodsSite.model.repository.GoodsTypeRepository;
import com.GoodsSite.model.repository.ParameterRepository;
import com.GoodsSite.view.GoodsView;
import com.GoodsSite.model.repository.GoodsRepository;
import com.GoodsSite.view.ParameterView;
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
    private GoodsTypeRepository typeRepository;

    @Autowired
    private ParameterRepository parameterRepository;

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

    public GoodsView addOrUpdate(GoodsView goodsView){
        List<Parameter> parameters = new ArrayList<>();
        for (ParameterView paramView: goodsView.getParameters()) {
            parameters.add(parameterRepository.findByName(paramView.getParameterName()));
        }
        return mapEntity(repository.save(new Goods(goodsView.getGoodsName(),
                typeRepository.findByName(goodsView.getGoodsName()), parameters)));
    }

    public List<GoodsView> getAll(){
        return mapEntity(repository.findAll());
    }
}
