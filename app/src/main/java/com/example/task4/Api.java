package com.example.task4;


import com.example.task4.Models.Json;
import com.example.task4.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {



    @GET("2.0/transport/route/search?key=ruzrgk1901&region_id=50&q=4")

    Call<Json> getJson();



    @GET("2.0/suggest/list?q=%D0%A2%D0%BE%D0%BC%D1%81%D0%BA&key=ruzrgk1901&region_id=50")
    Call<Result> getRes();

}
