package com.young.youngnews;

import android.app.Application;
import android.content.Context;

public class InitApp extends Application {

    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();

        appContext = this;
        
    }
}
