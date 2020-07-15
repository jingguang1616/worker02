package com.example.myapplication2.base;

import android.view.View;

import java.util.ArrayList;

public abstract class BAsePreserter<V extends BaseView> {
    public V mView;
    public ArrayList<BaseModel> models=new ArrayList<>();
    public BAsePreserter(){
        initModel();
    }
    public void BindView(V view){
        this.mView= view;
    }

    protected abstract void initModel();
    public void addMOdel(BaseModel baseModel){
        models.add(baseModel);
    }
    public void Destroy(){
        mView=null;
        for (int i = 0; i < models.size(); i++) {
            models.get(i).Disposable();

        }
    }
}
