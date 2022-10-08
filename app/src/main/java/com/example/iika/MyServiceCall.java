package com.example.iika;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface MyServiceCall {
    @POST("login.php")
    Call<LoginResponse> getLogin(@Body LoginRequest request);
}
