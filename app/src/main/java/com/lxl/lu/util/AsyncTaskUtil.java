package com.lxl.lu.util;

import android.R.integer;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * AsyncTask 辅助类
 */
public class AsyncTaskUtil {

    private IAsyncTaskCallBack iAsyncTaskCallBack;
    public AsyncTaskUtil() {
    }
    private Object recyedObject;
    public AsyncTaskUtil setIAsyncTaskCallBack(IAsyncTaskCallBack iAsyncTaskCallBack) {
        this.iAsyncTaskCallBack = iAsyncTaskCallBack;
        return this;
    }
    public AsyncTaskUtil setRecyedObject(Object o){
        recyedObject=o;
        return this;
    }
    public void execute(String... params) {
        new MyTask().execute(params);
    }

    class MyTask extends AsyncTask<String, integer, Object> {
        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Object doInBackground(String... arg0) {
            if (iAsyncTaskCallBack!=null){
                return iAsyncTaskCallBack.doInBackground(arg0);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object result) {
            if (recyedObject!=null){
                if (recyedObject instanceof Activity){
                    Activity activity= (Activity) recyedObject;
                    if (activity.isDestroyed()){
                        return;
                    }
                }else if (recyedObject instanceof Fragment){
                    Fragment fragment= (Fragment) recyedObject;
                    Log.i(AsyncTaskUtil.class.getSimpleName(),"fragment.isVisible():"+fragment.isVisible());
                    Log.i(AsyncTaskUtil.class.getSimpleName(),"fragment.isHidden():"+fragment.isHidden());
                    if (!fragment.isVisible()){
                        return;
                    }
                    if (fragment.isHidden()){
                        return;
                    }
                }
            }
            if(iAsyncTaskCallBack!=null){
                iAsyncTaskCallBack.onPostExecute(result);
            }

        }

    }

    public interface IAsyncTaskCallBack {
         Object doInBackground(String... arg0);
         void onPostExecute(Object result);
    }
}
