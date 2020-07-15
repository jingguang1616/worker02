package com.example.zuoye05.modle;

import com.example.zuoye05.ApiService;
import com.example.zuoye05.base.BaseModle;
import com.example.zuoye05.base.BaseView;
import com.example.zuoye05.bean.Shitilei;
import com.example.zuoye05.presenter.MainPresenter;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModle extends BaseModle {
    public void getString(MainCallBark mainCallBark) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getobsetvable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shitilei>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Shitilei shitilei) {
                        mainCallBark.Onsuccess(shitilei);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBark.OnFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
