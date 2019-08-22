package com.example.nikechallenge.di.module;

import android.content.Context;

import com.example.nikechallenge.di.qualifier.ActivityContext;
import com.example.nikechallenge.di.scopes.ActivityScope;
import com.example.nikechallenge.main.MainActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}