package com.example.myapplication.base;

import java.util.ArrayList;

public abstract class BasePersent<V extends BaseView> {
    //右手
    public V mview;
    //左手
    public ArrayList<BaseModel> baseModels=new ArrayList<>();

    //绑定V
    public void bindView(V view){
        mview=view;
    }
    //添加model
    public void addModel(BaseModel baseModel){
        baseModels.add(baseModel);
    }

    //解除绑定
    public  void destroy(){
        mview=null;
        if( baseModels!=null){
            for (int i = 0; i < baseModels.size(); i++) {
                baseModels.get(i).disposable();
            }
        }
    }

}
