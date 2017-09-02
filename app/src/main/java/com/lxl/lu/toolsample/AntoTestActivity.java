package com.lxl.lu.toolsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

@ContentView(R.layout.activity_anto_test)
public class AntoTestActivity extends AppCompatActivity {

    @ViewInject(R.id.etUsername)
    private EditText etUsername;

    @ViewInject(R.id.etPwd)
    private EditText etPwd;

    @ViewInject(R.id.tvResult)
    private TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.inject(this);
//        setContentView(R.layout.activity_anto_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @OnClick({R.id.btnLogin})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.btnLogin:
//                tvResult.setText(etUsername.getText().toString()+etPwd.getText().toString());
                Log.i(this.getClass().getSimpleName(),etUsername.getText().toString()+etPwd.getText().toString());
                tvResult.setText("abc123456");
                break;
        }
    }

}
