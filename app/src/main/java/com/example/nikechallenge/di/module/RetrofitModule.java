package com.example.nikechallenge.di.module;

import com.example.nikechallenge.data.source.remote.ApiInterface;
import com.example.nikechallenge.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    @Provides
    @ApplicationScope
    ApiInterface getApiInterface(Retrofit retroFit) {
        return retroFit.create(ApiInterface.class);
    }

    @Provides
    @ApplicationScope
    Retrofit getRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }


}