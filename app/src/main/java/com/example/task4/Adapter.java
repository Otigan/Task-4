package com.example.task4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<String> list;


    public Adapter(ArrayList<String> list) {
        this.list = list;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mText1;

        public ViewHolder(View itemView) {
            super(itemView);
            mText1 = itemView.findViewById(R.id.item_number);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String currentItem = list.get(position);

        holder.mText1.setText(currentItem);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}