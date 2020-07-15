package com.example.day01mvp02.mvp;

import android.util.Log;

import com.example.day01mvp02.FuliBean;
import com.example.day01mvp02.base.BasePre;
import com.example.day01mvp02.mvp.MainModle;
import com.example.day01mvp02.mvp.MainView;
import com.example.day01mvp02.mvp.Maincallbork;

public class MainPresenter extends BasePre<MainView> implements Maincallbork {
    private MainModle mainModle;

    @Override
    protected void initModle() {
        mainModle = new MainModle();
        addModle(mainModle);
    }

    public void getString() {
        mainModle.getString(this);
    }

    @Override
    public void seelcss(FuliBean fuliBean) {
        mview.initData(fuliBean);
    }

    @Override
    public void OnFail(String str) {
        mview.showTosat(str);
        Log.i("999", "OnFail: "+str);
    }


}
