package com.example.task4;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        search_string = findViewById(R.id.search_string);
        region_id = findViewById(R.id.region_id);
        search_button = findViewById(R.id.search_button);
        textView = findViewById(R.id.textView);


        search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String search_string_text = search_string.getText().toString();
                String reg_id = region_id.getText().toString();

                if (TextUtils.isEmpty(search_string_text) && TextUtils.isEmpty(reg_id)) {
                    Toast.makeText(MainActivity.this, "Please, enter search data",
                            Toast.LENGTH_LONG).show();
                }else{
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://catalog.api.2gis.ru/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();


                    Api api = retrofit.create(Api.class);

                    Call<Json> call = api.getJson(Integer.parseInt(reg_id), search_string_text);

                    call.enqueue(new Callback<Json>() {
                        @Override
                        public void onResponse(Call<Json> call, Response<Json> response) {
                            Json json = response.body();

                            Result result = json.getResult();

                            if(result == null) {
                                Toast.makeText(MainActivity.this,
                                        "The search returned no results, try again",
                                        Toast.LENGTH_LONG).show();
                            } else {
                                List<Item> items = result.getItems();

                                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                                intent.putParcelableArrayListExtra("List of items", (ArrayList<? extends Parcelable>) items);

                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onFailure(Call<Json> call, Throwable t) {
                            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}
