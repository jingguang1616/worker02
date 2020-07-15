package com.example.zuoye06.presenter;

import com.example.zuoye06.base.BasePresenter;
import com.example.zuoye06.bean.Shitilei;
import com.example.zuoye06.modle.MainCallBork;
import com.example.zuoye06.modle.MainModle;
import com.example.zuoye06.view.MainView;

public class MainPresenter extends BasePresenter<MainView> implements MainCallBork {


    private MainModle mainModle;

    @Override
    protected void initModle() {
        mainModle = new MainModle();
        addModle(mainModle);
    }

    @Override
    public void Onsueecss(Shitilei shitilei) {
        mview.setdata(shitilei);
    }

    @Override
    public void OnFail(String str) {
        mview.showTosat(str);
    }


    public void getString() {
        mainModle.getString(this);
    }
}
