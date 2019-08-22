package com.example.nikechallenge.di.component;

import android.content.Context;

import com.example.nikechallenge.MyApplication;
import com.example.nikechallenge.data.source.remote.ApiInterface;
import com.example.nikechallenge.di.module.ContextModule;
import com.example.nikechallenge.di.module.RetrofitModule;
import com.example.nikechallenge.di.qualifier.ApplicationContext;
import com.example.nikechallenge.di.scopes.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    public ApiInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);
}
