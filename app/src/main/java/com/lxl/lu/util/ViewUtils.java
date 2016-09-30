package com.lxl.lu.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;

/**
 * Created by asus on 2016/9/30.
 */
public class ViewUtils {
    /**
     * 扩大view的触摸范围
     * @param view
     * @param expandTouchWidth
     */
    public static void setTouchDelegate(final View view, final int expandTouchWidth) {
        final View parentView = (View) view.getParent();
        parentView.post(new Runnable() {
            @Override
            public void run() {
                final Rect rect = new Rect();
                view.getHitRect(rect);
                rect.top -= expandTouchWidth;
                rect.bottom += expandTouchWidth;
                rect.left -= expandTouchWidth;
                rect.right += expandTouchWidth;
                TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                parentView.setTouchDelegate(touchDelegate);
            }
        });
    }
}
