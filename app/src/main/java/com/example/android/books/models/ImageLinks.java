package com.example.android.books.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amir on 28/08/2019.
 */

public class ImageLinks {
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

}
