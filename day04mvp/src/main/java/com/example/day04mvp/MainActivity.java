package com.example.day04mvp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day04mvp.base.BaseActivity;
import com.example.day04mvp.base.BasePre;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<BasePre> implements BeanView {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.bt)
    Button bt;

    protected void initListent() {

    }

    @Override
    protected void intiData() {

    }

    @Override
    protected void initview() {
        tv.setText("我是首页");
    }

    @Override
    protected void initPre() {
        pre=new BeanPre();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setdata(String str) {
        tv.setText(str);
    }

    @Override
    public void ShowTosat(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.bt)
    public void onViewClicked() {
        pre.getString();

    }
}
