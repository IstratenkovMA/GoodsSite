package com.GoodsSite.server.impl;

import com.GoodsSite.client.service.categoryService.CategoryService;
import com.GoodsSite.view.CategoryView;
import com.GoodsSite.controller.CategorySpringDataService;
import com.GoodsSite.server.AutowiringRemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl extends AutowiringRemoteServiceServlet implements CategoryService {

    @Autowired
    private transient CategorySpringDataService service;

    public List<CategoryView> getAll() {
        return service.getAll();
    }

    @Override
    public CategoryView addOrUpdate(CategoryView category) {
        return service.addOrUpdate(category);
    }

    public CategoryView getByName(String name) {
        return service.getByName(name);
    }
}
