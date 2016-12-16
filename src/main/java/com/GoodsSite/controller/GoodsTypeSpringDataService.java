package com.GoodsSite.controller;


import com.GoodsSite.model.entity.Category;
import com.GoodsSite.model.entity.GoodsType;
import com.GoodsSite.model.repository.CategoryRepository;
import com.GoodsSite.view.CategoryView;
import com.GoodsSite.view.GoodsTypeView;
import com.GoodsSite.model.repository.GoodsTypeRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GoodsTypeSpringDataService {

    @Autowired
    private GoodsTypeRepository repository;

    @Autowired
    private Mapper mapper;

    public GoodsTypeSpringDataService() {
    }

    private GoodsTypeView mapEntity(GoodsType goodsType){
        return mapper.map(goodsType, GoodsTypeView.class);
    }

    private List<GoodsTypeView> mapEntity(List<GoodsType> goodsTypes){
        ArrayList<GoodsTypeView> viewList = new ArrayList<GoodsTypeView>();
        for(GoodsType goodsType : goodsTypes) {
            viewList.add(mapper.map(goodsType, GoodsTypeView.class));
        }
        return viewList;
    }

    public GoodsTypeView addOrUpdate(GoodsTypeView goodsType){
        CategoryView category = new CategorySpringDataService().
                getByName(goodsType.getCategory().getCategoryName());
        return mapEntity(repository.save(new GoodsType(goodsType.getGoodsTypeName(),
                new Category(category.getCategoryId(), category.getCategoryName()))));

    }

    public void delete(long id){
        repository.delete(id);
    }

    public GoodsTypeView getById(long id){
        return mapEntity(repository.findOne(id));
    }

    public List<GoodsTypeView> getAllByCategoryId(Long categoryId){
        return mapEntity(repository.findAllByCategoryId(categoryId));
    }

    public GoodsTypeView getByName(String name){
        return mapEntity(repository.findByName(name));
    }

    public List<GoodsTypeView> getAll(){
        return mapEntity(repository.findAll());
    }
}
