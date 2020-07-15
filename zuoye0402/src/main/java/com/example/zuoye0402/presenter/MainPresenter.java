package com.example.zuoye0402.presenter;

import com.example.zuoye0402.FuliBean;
import com.example.zuoye0402.base.BasePresenter;
import com.example.zuoye0402.modle.MainCallBaok;
import com.example.zuoye0402.modle.MainModle;
import com.example.zuoye0402.view.MainView;

public class MainPresenter extends BasePresenter<MainView>implements MainCallBaok {

    private MainModle mainModle;

    @Override
    protected void initModle() {
        mainModle = new MainModle();
        addModle(mainModle);
    }

    public void getstring() {
        mainModle.getString(this);
    }

    @Override
    public void Onsuccess(FuliBean fuliBean) {
        mview.initdata(fuliBean);
    }

    @Override
    public void OnFail(String str) {
        mview.showTosast(str);
    }
}
