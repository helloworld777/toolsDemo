package com.lxl.lu.util;

import android.app.Activity;
import android.content.ComponentName;  
import android.content.Context;  
import android.content.Intent;  
import android.net.ConnectivityManager;  
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/** 
 *
 *  
 *  
 */ 
public class NetUtils  
{  
    private NetUtils()  
    {  
        /** cannot be instantiated **/ 
        throw new UnsupportedOperationException("cannot be instantiated");  
    }  
 
    /** 
     *
     * @param context 
     * @return 
     */ 
    public static boolean isConnected(Context context)  
    {  
 
        ConnectivityManager connectivity = (ConnectivityManager) context  
                .getSystemService(Context.CONNECTIVITY_SERVICE);  
 
        if (null != connectivity)  
        {  
 
            NetworkInfo info = connectivity.getActiveNetworkInfo();  
            if (null != info && info.isConnected())  
            {  
                if (info.getState() == NetworkInfo.State.CONNECTED)  
                {  
                    return true;  
                }  
            }  
        }  
        return false;  
    }  
 
    /** 
     */
    public static boolean isWifi(Context context)  
    {  
        ConnectivityManager cm = (ConnectivityManager) context  
                .getSystemService(Context.CONNECTIVITY_SERVICE);  
 
        if (cm == null)  
            return false;  
        return cm.getActiveNetworkInfo().getType() == ConnectivityManager.TYPE_WIFI;  
 
    }
    private static ConnectivityManager connectivityManager = null;
    private static NetworkInfo niInfo = null;

    /**
     *
     * @param context
     * @return
     */
    public static boolean isNetWorkConnected(Context context) {
        connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        niInfo = connectivityManager.getActiveNetworkInfo();
        return niInfo != null && niInfo.isConnected();
    }

    public static int getNetWorkType(Context context) {

        if (niInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return niInfo.getType();
        } else {
            return isFastMobileNetwork(context);
        }

    }

    private static int isFastMobileNetwork(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        int type = 0;
        switch (telephonyManager.getNetworkType()) {
            // 3G
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
                type = 3;
                break;
            // 2G
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_EDGE:

            case TelephonyManager.NETWORK_TYPE_CDMA:

                type = 2;
                break;
        }
        return type;
    }
    /** 
     */
    public static void openSetting(Activity activity)  
    {  
        Intent intent = new Intent("/");  
        ComponentName cm = new ComponentName("com.android.settings",  
                "com.android.settings.WirelessSettings");  
        intent.setComponent(cm);  
        intent.setAction("android.intent.action.VIEW");  
        activity.startActivityForResult(intent, 0);  
    }  
 
}