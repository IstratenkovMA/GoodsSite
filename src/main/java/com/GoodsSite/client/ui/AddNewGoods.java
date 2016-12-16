package com.GoodsSite.client.ui;



import com.GoodsSite.client.service.parameterService.ParameterService;
import com.GoodsSite.client.service.parameterValueService.ParameterValueService;
import com.GoodsSite.view.GoodsTypeView;
import com.GoodsSite.view.GoodsView;
import com.GoodsSite.view.ParameterValueView;
import com.GoodsSite.view.ParameterView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;

import java.util.ArrayList;
import java.util.List;

public class AddNewGoods extends VerticalPanel{
    private TextBox goodsName = new TextBox();
    private List<TextBox> parameters = new ArrayList<>();
    private List<TextBox> values = new ArrayList<>();

    public AddNewGoods(final GoodsTypeView type){
        final Button addGoods = new Button("Добавить новый товар, с параметрами");
        final Button newParam = new Button("Добавить параметер");
        add(goodsName);
        newParam.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                remove(newParam);
                add(addNewParamLine());
                add(newParam);
            }
        });

        addGoods.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
            final List<ParameterView> parametersView = new ArrayList<ParameterView>();
            for(int i = 0; i < parameters.size(); i++){
                final Integer j = new Integer(i);
                ParameterValueService.App.getInstance().addOrUpdate(new ParameterValueView(values.get(i).getText()),
                        new AsyncCallback<ParameterValueView>() {
                    @Override
                    public void onFailure(Throwable throwable) {
                        Window.alert("Ошибка при добавлении значения параметра" + throwable.getMessage());
                    }
                    @Override
                    public void onSuccess(ParameterValueView parameterValueView) {
                        parametersView.add(new ParameterView(parameters.get(j).getText(), parameterValueView));
                    }
                });
            }
            GoodsView newGoods = new GoodsView(goodsName.getText(), type, parametersView);
            }
        });

        add(addGoods);
        add(newParam);
    }
    private HorizontalPanel addNewParamLine(){
        HorizontalPanel horizontalPanel = new HorizontalPanel();
        TextBox parameterName = new TextBox();
        TextBox parameterValue = new TextBox();

        parameters.add(parameterName);
        values.add(parameterValue);

        horizontalPanel.add(parameterName);
        horizontalPanel.add(parameterValue);
        return horizontalPanel;
    }


    private void updateParameter(ParameterView parameter){
        ParameterService.App.getInstance().addOrUpdate(parameter, new AsyncCallback<ParameterView>() {
            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Ошибка при добавлении параметра" + throwable.getMessage());
            }

            @Override
            public void onSuccess(ParameterView parameterView) {
            }
        });
    }
}
