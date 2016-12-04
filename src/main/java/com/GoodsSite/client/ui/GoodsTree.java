package com.GoodsSite.client.ui;


import com.GoodsSite.client.service.categoryService.CategoryService;
import com.GoodsSite.client.service.goodsService.GoodsService;
import com.GoodsSite.client.service.goodsTypeService.GoodsTypeService;
import com.GoodsSite.view.CategoryView;
import com.GoodsSite.view.GoodsTypeView;
import com.GoodsSite.view.GoodsView;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.ui.Tree;

import java.util.List;


public class GoodsTree extends VerticalPanel{

    public VerticalPanel init(){
        final Tree categoryTree = getTree();

        categoryTree.setAnimationEnabled(true);
        categoryTree.ensureDebugId("cwTree-staticTree");
        ScrollPanel staticTreeWrapper = new ScrollPanel(categoryTree);
        staticTreeWrapper.ensureDebugId("cwTree-staticTree-Wrapper");
        staticTreeWrapper.setSize("300px", "300px");

        // Wrap the static tree in a DecoratorPanel
        DecoratorPanel staticDecorator = new DecoratorPanel();
        staticDecorator.setWidget(staticTreeWrapper);

        add(categoryTree);
        return this;
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
            }
        });
        return categoryTree;
    }
    private TreeItem initCategory(CategoryView categoryView) {
        final TreeItem category = new TreeItem();
        category.setText(categoryView.getCategoryName());
        GoodsTypeService.App.getInstance().getAllByCategoryId(categoryView.getCategoryId(), new AsyncCallback<List<GoodsTypeView>>() {
            @Override
            public void onFailure(Throwable throwable) {
            }
            @Override
            public void onSuccess(List<GoodsTypeView> goodsTypeViews) {
                for (GoodsTypeView type : goodsTypeViews) {
                    category.addItem(initType(type));
                }
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
