package com.example.zuoye04.mvp;

import com.example.zuoye04.base.BaseModle;
import com.example.zuoye04.bean.FuliBean;
import com.example.zuoye04.net.ApiService;
import com.example.zuoye04.net.BaseObserver;
import com.example.zuoye04.net.HttpUtils;
import com.example.zuoye04.net.RxUtils;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class BeanModle extends BaseModle {

    public void getstring(BeanCallBark beanCallBark) {
        ApiService apiserver = HttpUtils.getInstance().getApiserver(ApiService.URL, ApiService.class);
        Observable<FuliBean> obsetvable = apiserver.getObsetvable();
        obsetvable.compose(RxUtils.rxObserableSchedulerHelper())
                .subscribe(new BaseObserver<FuliBean>(this) {
                    @Override
                    protected void onSuccess(FuliBean fuliBean) {
                        beanCallBark.Onsueecss(fuliBean);
                    }

                    @Override
                    protected void error(String err) {
                        beanCallBark.OnFail(err);
                    }
                });
    }
}
