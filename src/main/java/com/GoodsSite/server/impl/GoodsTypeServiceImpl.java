package com.GoodsSite.server.impl;

import com.GoodsSite.client.service.goodsTypeService.GoodsTypeService;
import com.GoodsSite.view.GoodsTypeView;
import com.GoodsSite.controller.GoodsTypeSpringDataService;
import com.GoodsSite.server.AutowiringRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsTypeServiceImpl extends AutowiringRemoteServiceServlet implements GoodsTypeService {
    @Autowired
    private transient GoodsTypeSpringDataService service;

    @Override
    public GoodsTypeView addOrUpdate(GoodsTypeView goodsType) {
        return service.addOrUpdate(goodsType);
    }

    public List<GoodsTypeView> getAll() {
        return service.getAll();
    }

    @Override
    public List<GoodsTypeView> getAllByCategoryId(Long categoryId) {
        return service.getAllByCategoryId(categoryId);
    }

    public GoodsTypeView getByName(String name) {
        return service.getByName(name);
    }
}
