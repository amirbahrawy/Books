package com.example.android.books.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Amir on 28/08/2019.
 */

public class Root {
      @SerializedName("items")
    private List<Items> items = null;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }
}
