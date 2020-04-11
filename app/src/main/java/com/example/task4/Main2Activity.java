package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.task4.Models.Item;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Item> arrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this);

        Intent intent = getIntent();

        arrayList = intent.getParcelableArrayListExtra("List of items");


        recyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new Adapter(arrayList);
        recyclerView.setAdapter(mAdapter);
    }
}
