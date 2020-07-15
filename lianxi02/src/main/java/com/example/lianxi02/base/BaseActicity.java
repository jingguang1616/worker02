package com.example.lianxi02.base;

import android.os.Bundle;

import com.example.lianxi02.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActicity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    private P mpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayout());
        ButterKnife.bind(this);
        initpresenter();
        if (mpresenter!=null){
            mpresenter.disdoary();
        }
        initview();
        initdata();
        initlisten();
    }

    protected abstract void initlisten();

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract void initpresenter();

    protected abstract int getlayout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mpresenter!=null){
            mpresenter.disdoary();
            mpresenter=null;
        }
    }
}
