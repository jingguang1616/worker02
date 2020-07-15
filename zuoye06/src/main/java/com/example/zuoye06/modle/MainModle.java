package com.example.zuoye06.modle;

import com.example.zuoye06.base.BaseModle;
import com.example.zuoye06.bean.Shitilei;
import com.example.zuoye06.net.ApiService;
import com.example.zuoye06.presenter.MainPresenter;
import com.example.zuoye06.utils.BaseObserver;
import com.example.zuoye06.utils.HttpUtils;
import com.example.zuoye06.utils.RxUtils;

import io.reactivex.Observable;

public class MainModle extends BaseModle {

    public void getString(MainCallBork mainCallBork) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.URL, ApiService.class);
        Observable<Shitilei> getobservable = apiserver.getobservable();
        getobservable.compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<Shitilei>(this) {
                    @Override
                    protected void onSuccess(Shitilei shitilei) {
                        mainCallBork.Onsueecss(shitilei);
                    }

                    @Override
                    protected void error(String err) {
                    mainCallBork.OnFail(err);
                    }
                });

    }
}
