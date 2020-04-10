package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task4.Models.Item;
import com.example.task4.Models.Json;
import com.example.task4.Models.Result;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText search_string;
    private EditText region_id;
    private Button search_button;


    private String search;
    private int reg_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        search_string = findViewById(R.id.search_string);
        region_id = findViewById(R.id.region_id);
        search_button = findViewById(R.id.search_button);



        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://catalog.api.2gis.ru/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                search = search_string.getText().toString();
                reg_id = Integer.parseInt(region_id.getText().toString());

                Api api = retrofit.create(Api.class);

                Call<Json> call = api.getJson(reg_id, search);

                call.enqueue(new Callback<Json>() {
                    @Override
                    public void onResponse(Call<Json> call, Response<Json> response) {
                        Json json = response.body();

                        Result result = json.getResult();

                        List<Item> items = result.getItems();


                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                        intent.putParcelableArrayListExtra("List of items", (ArrayList<? extends Parcelable>) items);

                        startActivity(intent);

                    }
                    @Override
                    public void onFailure(Call<Json> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        /*Api_check api = retrofit.create(Api_check.class);


        Call<List<Post>> call = api.getPost();

        mLayoutManager = new LinearLayoutManager(this);

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID " + post.getId() + "\n";
                    content += "Title " + post.getTitle() + "\n\n";

                    list.add(content);
                }
                recyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new Adapter(list);
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });*/
    }
}
