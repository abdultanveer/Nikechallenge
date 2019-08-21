package com.example.nikechallenge.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.nikechallenge.R;
import com.example.nikechallenge.adapter.DislikesComparator;
import com.example.nikechallenge.adapter.LikesComparator;
import com.example.nikechallenge.adapter.SearchAdapter;
import com.example.nikechallenge.data.SearchResult;

import java.util.List;

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
        ResultViewModel model = ViewModelProviders.of(this,
                new ResultViewModelFactory(progressBar, searchTerm)).get(ResultViewModel.class);

        model.getListSearchResults().observe(this, new Observer<List<SearchResult>>() {
            @Override
            public void onChanged(@Nullable List<SearchResult> heroList) {
                adapter = new SearchAdapter(heroList);
                searchListView.setAdapter(adapter);
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
