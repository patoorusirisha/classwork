package com.example.retroficexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EndpointInterface {
    /*thrid class*/
    @GET("dayone/country/IN")
    Call<String> getData();
}
