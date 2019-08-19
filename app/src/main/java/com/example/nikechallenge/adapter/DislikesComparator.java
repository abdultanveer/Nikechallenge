package com.example.nikechallenge.adapter;

import com.example.nikechallenge.data.SearchResult;

import java.util.Comparator;

public class DislikesComparator implements Comparator<SearchResult> {

    @Override
    public int compare(SearchResult sr1, SearchResult sr2) {
        return sr1.thumbsDown >sr2.thumbsDown ? 1:-1;
                //sr1.name.compareTo(t1.name)>1 ? 1:-1;
    }

    @Override
    public Comparator<SearchResult> reversed() {

        return new DislikesComparator().reversed();
    }
}
