package com.example.lianxi02.base;

import java.util.ArrayList;

import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModle> modles=new ArrayList<>();
    public BasePresenter(){
        initModle();
    }

    protected abstract void initModle();
    public void addModle(BaseModle baseModle){
        modles.add(baseModle);
    }
    public void bindView(V view){
        mview=view;
    }
    public void disdoary(){
        mview=null;
        for (int i = 0; i < modles.size(); i++) {
            BaseModle baseModle = modles.get(i);
            baseModle.disposable();
        }
    }
}
