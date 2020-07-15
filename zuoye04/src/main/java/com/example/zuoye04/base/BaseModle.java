package com.example.zuoye04.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModle{
    private CompositeDisposable mdisposable=null;
    public void addDisposable(Disposable disposable){
        if (mdisposable==null){
            synchronized (BaseModle.class){
                if (mdisposable==null){
                    mdisposable=new CompositeDisposable();
                }
            }
        }
        mdisposable.add(disposable);
    }
    public void disposable(){
        mdisposable.dispose();
    }
    public void removeDisposable(Disposable disposable){
        if (mdisposable!=null){
            mdisposable.remove(disposable);
            mdisposable=null;
        }
    }
}
