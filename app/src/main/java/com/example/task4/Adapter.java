package com.example.task4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task4.Models.Item;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Item> list;


    public Adapter(ArrayList<Item> list) {
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
        Item currentItem = list.get(position);

        String name_of_route = "Номер маршрута: "  + currentItem.getName();

        //Getting normal name of transport type
        //using base value from 2gis api as key
        String type_of_route = "Тип транспорта: " +
                currentItem.type_of_transport().get(currentItem.getSubtype());

        String where_from =  "Начальная остановка: " + currentItem.getFromName();

        String where_to = "Конечная остановка: " + currentItem.getToName();

        String result = name_of_route + "\n" + type_of_route + "\n" +
                where_from + "\n" + where_to;

        holder.mText1.setText(result);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}