package com.example.nikechallenge.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nikechallenge.R;
import com.example.nikechallenge.data.SearchResult;

import java.util.List;


public class SearchAdapter extends RecyclerView.Adapter{

    public List<SearchResult> searchResults;

    public SearchAdapter(List<SearchResult> searchResults) {
        this.searchResults = searchResults;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_search_result, parent, false);

        return new SearchViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SearchViewHolder viewHolder = (SearchViewHolder) holder;
        viewHolder.tvDefination.setText(searchResults.get(position).getDefination());
        viewHolder.tvThumbsUp.setText(""+searchResults.get(position).getThumbsUp());
        viewHolder.tvThumbsDown.setText(""+searchResults.get(position).getThumbsDown());
    }

    @Override
    public int getItemCount() {
        return searchResults.size();
    }
}
