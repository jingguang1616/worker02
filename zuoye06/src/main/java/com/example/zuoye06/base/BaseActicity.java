package com.example.zuoye06.base;

import android.os.Bundle;

import com.example.zuoye06.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public abstract class BaseActicity<P extends BasePresenter> extends AppCompatActivity implements BaseView {
    public P mpresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initPresenter();
        if (mpresenter!=null){
            mpresenter.bindview(this);
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
        if (mpresenter!=null){
            mpresenter.dispory();
            mpresenter=null;
        }
    }
}
