package com.example.day01mvp02.base;

import android.os.Bundle;

import com.example.day01mvp02.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity <P extends BasePre> extends AppCompatActivity implements BaseView {
    public P mbasepre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());//布局
        ButterKnife.bind(this);//需要用Butterknife找到组件1
        initpresenter();//子类必须创建p对象，给mpresenter赋值
        if (mbasepre!=null){
            mbasepre.beanview(this);//绑定布局view
        }
        initview();//初始化组件
        initdata();//初始化数据
        initListen();//初始化监听
    }

    protected abstract void initListen();

    protected abstract void initview();

    protected abstract void initdata();

    protected abstract void initpresenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mbasepre!=null){
            mbasepre.destroy();
            mbasepre=null;
        }
    }
}
