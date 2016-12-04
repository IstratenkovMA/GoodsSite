package com.GoodsSite.client.service.goodsService;


import com.GoodsSite.view.GoodsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;


@RemoteServiceRelativePath("GoodsService")
public interface GoodsService extends RemoteService {
    List<GoodsView> getAll();
    List<GoodsView> getAllByGoodsTypeId(Long goodsTypeId);

    public static class App {

        private static GoodsServiceAsync ourInstance = GWT.create(GoodsService.class);

        public static synchronized GoodsServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
