package com.example.zuoye08.presenter;

import com.example.zuoye08.modle.MainModle;
import com.example.zuoye08.view.MainView;
import com.example.zuoye08.base.BasePresenter;
import com.example.zuoye08.bean.Shitilei;
import com.example.zuoye08.modle.MainCallBork;

public class MainPresenter extends BasePresenter<MainView>implements MainCallBork {

    private MainModle mainModle;

    @Override
    protected void initModle() {
        mainModle = new MainModle();
        addModle(mainModle);
    }

    @Override
    public void Onsuccess(Shitilei shitilei) {
        if (mainModle!=null){

        }
        mview.setData(shitilei);
    }

    @Override
    public void OnFail(String str) {
        mview.showTsast(str);
    }

    public void getstring() {
       mainModle.getstring(this);
    }
}
