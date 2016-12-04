package com.GoodsSite.client;


import com.GoodsSite.client.ui.AddGoods;
import com.GoodsSite.client.ui.GoodsTree;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;

public class GoodsSite implements EntryPoint {
    @Override
    public void onModuleLoad() {
        //RootPanel.get("slot1").add(new GoodsTree().init());
        RootPanel.get("slot2").add(new AddGoods().init());
    }
}
