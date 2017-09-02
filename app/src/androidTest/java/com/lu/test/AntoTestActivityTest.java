package com.lu.test;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.lxl.lu.toolsample.AntoTestActivity;
import com.lxl.lu.toolsample.MainActivity;
import com.lxl.lu.toolsample.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by lyw on 2017/9/2.
 */
@RunWith(AndroidJUnit4.class)
public class AntoTestActivityTest {
    @Rule
    public ActivityTestRule activityTestRule=new ActivityTestRule(AntoTestActivity.class);
    private String mStringToBetyped="abc";
    @Before
    public void initValidString() {
        // 初始化一个字符串
        mStringToBetyped = "Espresso";
    }
    @Test
    public void test() {
        //通过id找到edittext，在里面输入2并关闭输入法
        onView(withId(R.id.etUsername)).perform(typeText(mStringToBetyped), closeSoftKeyboard());
        //通过id找到edittext，在里面输入5并关闭输入法
        onView(withId(R.id.etPwd)).perform(typeText("123456"), closeSoftKeyboard());
        //通过id找到button，执行点击事件
        onView(withId(R.id.btnLogin)).perform(click()); //通过id找到textview，并判断是否与文本匹配


        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.etUsername)).check(matches(withText(mStringToBetyped)));
//        onView(withId(R.id.tvResult)).check(matches(withText("计算结果：7")));


        onView(withId(R.id.etUsername)).perform(typeText("Steve"));
        onView(withId(R.id.btnLogin)).perform(click());
//        onView(withText("Hello Steve!")).check(matches(isDisplayed()));



    }
}
