package com.example.android.books;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Amir on 07/08/2019.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder> {
    private Context context;
    private List<BookModel> books;

    public BookAdapter(Context context, List<BookModel> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public BookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new BookHolder(row);

    }

    @Override
    public void onBindViewHolder(BookHolder holder, int position) {
           holder.textView1.setText(books.get(position).getTitle());
           holder.textView2.setText(books.get(position).getAuthor());
           //holder.textView2.setText(books.get(position).getAuthor());
           if (books.get(position).getImageurl().isEmpty()){
              holder.imageView.setImageResource(R.drawable.piza);
           }
           else
           { Picasso.with(context).load(books.get(position).getImageurl()).into(holder.imageView);
           }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class BookHolder extends RecyclerView.ViewHolder{
    private TextView textView1,textView2;
    private ImageView imageView;
    public BookHolder(View itemView) {
        super(itemView);
        textView1=itemView.findViewById(R.id.text1);
        textView2=itemView.findViewById(R.id.text2);
         imageView=itemView.findViewById(R.id.ph);

    }

}
}
