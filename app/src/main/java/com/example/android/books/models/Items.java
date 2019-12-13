package com.example.android.books.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amir on 28/08/2019.
 */

public class Items {

    @SerializedName("volumeInfo")
    @Expose
    private VolumeInfo volumeInfo;
    @SerializedName("saleInfo")


    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }


}
