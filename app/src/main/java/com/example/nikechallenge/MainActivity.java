package com.example.nikechallenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.nikechallenge.adapter.DislikesComparator;
import com.example.nikechallenge.adapter.LikesComparator;
import com.example.nikechallenge.adapter.SearchAdapter;
import com.example.nikechallenge.data.ApiClient;
import com.example.nikechallenge.data.ApiInterface;
import com.example.nikechallenge.data.SearchResponse;
import com.example.nikechallenge.data.SearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView searchListView;
    SearchAdapter adapter;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchListView = findViewById(R.id.search_list_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        searchListView.setLayoutManager(layoutManager);
        progressBar = findViewById(R.id.progressBar);
    }

    public void clickHandler(View view) {
        progressBar.setVisibility(View.VISIBLE);
        EditText searchEditText = findViewById(R.id.editTextSearch);
        String searchTerm = searchEditText.getText().toString();
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<SearchResponse> call = apiService.getListSearchResults(searchTerm);
        call.enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                progressBar.setVisibility(View.GONE);
               Log.i(TAG,"responseitem="+response.body().getResults().get(0).getDefination());

                 adapter = new SearchAdapter(response.body().getResults());
                searchListView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.i(TAG,"url ="+call.request().url().toString());

            }
        });


    }

    public void sort(View view) {
        switch (view.getId()){
            case R.id.textViewlikes:
                LikesComparator likesComparator = new LikesComparator();
                adapter.searchResults.sort(likesComparator);
                adapter.notifyDataSetChanged();
                break;
            case R.id.textViewdislikes:
                adapter.searchResults.sort(new DislikesComparator());
                adapter.notifyDataSetChanged();
                break;
        }
    }
}
