package com.lu.test;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.lxl.lu.toolsample.MainActivity;
import com.lxl.lu.toolsample.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressBack;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by lyw on 2017/9/2.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest  {

    @Rule
    public ActivityTestRule activityTestRule=new ActivityTestRule(MainActivity.class);
    MainActivity mActivity;



    @Test
    public void testBtn() {
        //通过id找到button，执行点击事件
        Espresso.onView(withId(R.id.btnAntoTest)).perform(click()); //通过id找到textview，并判断是否与文本匹配
//        Espresso.pressBack();



    }


}
