package com.example.day04mvp.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModle {
    private CompositeDisposable mDisposbale=null;
    public void addDisposable(Disposable disposable){
        if (mDisposbale==null){
            synchronized (BaseView.class){
                if (mDisposbale==null){
                    mDisposbale=new CompositeDisposable();
                }
            }
        }
        mDisposbale.add(disposable);
    }
    public void dispose(){
        mDisposbale.dispose();
    }
    public void removeDispose(Disposable disposable){
        if (disposable!=null){
            mDisposbale.remove(disposable);
        }
    }
}
