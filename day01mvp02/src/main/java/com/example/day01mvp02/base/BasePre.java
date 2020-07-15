package com.example.day01mvp02.base;

import java.util.ArrayList;

public abstract class BasePre<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModle> modles=new ArrayList<>();
    public BasePre(){
        initModle();
    }

    protected abstract void initModle();
    public void addModle(BaseModle baseModle){
        modles.add(baseModle);
    }
    public void beanview(V mview){
        this.mview=mview;
    }
    public void destroy(){
        mview=null;
        for (int i = 0; i < modles.size(); i++) {
            BaseModle baseModle = modles.get(i);
            baseModle.disposable();
        }
    }
}
