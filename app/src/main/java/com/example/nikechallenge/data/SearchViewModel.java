package com.example.nikechallenge.data;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.nikechallenge.data.source.remote.ApiClient;
import com.example.nikechallenge.data.source.remote.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchViewModel extends ViewModel {
    private static final String TAG = SearchViewModel.class.getSimpleName();
    ProgressBar progressBar;
    String searchTerm;
    //this is the data that we will fetch asynchronously 
    private MutableLiveData<List<SearchResult>> resultList;

    public SearchViewModel(ProgressBar mpProgressBar, String mParam) {
        progressBar = mpProgressBar;
        searchTerm = mParam;
    }

    //we will call this method to get the data
    public LiveData<List<SearchResult>> getListSearchResults() {
        //if the list is null 
        if (resultList == null) {
            resultList = new MutableLiveData<List<SearchResult>>();
            //we will load it asynchronously from server in this method
            loadResults(searchTerm);
        }
        
        //finally we will return the list
        return resultList;
    }
 
    
    //This method is using Retrofit to get the JSON data from URL 
    private void loadResults(String msearchTerm) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<SearchResponse> call = apiService.getListSearchResults(msearchTerm);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                progressBar.setVisibility(View.GONE);
                Log.i(TAG,"responseitem="+response.body().getResults().get(0).getDefination());
                 resultList.setValue(response.body().getResults());

            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.i(TAG,"url ="+call.request().url().toString());

            }
        });

    }
}