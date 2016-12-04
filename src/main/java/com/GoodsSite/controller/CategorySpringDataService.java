package com.GoodsSite.controller;

import com.GoodsSite.model.entity.Category;
import com.GoodsSite.model.repository.CategoryRepository;
import com.GoodsSite.view.CategoryView;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CategorySpringDataService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private Mapper mapper;

    public CategorySpringDataService() {
    }

    private CategoryView mapEntity(Category category){
        return mapper.map(category, CategoryView.class);
    }

    private List<CategoryView> mapEntity(List<Category> categories){
        ArrayList<CategoryView> viewList = new ArrayList<CategoryView>();
        for (Category category : categories) {
            viewList.add(mapEntity(category));
        }
        return viewList;
    }

    public CategoryView addOrUpdate(CategoryView category){
        return mapEntity(repository.save(new Category(category.getCategoryName())));
    }

    public void delete(long id){
        repository.delete(id);
    }

    public CategoryView getById(long id){
        return mapEntity(repository.findOne(id));
    }

    public List<CategoryView> getAll(){
        return mapEntity(repository.findAll());
    }

    public CategoryView getByName(String name){
        return mapEntity(repository.findByName(name));
    }
}
