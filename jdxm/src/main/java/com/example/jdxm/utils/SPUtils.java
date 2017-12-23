package com.example.jdxm.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DELL on 2017/12/19.
 */

public class SPUtils {
    public static SharedPreferences getSp(String spName, Context context){
       return context.getSharedPreferences(spName,context.MODE_PRIVATE);
    }
}
