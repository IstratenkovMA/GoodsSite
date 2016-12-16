package com.GoodsSite.client.service.parameterValueService;


import com.GoodsSite.view.ParameterValueView;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ParameterValueServiceAsync {

    void addOrUpdate(ParameterValueView parameterValue, AsyncCallback<ParameterValueView> async);

    void findByValue(String value, AsyncCallback<ParameterValueView> async);
}
