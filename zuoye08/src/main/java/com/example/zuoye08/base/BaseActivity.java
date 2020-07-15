package com.example.zuoye08.base;

import android.os.Bundle;

import com.example.zuoye08.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P moresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initpresenter();
        if (moresenter!=null){
            moresenter.bindView(this);
        }
        initview();
        initData();
        initListen();
    }

    protected abstract void initListen();

    protected abstract void initData();

    protected abstract void initview();

    protected abstract void initpresenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (moresenter!=null){
            moresenter.disdory();
            moresenter=null;
        }
    }
}
