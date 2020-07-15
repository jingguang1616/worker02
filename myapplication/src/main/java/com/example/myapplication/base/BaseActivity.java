package com.example.myapplication.base;

import android.os.Bundle;

import com.example.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<P extends BasePersent> extends AppCompatActivity implements BaseView{

    public P mpersent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initpersent();
        if (mpersent!=null){
            mpersent.bindView(this);
        }
        initView();
        initListentr();
        initData();
    }

    protected abstract void initpersent();

    protected abstract void initView();

    protected abstract void initListentr();

    protected abstract void initData();


    protected abstract int getLayout();

}
