package com.example.nikechallenge.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
 
    public static final String BASE_URL = "https://mashape-community-urban-dictionary.p.rapidapi.com/";
    private static Retrofit retrofit = null;
 
 
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}