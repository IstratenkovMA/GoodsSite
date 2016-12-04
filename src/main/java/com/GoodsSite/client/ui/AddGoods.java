package com.GoodsSite.client.ui;


import com.GoodsSite.client.service.categoryService.CategoryService;
import com.GoodsSite.view.CategoryView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

public class AddGoods extends VerticalPanel{//ui element to create good with creating category and type

    public VerticalPanel init() {
        // Create a panel to layout the widgets
        VerticalPanel vpanel = new VerticalPanel();
        vpanel.setSpacing(5);

        vpanel.add(createCategoryLine());
        // Return the panel
        return vpanel;
    }

    private HorizontalPanel createCategoryLine(){
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(20);
        panel.add(new Label("Категория товара:"));

        // Add a drop box with the list types
        final ListBox categoryListBox = new ListBox();
        categoryListBox.addItem("-выберите категорию-");
        CategoryService.App.getInstance().getAll(new AsyncCallback<List<CategoryView>>() {
            @Override
            public void onFailure(Throwable throwable) {
            }
            @Override
            public void onSuccess(List<CategoryView> categoryViews) {
                for (CategoryView category : categoryViews) {
                    categoryListBox.addItem(category.getCategoryName());
                }
            }
        });
        panel.add(categoryListBox);
        panel.add(new Label("Добавить новую категорию:"));

        final TextBox newCategoryName = new TextBox();
        panel.add(newCategoryName);

        Button addCategoryButton = new Button();
        addCategoryButton.setText("Добавить категорию");
        addCategoryButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if(newCategoryName.equals("")) {
                    Window.alert("test alert! (if something goes wrong)");
                }
                else {
                    addCategory(newCategoryName.getText());
                    newCategoryName.setText("");
                }
            }
        });
        panel.add(addCategoryButton);
        return panel;
    }

    private void addCategory(final String categoryName){
        CategoryService.App.getInstance().addOrUpdate(new CategoryView(categoryName), new AsyncCallback<CategoryView>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Ошибка при добавлении категории " + throwable.getMessage());
            }

            @Override
            public void onSuccess(CategoryView categoryView) {
                Window.alert("Категория \"" + categoryName + "\" добавлена");
            }
        });
    }
    private HorizontalPanel createWidget(String labelText
            ,final Widget widget) {
        // Add the text box and label to a panel
        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setSpacing(4);
        final Label label = new Label();
        label.setText(labelText);
        hPanel.add(label);

        // Create the new label

        hPanel.add(widget);
        // Return the panel
        return hPanel;
    }
}
