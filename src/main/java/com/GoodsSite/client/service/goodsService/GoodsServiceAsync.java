package com.GoodsSite.client.service.goodsService;

import com.GoodsSite.view.GoodsView;
import com.google.gwt.user.client.rpc.AsyncCallback;


import java.util.List;


public interface GoodsServiceAsync {
    void getAll(AsyncCallback<List<GoodsView>> async);

    void getAllByGoodsTypeId(Long goodsTypeId, AsyncCallback<List<GoodsView>> async);
}
