package com.GoodsSite.client.service.goodsTypeService;

import com.GoodsSite.view.GoodsTypeView;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;


public interface GoodsTypeServiceAsync {

    void getAll(AsyncCallback<List<GoodsTypeView>> async);
    void getByName(String name, AsyncCallback<GoodsTypeView> async);
    void getAllByCategoryId(Long categoryId, AsyncCallback<List<GoodsTypeView>> async);

    void addOrUpdate(GoodsTypeView goodsType, AsyncCallback<GoodsTypeView> async);
}
