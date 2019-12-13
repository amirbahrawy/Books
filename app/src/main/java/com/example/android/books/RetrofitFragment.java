package com.example.android.books;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import androidx.core.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.android.books.models.Items;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class RetrofitFragment extends Fragment {
    RecyclerView recyclerView;
    ProgressBar progressBar;
    RetrofitAdapter retrofitAdapter;
    Retrofit retrofit;
    Helper helper;
    FloatingActionButton floatingActionButton;
    RecyclerView.LayoutManager layoutManager;
    public RetrofitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x =inflater.inflate(R.layout.fragment_retrofit, container, false);
        recyclerView=x.findViewById(R.id.recycler);
        progressBar=x.findViewById(R.id.progress);
        progressBar.setVisibility(View.INVISIBLE);
        layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        retrofit=new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        helper=retrofit.create(Helper.class);
        floatingActionButton=(FloatingActionButton) x.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBooks();
            }
        });
        return x;
    }

    private void getBooks() {
        progressBar.setVisibility(View.VISIBLE);
        Call<List<Items>> call= helper.getBooks("cars");
        call.enqueue(new Callback<List<Items>>() {
            @Override
            public void onResponse(Call<List<Items>> call, Response<List<Items>> response) {
                if (response.isSuccessful()){
                  List<Items> books=response.body();
                  retrofitAdapter=new RetrofitAdapter(getContext(),books);
                    recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                    recyclerView.setAdapter(retrofitAdapter);

                }

            }

            @Override
            public void onFailure(Call<List<Items>> call, Throwable t) {

            }
        });
    }

}
