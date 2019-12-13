package com.example.android.books;


import android.os.AsyncTask;
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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CarFragment extends Fragment {
 RecyclerView recyclerView;
 ProgressBar progressBar;
 BookAdapter bookAdapter;
 FloatingActionButton floatingActionButton;
    public CarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View x =inflater.inflate(R.layout.fragment_car, container, false);
        recyclerView=x.findViewById(R.id.recycler);
        progressBar=x.findViewById(R.id.progress);
        floatingActionButton=(FloatingActionButton) x.findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new back().execute("https://www.googleapis.com/books/v1/volumes?q=cars");
            }
        });
        progressBar.setVisibility(x.INVISIBLE);
        return x;
    }




    class back extends AsyncTask<String,Void,List<BookModel>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<BookModel> doInBackground(String... strings) {
            return Utils.utils(strings[0]);
        }

        @Override
        protected void onPostExecute(List<BookModel> bookModels) {
            super.onPostExecute(bookModels);
            progressBar.setVisibility(View.GONE);
            bookAdapter=new BookAdapter(getContext(),bookModels);
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setAdapter(bookAdapter);
        }
    }

}
