package com.example.myapplication2.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable = null;

    public void addDispable(Disposable deprecate){
        if (mdisposable==null){
            synchronized (this){
                if (mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }

        }
        mdisposable.add(deprecate);

    }
    public void Disposable(){
        mdisposable.dispose();
    }
    public void removeDisposable(Disposable disposable){
        mdisposable.remove(disposable);
    }

}
