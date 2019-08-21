package com.example.nikechallenge.data;

import android.widget.ProgressBar;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MyViewModelFactory implements ViewModelProvider.Factory {
    ProgressBar mpProgressBar;
    private String mParam;


    public MyViewModelFactory(ProgressBar progressBar, String param) {
        mpProgressBar = progressBar;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new SearchViewModel(mpProgressBar, mParam);
    }
}