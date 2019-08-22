package com.example.nikechallenge;

import android.app.Application;

import com.example.nikechallenge.di.component.DaggerMyComponent;
import com.example.nikechallenge.di.component.MainActivityComponent;
import com.example.nikechallenge.di.module.MyModule;

public class MyApplication extends Application {

    private MainActivityComponent mMainActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mMainActivityComponent = createMyComponent();
    }

    MainActivityComponent getMyComponent() {
        return mMainActivityComponent;
    }

    private MainActivityComponent createMyComponent() {
        return DaggerMyComponent
                .builder()
                .myModule(new MyModule())
                .build();
    }
}