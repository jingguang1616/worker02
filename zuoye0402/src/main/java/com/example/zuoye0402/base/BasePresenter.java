package com.example.zuoye0402.base;

import java.util.ArrayList;

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
    public void bindview(V view){
        mview=view;
    }
    public void destory(){
        mview=null;
        for (int i = 0; i < modles.size(); i++) {
            BaseModle modle = modles.get(i);
            modle.Disposable();
        }
    }
}
