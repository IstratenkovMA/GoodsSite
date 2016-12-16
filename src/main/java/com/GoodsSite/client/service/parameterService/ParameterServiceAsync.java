package com.GoodsSite.client.service.parameterService;


import com.GoodsSite.view.ParameterView;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ParameterServiceAsync {
    void addOrUpdate(ParameterView parameterView, AsyncCallback<ParameterView> async);
}
