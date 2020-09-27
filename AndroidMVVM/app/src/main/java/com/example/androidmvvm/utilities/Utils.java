package com.example.androidmvvm.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import com.example.androidmvvm.MainActivity;


/**
 * Created by Satish on 09/06/2020.
 */
public class Utils {

    private static String url = "http://api.github.com/";

    public static String getUrl() {
        return url;
    }
    public static boolean isNetworkConnected(Context context) {

        if (MainActivity.ISOFFLINE)
            return true;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null;

    }

    public static void showLog(String key, String value) {
            Log.w(key, value);
    }

}
