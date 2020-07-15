package com.example.zuoye08;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.zuoye08.adapter.Vpadapter;
import com.example.zuoye08.bean.Jieshao;
import com.example.zuoye08.bean.Shitilei;
import com.example.zuoye08.fragment.Fragment1;
import com.example.zuoye08.fragment.Fragment2;
import com.example.zuoye08.fragment.Fragment3;
import com.example.zuoye08.net.ApiService;
import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.rcy2)
    RecyclerView rcy2;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    private ArrayList<Shitilei.BodyBean.ResultBean> list;
    private Myadapter myadapter;
    private ArrayList<Fragment> fragmentlist;
    private Vpadapter vpadapter;
    String ID;
    private Shitilei.BodyBean.ResultBean bean;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {

        rcy2.setLayoutManager(new LinearLayoutManager(this));
        rcy2.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        Intent intent = getIntent();
        bean = (Shitilei.BodyBean.ResultBean) intent.getSerializableExtra("bean");
        id = bean.getID();
        list.add(bean);
        myadapter = new Myadapter(list, this);
        rcy2.setAdapter(myadapter);
        initvp();
        initdata();
    }
    private void initvp() {
        fragmentlist = new ArrayList<>();
        fragmentlist.add(new Fragment1());
        fragmentlist.add(new Fragment2());
        fragmentlist.add(new Fragment3());
        vpadapter = new Vpadapter(getSupportFragmentManager(), 0, fragmentlist);
        vp.setAdapter(vpadapter);
        tab.setupWithViewPager(vp);
//        tab.getTabAt(0).setText("介绍");
//        tab.getTabAt(1).setText("课程");
//        tab.getTabAt(2).setText("专题");
    }

    private void initdata() {
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = build.create(ApiService.class);
        apiService.getjieshao(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Jieshao>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Jieshao jieshao) {
                        List<Jieshao.BodyBean.ResultBean> result = jieshao.getBody().getResult();
                        for (int i = 0; i < result.size(); i++) {
//                            tab.addTab(tab.newTab().setText(result.get(i).getDescription()));
                            tab.getTabAt(i).setText(result.get(i).getDescription());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("111", "onError: "+e.getMessage() );
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
