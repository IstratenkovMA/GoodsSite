package com.GoodsSite.client.service.categoryService;


import com.GoodsSite.view.CategoryView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


import java.util.List;

@RemoteServiceRelativePath("CategoryService")
public interface CategoryService extends RemoteService {

    List<CategoryView> getAll();
    CategoryView addOrUpdate(CategoryView category);
    CategoryView getByName(String name);

    public static class App {
        private static CategoryServiceAsync ourInstance = GWT.create(CategoryService.class);
        public static synchronized CategoryServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
