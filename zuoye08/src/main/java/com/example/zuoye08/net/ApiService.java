package com.example.zuoye08.net;

import com.example.zuoye08.bean.Jieshao;
import com.example.zuoye08.bean.Shitilei;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    String URL="https://api.yunxuekeji.cn/";

    @GET("yunxue_app_api/content/getData/30/66597/1/10")
    Observable<Shitilei> getobservable();
//    https://api.yunxuekeji.cn/

    @GET("yunxue_app_api/teacher/getTeacherPower/{ID}")
    Observable<Jieshao> getjieshao(@Path("ID") int id);
}
