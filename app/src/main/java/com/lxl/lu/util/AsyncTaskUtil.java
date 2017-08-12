package com.lxl.lu.util;

import android.R.integer;
import android.content.Context;
import android.os.AsyncTask;

/**
 * AsyncTask 辅助类
 */
public class AsyncTaskUtil {

    private IAsyncTaskCallBack iAsyncTaskCallBack;
    public AsyncTaskUtil() {
    }
    public AsyncTaskUtil setIAsyncTaskCallBack(IAsyncTaskCallBack iAsyncTaskCallBack) {
        this.iAsyncTaskCallBack = iAsyncTaskCallBack;
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
