package com.example.myapplication2.base;

import android.os.Bundle;

import com.example.myapplication2.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseAcitvit<P extends BAsePreserter>extends AppCompatActivity implements BaseView {
    public P mP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPreserter();
        if (mP!=null){
            mP.BindView(this);
        }
        initView();
        initData();
        initLis();
    }

    protected abstract void initLis();

    protected abstract void initData();

    protected abstract void initView();

    protected abstract void initPreserter();

    protected abstract int getLayout();


}
