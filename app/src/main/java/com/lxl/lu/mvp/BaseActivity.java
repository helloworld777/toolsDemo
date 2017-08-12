package com.lxl.lu.mvp;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity<T extends BasePresenter, M extends BaseModel> extends Activity {
    public T mPresenter; public M mModel;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        mPresenter = CreateUtil.getT(this, 0));
//        setContentView(getLayoutResId());
        mPresenter.attachModelView(mModel, this); initView();
    };
    //内部获取第一个类型参数的真实类型 ，
    // 反射new出对象
    //
    //
    //
    // 内部获取第二个类型参数的真实类型 ，反射new出对象 mModel = CreateUtil.getT(this, 1);
    // 使得P层绑定M层和V层，持有M和V的引用
    //

     @Override protected void onDestroy() {
    super.onDestroy();
    mPresenter.onDettach();
        } //子类Activity实现
 public abstract void initView();
    // 子类Activity实现
     public abstract int getLayoutResId() ; }


