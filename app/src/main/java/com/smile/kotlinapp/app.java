package com.smile.kotlinapp;

import android.app.Application;
import com.smile.kotlinapp.service.RetrofitModule;

public class app extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitModule.intialize(this);
    }
}
