package com.lxl.lu.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;


public class TopNoticeDialog {

    /**
     * 枚举类型
     */
    public enum TipType {
        SUCCESS_TIP, FAILURE_TIP
    }
    private static CountDown mCountDown;
    private static TextView tip_txt = null;
    private final static int COUNTDOWN_TIME = 1000;
    private static WindowManager wm;
    private final static WindowManager.LayoutParams mParams = new WindowManager.LayoutParams();
    private static Toast toast;
    private Handler handler=new Handler(Looper.getMainLooper());
    private static void createToast(Context context, CharSequence text){
        wm= (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        final WindowManager.LayoutParams params = mParams;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.format = PixelFormat.TRANSLUCENT;
        params.type = WindowManager.LayoutParams.TYPE_TOAST;
        params.gravity= Gravity.CENTER;
        params.windowAnimations=android.R.style.Animation_Toast;
        params.setTitle("Toast");
        params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
        if(tip_txt==null){
            tip_txt= new TextView(context);
//            tip_txt.setBackgroundColor(context.getResources().getColor(R.color.grey));
            tip_txt.setAlpha(0.5f);
            int padiing=20;
            tip_txt.setPadding(padiing,padiing,padiing,padiing);
        }
        if (tip_txt.getParent() != null) {
            Log.v("TopNoticeDialog", "REMOVE! "  + " in TopNoticeDialog");
            wm.removeView(tip_txt);
        }
        tip_txt.setText(text);
        wm.addView(tip_txt, mParams);
        startCountDown();
    }
    /**
     * 显示一个自定义的Toast
     *
     * @param context
     * @param text
     */
    public static void showToast(Context context, CharSequence text) {
        createToast(context, text);
    }

    /**
     * 显示一个自定义的Toast
     *
     * @param context
     * @param res 字符串资源文件
     */
    public static void showToast(Context context, int res) {
        createToast(context, context.getText(res));
    }
    /**
     * 显示一个自定义的Toast
     *
     * @param context
     * @param text 字符串
     *             是否自定义
     */
    public static void showToast(Context context, CharSequence text,boolean isCustom) {
        if (isCustom){
            createToast(context, text);
        }else{
            showSystemToast(context,text);
        }
    }
    public static void showSystemToast(Context context,CharSequence text){
        if (toast!=null){
            toast.setText(text);
        }else{
            toast=Toast.makeText(context,text,Toast.LENGTH_SHORT);
        }
        toast.show();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static void closeDialog(boolean setNull) {
        if (tip_txt != null) {
            wm.removeView(tip_txt);
        }
        stopCountDown();
    }


    static class CountDown extends CountDownTimer {

        public CountDown(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            closeDialog(false);
        }
    }

    private static void startCountDown() {
        if (mCountDown != null) {
            mCountDown.cancel();
        }
        mCountDown = new CountDown(COUNTDOWN_TIME, 1000);
        mCountDown.start();
    }

    private static void stopCountDown() {
        if (mCountDown != null) {
            mCountDown.cancel();
            mCountDown = null;
        }
    }
}

