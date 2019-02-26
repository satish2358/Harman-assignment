package com.harman.testapp.model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json;version=10"
    })
    @FormUrlEncoded
    @POST("/Home/Login")
    Call<Void> doLogin(@Field("EmailAddress") String email,
                       @Field("Password") String password,
                       @Field("client_id") String clientID,
                       @Field("redirect_uri") String redirectURI,
                       @Field("response_type") String responseType);



}
