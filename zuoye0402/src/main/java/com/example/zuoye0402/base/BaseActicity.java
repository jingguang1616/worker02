package com.example.zuoye0402.base;

import android.os.Bundle;

import com.example.zuoye0402.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActicity <P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P mbasepresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPresenter();
        if (mbasepresenter!=null){
            mbasepresenter.bindview(this);
        }
        initview();
        initdata();
        initListen();
    }

    protected abstract void initListen();

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract void initPresenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mbasepresenter!=null){
            mbasepresenter.destory();
            mbasepresenter=null;
        }
    }
}
