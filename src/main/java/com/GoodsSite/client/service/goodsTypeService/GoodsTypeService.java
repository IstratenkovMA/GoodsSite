package com.GoodsSite.client.service.goodsTypeService;


import com.GoodsSite.view.GoodsTypeView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;

@RemoteServiceRelativePath("GoodsTypeService")
public interface GoodsTypeService extends RemoteService {
    List<GoodsTypeView> getAll();
    GoodsTypeView getByName(String name);
    List<GoodsTypeView> getAllByCategoryId(Long categoryId);
    GoodsTypeView addOrUpdate(GoodsTypeView goodsType);


    public static class App {
        private static GoodsTypeServiceAsync ourInstance = GWT.create(GoodsTypeService.class);
        public static synchronized GoodsTypeServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
