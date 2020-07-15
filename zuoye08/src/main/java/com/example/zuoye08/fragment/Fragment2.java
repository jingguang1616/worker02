package com.example.zuoye08.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zuoye08.Main3Activity;
import com.example.zuoye08.Myadapter;
import com.example.zuoye08.R;
import com.example.zuoye08.bean.Shitilei;
import com.example.zuoye08.net.ApiService;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {

    private RecyclerView rcy;
    private View view;
    private ArrayList<Shitilei.BodyBean.ResultBean> list;
    private Myadapter myadapter;

    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_2, container, false);
        rcy = view.findViewById(R.id.f2rcy);
        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcy.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        initdata();
        myadapter = new Myadapter(list, getActivity());
        rcy.setAdapter(myadapter);
        myadapter.setItemOnchickLis(new Myadapter.setOnchickLis() {
            @Override
            public void chick(int position) {
                startActivity(new Intent(getActivity(), Main3Activity.class));
            }
        });
        return view;
    }

    private void initdata() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        apiService.getobservable().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shitilei>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Shitilei shitilei) {
                        list.addAll(shitilei.getBody().getResult());
                        myadapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
