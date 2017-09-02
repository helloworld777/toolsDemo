package com.lxl.lu.toolsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lxl.lu.util.CrashUtils;
import com.lxl.lu.util.file.IOUtil;
import com.lxl.lu.util.file.SDCardUtils;

import java.io.IOException;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       ViewUtils.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        CrashUtils.getInstance().init(this);
//        try {
//          //  IOUtil.writerString(SDCardUtils.getSDCardPath() + "a.txt","sssssssssss");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    @OnClick({R.id.btn1,R.id.btnGoogleMvp,R.id.btnAntoTest})
    public void onclick(View view){
        switch (view.getId()){
            case R.id.btn1:
                startActivity(com.lxl.lu.ui.activityani.MainActivity.class);
            break;
            case R.id.btnGoogleMvp:
                startActivity(com.lxl.lu.googlemvp.tasks.TasksActivity.class);
                break;
            case R.id.btnAntoTest:
                startActivity(AntoTestActivity.class);
                break;
        }
    }
    private void startActivity(Class clazz){
        startActivity(new Intent(this, clazz));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
