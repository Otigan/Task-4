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

        String type_of_route = "";

        if (currentItem.getSubtype().equals("bus")){
            type_of_route = "Вид транспорта: Автобус";
        }
        else if (currentItem.getSubtype().equals("trolleybus")){
            type_of_route = "Вид транспорта: Троллейбус";
        }
        else if (currentItem.getSubtype().equals("tram")) {
            type_of_route = "Вид транспорта: Трамвай";
        }
        else if (currentItem.getSubtype().equals("metro")) {
            type_of_route = "Вид транспорта: Метро";
        }
        else if (currentItem.getSubtype().equals("shuttle_bus")){
            type_of_route = "Вид транспорта: Маршрутное такси";
        }
        else if (currentItem.getSubtype().equals("suburban_train")) {
            type_of_route = "Вид транспорта: Электропоезд";
        }
        else if (currentItem.getSubtype().equals("funicular_railway")) {
            type_of_route = "Вид транспорта: Фуникулёр";
        }
        else if (currentItem.getSubtype().equals("monorail")) {
            type_of_route = "Вид транспорта: Монорельс";
        }
        else if (currentItem.getSubtype().equals("river_transport")){
            type_of_route = "Вид транспорта: Водный транспорт";
        }
        else if (currentItem.getSubtype().equals("cable_car")) {
            type_of_route = "Вид транспорта: Канатная дорога";
        }
        else if (currentItem.getSubtype().equals("light_rail")) {
            type_of_route = "Вид транспорта: Скоростной трамвай";
        }
        else if (currentItem.getSubtype().equals("premetro")){
            type_of_route = "Вид транспорта: Метротрам";
        }
        else if (currentItem.getSubtype().equals("light_metro")) {
            type_of_route = "Вид транспорта: Лёгкое метро";
        }
        else if (currentItem.getSubtype().equals("aeroexpress")) {
            type_of_route = "Вид транспорта: Аэроэкспресс";
        }

        String where_from =  "Начальная остановка: " + currentItem.getFromName();

        String where_to = "Конечная остановка: " + currentItem.getToName();

        holder.mText1.setText(name_of_route + "\n" + type_of_route + "\n" +
                where_from + "\n" + where_to);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}