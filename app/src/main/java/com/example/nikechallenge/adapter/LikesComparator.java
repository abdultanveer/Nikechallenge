package com.example.nikechallenge.adapter;

import com.example.nikechallenge.data.SearchResult;

import java.util.Comparator;

public class LikesComparator implements Comparator<SearchResult> {

    @Override
    public int compare(SearchResult sr1, SearchResult sr2) {
        return sr1.thumbsUp >sr2.thumbsUp ? 1:-1;
                //sr1.name.compareTo(t1.name)>1 ? 1:-1;
    }

    @Override
    public Comparator<SearchResult> reversed() {

        return new LikesComparator().reversed();
    }
}
