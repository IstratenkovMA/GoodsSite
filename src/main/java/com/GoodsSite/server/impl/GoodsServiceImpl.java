package com.GoodsSite.server.impl;

import com.GoodsSite.client.service.goodsService.GoodsService;
import com.GoodsSite.view.GoodsView;
import com.GoodsSite.controller.GoodsSpringDataService;
import com.GoodsSite.server.AutowiringRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GoodsServiceImpl  extends AutowiringRemoteServiceServlet implements GoodsService {

    @Autowired
    private transient GoodsSpringDataService service;

    public List<GoodsView> getAll() {
        return service.getAll();
    }

    @Override
    public List<GoodsView> getAllByGoodsTypeId(Long goodsTypeId) {
        return service.getAllByGoodsTypeId(goodsTypeId);
    }
}
