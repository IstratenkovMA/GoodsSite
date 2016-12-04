package com.GoodsSite.client.ui;

import com.GoodsSite.view.CategoryView;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HTML;

public class CategoryInfo extends VerticalPanel {

    final CategoryView category;

    public CategoryInfo(CategoryView category) {
        this.category = category;
    }

    public VerticalPanel init(){

        add(new HTML("<h1>" + "Группа " + category.getCategoryName() + "</h1>"));

        return this;
    }
}
