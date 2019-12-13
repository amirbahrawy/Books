package com.example.android.books;



import com.example.android.books.models.Items;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Amir on 28/08/2019.
 */

public interface Helper {
    @GET("books/v1/volumes")
    Call<List<Items>> getBooks(@Query("q")String q);
}
