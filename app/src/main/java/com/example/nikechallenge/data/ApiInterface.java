package com.example.nikechallenge.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiInterface {
    @Headers({
            "x-rapidapi-host: mashape-community-urban-dictionary.p.rapidapi.com",
            "x-rapidapi-key: 2d2933ef3fmsheb633f6e0c94471p14b514jsnd77930cd3a61"})
    @GET("define")
    Call<SearchResponse> getListSearchResults(@Query("term") String searchTerm);

}