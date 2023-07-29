package com.example.splitpay;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class myRetrofit {

    private final String BASE_URL = "http://localhost:8000";//10.0.2.2
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);


    public String getBASE_URL() {
        return BASE_URL;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }
}
