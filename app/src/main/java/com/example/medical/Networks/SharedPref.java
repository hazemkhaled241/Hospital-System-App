package com.example.medical.Networks;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static SharedPreferences mSharedPref;
    private  SharedPref(){};
    public static void init(Context context){
        if(mSharedPref==null)
            mSharedPref=context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }
   public static String readString(String key,String dValue){
     return mSharedPref.getString(key,dValue);
   }
   public static void writeString(String key,String value){
        mSharedPref.edit().putString(key,value).apply();
   }

}
