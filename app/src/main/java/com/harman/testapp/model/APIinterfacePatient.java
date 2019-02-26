package com.harman.testapp.model;

import com.harman.testapp.utilities.CommonFunction;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIinterfacePatient {

    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json;version=10"
    })

    @POST("/groups/3061/patients")
    Call<PatientResponse> getPatientList(@Header("Authorization") String authorizeToken,
                                         @Body PatientRequestBody data);
}
