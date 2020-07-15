package com.example.lianxi01.base;

import android.os.Bundle;

import com.example.lianxi01.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActicity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P mpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());//布局
        ButterKnife.bind(this);
        if (mpresenter!=null){
            mpresenter.bindview(this);
        }
        initpresenter();
        initview();
        initdata();
        initListen();
    }

    protected abstract void initListen();

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract void initpresenter();

    protected abstract int getLayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter!=null){
            mpresenter.disdoary();
            mpresenter=null;
        }
    }
}
