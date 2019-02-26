package com.harman.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.widget.Toast;

import com.harman.testapp.adapter.PatientAdapt;
import com.harman.testapp.model.APIInterface;
import com.harman.testapp.model.APIinterfacePatient;
import com.harman.testapp.model.PatientDetails;
import com.harman.testapp.model.PatientRequestBody;
import com.harman.testapp.model.PatientResponse;
import com.harman.testapp.utilities.CommonFunction;
import com.harman.testapp.utilities.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PatientList extends AppCompatActivity {

    CommonFunction commObj = new CommonFunction();
    String accessToken = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        accessToken = commObj.getSharedPrefValues(Constant.TAG_ACCESS_TOKEN, getApplicationContext());

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.patient_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        APIinterfacePatient apiService =
                APIClient.getPatientDetails().create(APIinterfacePatient.class);
        String[] val = {"HandoverNotes"};
        PatientRequestBody data = new PatientRequestBody(10,val, 0);
        Call<PatientResponse> call = apiService.getPatientList(accessToken, data);
        call.enqueue(new Callback<PatientResponse>() {
            @Override
            public void onResponse(Call<PatientResponse> call, Response<PatientResponse> response) {
                int statusCode = response.code();
                List<PatientDetails> patientdetails = response.body().getData();
                //recyclerView.setAdapter(new PatientAdapter(patientdetails, R.layout.list_item_patient, getApplicationContext()));
                PatientAdapt adapter = new PatientAdapt(patientdetails);
                ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
                recyclerView.setAdapter(adapter);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<PatientResponse> call, Throwable t) {
                // Log error here since request failed
                //Log.e(TAG, t.toString());
                Toast.makeText(getApplicationContext(),"Failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
