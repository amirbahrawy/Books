package com.example.android.books;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.books.models.Items;
import com.example.android.books.models.Root;
import com.squareup.picasso.Picasso;
import java.util.List;

/**
 * Created by Amir on 28/08/2019.
 */

public class RetrofitAdapter extends RecyclerView.Adapter<RetrofitAdapter.RetrofitHolder> {
    private Context context;
    private List<Items> books;

    public RetrofitAdapter(Context context, List<Items> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public RetrofitHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new RetrofitHolder(row);

    }

    @Override
    public void onBindViewHolder(RetrofitHolder holder, int position) {
        Root root=new Root();
        Items items=root.getItems().get(position);
        holder.textView1.setText(items.getVolumeInfo().getTitle());
        holder.textView2.setText(items.getVolumeInfo().getAuthors().get(0));
        if (items.getVolumeInfo().getImageLinks().getThumbnail().isEmpty()){
            holder.imageView.setImageResource(R.drawable.piza);
        }
        else
        { Picasso.with(context).load(items.getVolumeInfo().getImageLinks().getThumbnail()).into(holder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class RetrofitHolder extends RecyclerView.ViewHolder{
        private TextView textView1,textView2;
        private ImageView imageView;
        public RetrofitHolder(View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.text1);
            textView2=itemView.findViewById(R.id.text2);
            imageView=itemView.findViewById(R.id.ph);

        }

    }
}
