package com.example.zuoye05.presenter;

import com.example.zuoye05.base.BasePresenter;
import com.example.zuoye05.base.BaseView;
import com.example.zuoye05.bean.Shitilei;
import com.example.zuoye05.modle.MainCallBark;
import com.example.zuoye05.modle.MainModle;
import com.example.zuoye05.view.MainView;

public class MainPresenter extends BasePresenter<MainView> implements MainCallBark {

    private MainModle mainModle;

    @Override
    protected void initModle() {
        mainModle = new MainModle();
        addmodle(mainModle);
    }

    public void getString() {
        mainModle.getString(this);
    }

    @Override
    public void Onsuccess(Shitilei shitilei) {
        mview.setData(shitilei);
    }

    @Override
    public void OnFail(String str) {
        mview.showToast(str);
    }


}
