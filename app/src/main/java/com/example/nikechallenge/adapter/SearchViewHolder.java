package com.example.nikechallenge.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nikechallenge.R;

class SearchViewHolder extends RecyclerView.ViewHolder {
    TextView tvDefination;
    TextView tvThumbsUp;
    TextView tvThumbsDown;


    public SearchViewHolder(View itemView) {
        super(itemView);
        tvDefination = itemView.findViewById(R.id.tv_defination);
        tvThumbsUp = itemView.findViewById(R.id.tv_thumbs_up);
        tvThumbsDown = itemView.findViewById(R.id.tv_thumbs_down);
    }
}
