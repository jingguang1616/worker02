package com.example.zuoye0402.modle;

import com.example.zuoye0402.FuliBean;
import com.example.zuoye0402.base.BaseModle;
import com.example.zuoye0402.net.BaseObserver;
import com.example.zuoye0402.net.HttpUtils;
import com.example.zuoye0402.net.RxUtils;
import com.example.zuoye0402.presenter.MainPresenter;

import java.net.HttpURLConnection;

import io.reactivex.Observable;

public class MainModle extends BaseModle {

    public void getString(MainCallBaok mainCallBaok) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.URL, ApiService.class);
        Observable<FuliBean> obsetvable = apiserver.getObsetvable();
        obsetvable.compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FuliBean>(this) {
                    @Override
                    protected void onSuccess(FuliBean fuliBean) {
                        mainCallBaok.Onsuccess(fuliBean);
                    }

                    @Override
                    protected void error(String err) {
                        mainCallBaok.OnFail(err);
                    }
                });

    }
}
