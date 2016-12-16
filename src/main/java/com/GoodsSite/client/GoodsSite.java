package com.GoodsSite.client;


import com.GoodsSite.client.service.goodsTypeService.GoodsTypeService;
import com.GoodsSite.client.ui.AddElements;
import com.GoodsSite.client.ui.AddNewGoods;
import com.GoodsSite.client.ui.GoodsTree;
import com.GoodsSite.view.GoodsTypeView;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

public class GoodsSite implements EntryPoint {
    @Override
    public void onModuleLoad() {
        History.addValueChangeHandler(new ValueChangeHandler<String>() {
            @Override
            public void onValueChange(ValueChangeEvent<String> valueChangeEvent) {
                String historyToken = valueChangeEvent.getValue();
                RootPanel.get("slot1").add(new Label(historyToken));
                if("GoodsTree".equals(historyToken)){
                    clearRootPanel();
                    RootPanel.get("slot1").add(new GoodsTree().init());
                }
                else if("AddElements".equals(historyToken)){
                    clearRootPanel();
                    RootPanel.get("slot1").add(new AddElements().init());
                }
                else if("AddNewGoods".equals(historyToken.substring(0, 11))){
                    clearRootPanel();
                    String typeName = historyToken.substring(historyToken.indexOf("t=") + 2);
                    GoodsTypeService.App.getInstance().getByName(typeName, new AsyncCallback<GoodsTypeView>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            Window.alert("АЩИБКА");
                        }

                        @Override
                        public void onSuccess(GoodsTypeView goodsTypeView) {
                            RootPanel.get("slot1").add(new AddNewGoods(goodsTypeView));
                        }
                    });
                }
            }
        });
        History.newItem("AddElements");
    }
    private void clearRootPanel(){
        if(RootPanel.get("slot1") != null){
            RootPanel.get("slot1").clear();
        }
    }
}
