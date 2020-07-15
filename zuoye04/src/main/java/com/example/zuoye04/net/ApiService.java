package com.example.zuoye04.net;

import com.example.zuoye04.bean.FuliBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
//    https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/3
    String URL="https://gank.io/";
    @GET("api/data/%E7%A6%8F%E5%88%A9/10/3")
    Observable<FuliBean> getObsetvable();
}
