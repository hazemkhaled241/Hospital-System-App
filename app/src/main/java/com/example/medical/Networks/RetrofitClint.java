package com.example.medical.Networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClint {

private static Retrofit retrofit=null;
public static APIs getClint(){
    if(retrofit==null){

        retrofit=new Retrofit.Builder()
                .baseUrl("http://api.instant-ss.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        ;
    }
    return retrofit.create(APIs.class);
}
}
