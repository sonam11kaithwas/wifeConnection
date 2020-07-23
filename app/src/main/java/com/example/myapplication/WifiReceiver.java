package com.example.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

interface WifiCallBack {
    void wifiCallBack(boolean b);
}

/**
 * Created by Sonam-11 on 16/7/20.
 */
class WifiReceiver extends BroadcastReceiver {
    WifiCallBack wifiCallBack;

    @Override
    public void onReceive(Context context, Intent intent) {
        wifiCallBack = (WifiCallBack) context;
        ConnectivityManager conMan = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMan.getActiveNetworkInfo();

        if (netInfo != null && netInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            Log.e("WifiReceiver", "Have Wifi Connection");
            //Toast.makeText(context, "Have Wifi Connection", Toast.LENGTH_SHORT).show();
            wifiCallBack.wifiCallBack(true);
        } else {
            Log.e("WifiReceiver", "Don't have Wifi Connection");
            //  Toast.makeText(context, "Don't have Wifi Connection", Toast.LENGTH_SHORT).show();
            wifiCallBack.wifiCallBack(false);
        }

    }
}
