package com.example.day01mvp02.mvp;

import com.example.day01mvp02.ApiService;
import com.example.day01mvp02.FuliBean;
import com.example.day01mvp02.base.BaseModle;
import com.example.day01mvp02.mvp.Maincallbork;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModle extends BaseModle {
    public void getString(Maincallbork maincallbork){
//        try {
//            String a="哈哈";
//            maincallbork.seelcss(a);
//        } catch (Exception e) {
//            e.printStackTrace();
//            maincallbork.OnFail(e.getMessage());
//        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<FuliBean> fuli = apiService.getFuli();
        fuli.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FuliBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    adddisposable(d);
                    }

                    @Override
                    public void onNext(FuliBean fuliBean) {
                    maincallbork.seelcss(fuliBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    maincallbork.OnFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
