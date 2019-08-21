package com.example.nikechallenge.main;

import android.widget.ProgressBar;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ResultViewModelFactory implements ViewModelProvider.Factory {
    ProgressBar mpProgressBar;
    private String mParam;


    public ResultViewModelFactory(ProgressBar progressBar, String param) {
        mpProgressBar = progressBar;
        mParam = param;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new ResultViewModel(mpProgressBar, mParam);
    }
}