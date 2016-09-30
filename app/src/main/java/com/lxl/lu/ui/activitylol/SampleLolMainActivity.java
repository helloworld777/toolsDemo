package com.lxl.lu.ui.activitylol;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lxl.lu.toolsample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/9/30.
 */
@ContentView(R.layout.activity_sample_lol_main)
public class SampleLolMainActivity extends Activity{

    @ViewInject(R.id.content)
    FrameLayout content;

    FragmentManager fm;
    FragmentTransaction ft;
    Fragment fragment=new NewFragment();
    @ViewInject(R.id.ivNew)
    ImageView ivNew;
    @ViewInject(R.id.ivFriend)
    ImageView ivFriend;
    @ViewInject(R.id.ivMe)
    ImageView ivMe;

    @ViewInject(R.id.ivFind)
    ImageView ivFind;
    List<ImageView> imageViewList=new ArrayList<>();
    int selecteIndex=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fm=getFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.content,fragment);

        imageViewList.add(ivNew);
        imageViewList.add(ivFriend);
        imageViewList.add(ivFind);
        imageViewList.add(ivMe);
    }
}
