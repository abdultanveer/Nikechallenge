package com.example.nikechallenge.di;

import java.util.Date;

public class MyExampleImpl implements MyExample {

    private long mDate;

    public MyExampleImpl() {
        mDate = new Date().getTime();
    }

    public long getDate() {
        return mDate;
    }

}
