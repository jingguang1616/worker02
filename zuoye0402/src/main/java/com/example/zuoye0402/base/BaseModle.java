package com.example.zuoye0402.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModle {
    public CompositeDisposable mdisposable=null;
    public void adddisposable(Disposable disposable){
        if (mdisposable==null){
            synchronized (BaseModle.class){
                if (mdisposable==null){
                    mdisposable= new CompositeDisposable();
                }
            }
        }
        mdisposable.add(disposable);
    }
    public void Disposable(){
        mdisposable.dispose();
    }
    public void removeDisposable(Disposable disposable){
        mdisposable.remove(disposable);
        mdisposable=null;
    }
}
