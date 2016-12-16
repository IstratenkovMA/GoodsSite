package com.GoodsSite.client.service.parameterValueService;

import com.GoodsSite.view.ParameterValueView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ParameterValueService")
public interface ParameterValueService extends RemoteService {

    ParameterValueView addOrUpdate(ParameterValueView parameterValue);
    ParameterValueView findByValue(String value);

    public static class App {
        private static ParameterValueServiceAsync ourInstance = GWT.create(ParameterValueService.class);
        public static synchronized ParameterValueServiceAsync getInstance(){ return ourInstance; }
    }
}
