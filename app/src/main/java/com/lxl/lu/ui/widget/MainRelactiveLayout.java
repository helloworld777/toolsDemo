package com.lxl.lu.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.lxl.lu.toolsample.R;

/**
 * Created by asus on 2016/9/30.
 */
public class MainRelactiveLayout extends RelativeLayout{
    private View rlRefresh;
    public MainRelactiveLayout(Context context) {
        super(context);
        init(context);
    }

    public MainRelactiveLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MainRelactiveLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public MainRelactiveLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context){


        rlRefresh=findViewById(R.id.rlRefresh);
    }
}
