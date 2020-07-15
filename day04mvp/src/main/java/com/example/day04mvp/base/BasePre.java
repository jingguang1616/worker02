package com.example.day04mvp.base;

import java.util.ArrayList;

public abstract class BasePre<V extends BaseView> {
    public V mview;
    public ArrayList<BaseModle> mmodle=new ArrayList<>();
    public BasePre(){
        initmodle();
    }

    protected abstract void initmodle();
    public void addModle(BaseModle modle){
        mmodle.add(modle);
    }
    public void baseview(V mview){
        this.mview=mview;
    }
    public void dispose(){
        mview=null;
        for (int i = 0; i < mmodle.size(); i++) {
            BaseModle baseModle = mmodle.get(i);
            baseModle.dispose();
        }
    }


    public abstract void getString();

}
