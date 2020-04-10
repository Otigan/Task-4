package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private EditText custom_search;
    private EditText region_id;
    private Button button;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // custom_search = findViewById(R.id.custom_string);
        //region_id = findViewById(R.id.region);
        button = findViewById(R.id.search_button);

       recyclerView = findViewById(R.id.recyclerView);

       // textView = findViewById(R.id.check);

        mLayoutManager = new LinearLayoutManager(this);

        ArrayList<String> list = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://catalog.api.2gis.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<Json> call = api.getJson();

        call.enqueue(new Callback<Json>() {
            @Override
            public void onResponse(Call<Json> call, Response<Json> response) {
                Json json = response.body();

                Result result = json.getResult();

                List<Item> items = result.getItems();

                for(Item item: items) {
                    list.add(item.getName());
            }
                recyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new Adapter(list);
                recyclerView.setAdapter(mAdapter);

            }
           @Override
           public void onFailure(Call<Json> call, Throwable t) {
                list.add(t.getMessage());
                recyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new Adapter(list);
                recyclerView.setAdapter(mAdapter);
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
