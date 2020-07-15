package com.example.day04mvp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActivity<P extends BasePre> extends AppCompatActivity implements BaseView {
    public P pre;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPre();
        if (pre!=null){
            pre.baseview(this);
        }
        initview();
        intiData();
        initListent();
    }

    protected abstract void initListent();

    protected abstract void intiData();

    protected abstract void initview();

    protected abstract void initPre();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (pre!=null){
            pre.dispose();
            pre=null;
        }
    }
}

