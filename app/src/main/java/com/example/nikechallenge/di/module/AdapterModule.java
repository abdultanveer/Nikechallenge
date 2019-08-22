package com.example.nikechallenge.di.module;

import com.example.nikechallenge.adapter.SearchAdapter;
import com.example.nikechallenge.data.SearchResult;
import com.example.nikechallenge.di.scopes.ActivityScope;
import com.example.nikechallenge.main.MainActivity;

import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public SearchAdapter getSearchResultsList() {
        return new SearchAdapter(new ArrayList<SearchResult>());
    }

}