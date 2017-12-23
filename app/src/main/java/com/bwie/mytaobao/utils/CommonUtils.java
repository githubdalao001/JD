package com.bwie.mytaobao.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by yfeng on 2017/9/16.
 * 公用的工具类，可以放入一些杂七杂八的静态方法
 */

public class CommonUtils {

    //获取当前应用的版本号
    public static int getVersionCode(Context context){

        int versionCode = 0;
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
            versionCode = packInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;

    }

    //获取当前应用的版本名字
    public static String getVersionName(Context context){
        String versionName = "";
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = context.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packInfo = packageManager.getPackageInfo(context.getPackageName(),0);
            versionName = packInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

}
