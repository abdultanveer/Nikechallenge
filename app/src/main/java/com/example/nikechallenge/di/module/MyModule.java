package com.example.nikechallenge.di.module;

import com.example.nikechallenge.di.MyExample;
import com.example.nikechallenge.di.MyExampleImpl;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {

    @Provides
    @Singleton
    static MyExample provideMyExample() {
        return new MyExampleImpl();
    }

}