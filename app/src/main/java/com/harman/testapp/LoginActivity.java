package com.harman.testapp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.harman.testapp.model.APIInterface;
import com.harman.testapp.utilities.CommonFunction;
import com.harman.testapp.utilities.Constant;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity  {

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    CommonFunction commObj;

    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);

        apiInterface = APIClient.getClient().create(APIInterface.class);
        mEmailView.setText("careflowinterviewcandidate@gmail.com");
        mPasswordView.setText("Car3F!0wT3st");

        mEmailView.clearFocus();
        mPasswordView.clearFocus();
        commObj = new CommonFunction();
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            //showProgress(true);
            callLogin();
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    public void callLogin(){


        final Dialog dialog = new Dialog(LoginActivity.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.dialog);
        // Set dialog title

        // set values for custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text_show);
        dialog.setTitle("Please Wait");
        text.setText("Authenticating..");
        dialog.show();

        Call<Void> call3 = apiInterface.doLogin("careflowinterviewcandidate@gmail.com",
                "Car3F!0wT3st",
                "DocComMobile",
                "https://www.careflowconnect.com",
                "token");

        call3.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    String access_token = "";
                    try {
                        JSONObject obj= new JSONObject(response.headers().get("access_token"));
                        access_token = "Bearer " + obj.get("Token").toString();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();


                    commObj.setSharedPrefValues(Constant.TAG_ACCESS_TOKEN, access_token,getApplicationContext());

                    if(dialog.isShowing()){
                        dialog.cancel();
                    }
                    Intent intent = new Intent(LoginActivity.this, PatientList.class);
                    startActivity(intent);
                    finish();

                }else{

                    Toast.makeText(getApplicationContext()," Not Successful",Toast.LENGTH_SHORT).show();
                    if(dialog.isShowing()){
                        dialog.cancel();
                    }
                }
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Invalid Credentials or Network connectivity error.",Toast.LENGTH_SHORT).show();

            }
        });
    }


}

