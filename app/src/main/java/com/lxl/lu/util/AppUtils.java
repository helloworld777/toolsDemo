package com.lxl.lu.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;

import java.util.LinkedList;

/**
 *
 *
 *
 */
public class AppUtils {
    private static LinkedList<Activity> activityStack;
    private static AppUtils instance;


    public static AppUtils getInstance() {
        if (instance == null) {
            instance = new AppUtils();
        }
        return instance;
    }

    /**
     * 获得当前栈顶Activity
     *
     * @return
     */
    public Activity currentActivity() {
        Activity activity = null;
        if (activityStack != null && !activityStack.isEmpty())
            activity = activityStack.get(activityStack.size() - 1);
        return activity;
    }

    /**
     * 将当前Activity推入栈中
     *
     * @param activity
     */
    public void pushActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new LinkedList<Activity>();
        }
        activityStack.add(activity);
    }

    /**
     * 将Activity退出栈
     *
     * @param activity
     */
    public void popActivity(Activity activity) {
        activityStack.remove(activity);
    }

    /**
     * 主动退出Activity
     *
     * @param activity
     */
    public void closeActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }


    public void closeAllActivity() {
        while (true) {
            Activity activity = currentActivity();
            if (null == activity) {
                break;
            }
            closeActivity(activity);
        }
    }

    /**
     * 退出指定名字的activity
     */
    public void closeActivityByName(String name) {
        while (true) {
            Activity activity = currentActivity();
            if (null == activity) {
                break;
            }

            String activityName = activity.getComponentName().getClassName().toString();
            if (TextUtils.equals(name, activityName)) {
                continue;
            }
            popActivity(activity);
        }
    }

    /**
     * 获得当前ACTIVITY 名字
     */
    public String getCurrentActivityName() {
        Activity activity = currentActivity();
        String name = "";
        if (activity != null) {
            name = activity.getComponentName().getClassName().toString();
        }
        return name;
    }

    private AppUtils() {
        /**cannot be instantiated **/
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    /**
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param context
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}