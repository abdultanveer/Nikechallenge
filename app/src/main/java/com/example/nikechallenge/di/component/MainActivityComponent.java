package com.example.nikechallenge.di.component;

import com.example.nikechallenge.di.module.MyModule;
import com.example.nikechallenge.main.MainActivity;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}