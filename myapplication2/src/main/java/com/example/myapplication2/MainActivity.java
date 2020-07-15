package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication2.base.BaseAcitvit;
import com.example.myapplication2.base.View;

public class MainActivity extends BaseAcitvit<P> implements View {

    @Override
    protected void initLis() {

    }

    @Override
    protected void initData() {
        mP.getData();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initPreserter() {
        mP=new P();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData() {

    }

    @Override
    public void showToast(String str) {

    }
}
