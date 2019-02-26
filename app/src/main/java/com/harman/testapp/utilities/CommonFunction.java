package com.harman.testapp.utilities;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class CommonFunction {

    public void setSharedPrefValues(String sharedPrefName, String value, Context context){
        SharedPreferences pref = context.getSharedPreferences(Constant.TAG_SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(sharedPrefName,value);
        editor.commit();
    }

    public String getSharedPrefValues(String sharedPrefName, Context context){
        SharedPreferences pref = context.getSharedPreferences(Constant.TAG_SHARED_PREF, MODE_PRIVATE);
        return pref.getString(sharedPrefName, "null");
    }

}
