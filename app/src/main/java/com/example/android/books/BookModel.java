package com.example.android.books;

import java.util.ArrayList;

/**
 * Created by Amir on 19/08/2019.
 */

public class BookModel {
    private String title,imageurl,author;

    public BookModel(String title, String author, String imageurl) {
        this.title = title;
        this.author = author;
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
