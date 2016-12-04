package com.GoodsSite.client.service.categoryService;

import com.GoodsSite.view.CategoryView;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface CategoryServiceAsync {

    void getAll(AsyncCallback<List<CategoryView>> async);

    void getByName(String name, AsyncCallback<CategoryView> async);

    void addOrUpdate(CategoryView category, AsyncCallback<CategoryView> async);
}
