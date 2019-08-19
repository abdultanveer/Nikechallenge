package com.example.nikechallenge.data;

import com.google.gson.annotations.SerializedName;

public class SearchResult {
    @SerializedName("thumbs_up")
     public int thumbsUp;
    @SerializedName("thumbs_down")
    public int thumbsDown;
    @SerializedName("definition")
    public String defination;

    public SearchResult(int thumbsUp, int thumbsDown, String defination) {
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
        this.defination = defination;
    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(int thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public int getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(int thumbsDown) {
        this.thumbsDown = thumbsDown;
    }

    public String getDefination() {
        return defination;
    }

    public void setDefination(String defination) {
        this.defination = defination;
    }
}
