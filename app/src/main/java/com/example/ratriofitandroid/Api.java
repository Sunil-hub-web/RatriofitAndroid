package com.example.ratriofitandroid;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

  @POST("api/updateactionplan")
  Call<Example> createUser(@Body Map<String,String> params, @Header("Authorization") String auth_params);

}
