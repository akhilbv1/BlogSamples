package com.sample.blog;

import android.app.Application;



public class TestApplication extends Application {

    public static RestClient restClient;
    @Override
    public void onCreate() {
        super.onCreate();
        restClient = new RestClient();
    }

    public static RestClient getRestClient(){
        return restClient;
    }
}
