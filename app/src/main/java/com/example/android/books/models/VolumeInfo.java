package com.example.android.books.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amir on 28/08/2019.
 */

public class VolumeInfo {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("authors")
    private List<String> authors = null;
    @SerializedName("imageLinks")
    @Expose
    private ImageLinks imageLinks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
    public ImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }
}
