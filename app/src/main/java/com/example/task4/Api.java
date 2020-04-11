package com.example.task4;


import com.example.task4.Models.Json;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {


    @GET("2.0/transport/route/search?key=ruzrgk1901")
    Call<Json> getJson(
            @Query("region_id") int id,
            @Query("q") String search_string
    );


}
