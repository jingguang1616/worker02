package com.example.myapplication.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable=new CompositeDisposable();

    //类似懒加载
    public void Disposable(Disposable disposable){
        if (mdisposable==null){
            //枷锁
            synchronized (BaseModel.class){
                if (mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }
        }
    }
    //删除
    public void removeDisposable(Disposable disposable) {
        mdisposable.remove(disposable);
    }
    //销毁
    public void disposable(){
        mdisposable.dispose();
    }


}
