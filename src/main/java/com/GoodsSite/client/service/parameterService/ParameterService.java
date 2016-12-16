package com.GoodsSite.client.service.parameterService;

import com.GoodsSite.view.ParameterView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ParameterService")
public interface ParameterService extends RemoteService{

    ParameterView addOrUpdate(ParameterView parameterView);

    public static class App {
        private static ParameterServiceAsync ourInstance = GWT.create(ParameterService.class);
        public static synchronized ParameterServiceAsync getInstance(){ return ourInstance; }
    }

}
