package com.GoodsSite.client.ui;


import com.GoodsSite.client.service.categoryService.CategoryService;
import com.GoodsSite.client.service.goodsService.GoodsService;
import com.GoodsSite.client.service.goodsTypeService.GoodsTypeService;
import com.GoodsSite.model.entity.Category;
import com.GoodsSite.view.CategoryView;
import com.GoodsSite.view.GoodsTypeView;
import com.GoodsSite.view.GoodsView;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.List;

public class AddElements extends VerticalPanel {//ui element to create good with creating category and type

    public VerticalPanel init(){
        final Tree categoryTree = getTree();



        categoryTree.setAnimationEnabled(true);

        add(categoryTree);
        Button backToNormalView = new Button("Выйти из режима редактирования");
        backToNormalView.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                History.newItem("GoodsTree");
            }
        });
        add(backToNormalView);
        return this;
    }



    private HorizontalPanel addNewCategoryLine() {
        final TextBox newCategoryTextBox = new TextBox();
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(5);
        panel.add(new Label("Добавить новую категорию:"));

        panel.add(newCategoryTextBox);

        Button addCategoryButton = new Button();
        addCategoryButton.setText("Добавить категорию");
        addCategoryButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (newCategoryTextBox.getText().equals("")) {
                    Window.alert("Ошибка, при добавлении категории (нажатие на кнопку)");
                } else {
                    addCategory(newCategoryTextBox.getText());
                    newCategoryTextBox.setText("");
                }
            }
        });
        panel.add(addCategoryButton);
        return panel;
    }

    private void addCategory(final String categoryName) {
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


    private HorizontalPanel addNewGoodsTypeLine(final CategoryView categoryView){
        final TextBox newGoodsTypeTextBox = new TextBox();
        HorizontalPanel panel = new HorizontalPanel();
        panel.setSpacing(5);
        panel.add(new Label("Добавить новый тип:"));

        panel.add(newGoodsTypeTextBox);

        Button addCategoryButton = new Button();
        addCategoryButton.setText("Добавить тип");
        addCategoryButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (newGoodsTypeTextBox.getText().equals("")) {
                    Window.alert("Ошибка, при добавлении типа (нажатие на кнопку)");
                } else {
                    addType(newGoodsTypeTextBox.getText(), categoryView);
                    newGoodsTypeTextBox.setText("");
                }
            }
        });
        panel.add(addCategoryButton);
        return panel;
    }

    private void addType(final String typeName, final CategoryView categoryView){
        GoodsTypeService.App.getInstance().addOrUpdate(new GoodsTypeView(typeName, categoryView),
                new AsyncCallback<GoodsTypeView>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Ошибка при добавлении типа " + typeName + " категории("
                        + categoryView.getCategoryName() + ") " +  throwable.getMessage());
            }
            @Override
            public void onSuccess(GoodsTypeView goodsTypeView) {
                Window.alert("Категория \"" + typeName + "\" добавлена");
            }
        });
    }



    private Tree getTree(){
        final Tree categoryTree = new Tree();
        CategoryService.App.getInstance().getAll(new AsyncCallback<List<CategoryView>>() {
            @Override
            public void onFailure(Throwable throwable) {
            }
            @Override
            public void onSuccess(List<CategoryView> categoryViews) {
                for (CategoryView category : categoryViews) {
                    categoryTree.addItem(initCategory(category));
                }
                categoryTree.addItem(addNewCategoryLine());
            }
        });
        return categoryTree;
    }
    private TreeItem initCategory(final CategoryView categoryView) {
        final TreeItem category = new TreeItem();
        category.setText(categoryView.getCategoryName());
        GoodsTypeService.App.getInstance().getAllByCategoryId(categoryView.getCategoryId(), new AsyncCallback<List<GoodsTypeView>>() {
            @Override
            public void onFailure(Throwable throwable) {
            }
            @Override
            public void onSuccess(List<GoodsTypeView> goodsTypeViews) {
                for (GoodsTypeView type : goodsTypeViews) {
                    TreeItem newType = initType(type);
                    Hyperlink hyperlink = new Hyperlink();
                    hyperlink.setText(type.getGoodsTypeName());
                    hyperlink.setTargetHistoryToken("AddNewGoods+t=" + type.getGoodsTypeName());
                    category.addItem(newType);
                    category.addItem(hyperlink);
                }
                category.addItem(addNewGoodsTypeLine(categoryView));
            }
        });
        return category;
    }
    private TreeItem initType(GoodsTypeView typeView) {
        final TreeItem type = new TreeItem();
        type.setText(typeView.getGoodsTypeName());
        GoodsService.App.getInstance().getAllByGoodsTypeId(typeView.getGoodsTypeId(), new AsyncCallback<List<GoodsView>>() {
            @Override
            public void onFailure(Throwable throwable) {
            }
            @Override
            public void onSuccess(List<GoodsView> goodsViews) {
                for (GoodsView goods: goodsViews) {
                    TreeItem item = new TreeItem();
                    item.setText(goods.getGoodsName());
                    type.addItem(item);
                }
            }
        });
        return type;
    }

}
