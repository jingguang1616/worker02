package com.example.zuoye05;

import com.example.zuoye05.bean.Shitilei;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
//
    String URL="http://c.m.163.com/";
    @GET("nc/article/headline/T1348647909107/0-20.html")
    Observable<Shitilei> getobsetvable();
}
