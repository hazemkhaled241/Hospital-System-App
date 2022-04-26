package com.example.medical.Networks;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIs {

@POST("register")
   Call<RegisterResponse>register(@Body RegisterRequest registerRequest);
   @POST("login")
   Call<LoginResponse>login(@Body LoginRequest loginRequest);


}
