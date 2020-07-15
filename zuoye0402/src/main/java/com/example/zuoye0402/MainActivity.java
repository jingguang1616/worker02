package com.example.zuoye0402;

import android.os.Bundle;
import android.widget.Toast;

import com.example.zuoye0402.base.BaseActicity;
import com.example.zuoye0402.base.BasePresenter;
import com.example.zuoye0402.presenter.MainPresenter;
import com.example.zuoye0402.view.MainView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActicity<MainPresenter>implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<FuliBean.ResultsBean> list;
    private Rcyadapter rcyadapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initListen() {

    }

    @Override
    public void initdata() {
        mbasepresenter.getstring();
    }

    @Override
    protected void initview() {
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        rcyadapter = new Rcyadapter(list, this);
        rcy.setAdapter(rcyadapter);
    }

    @Override
    protected void initPresenter() {
        mbasepresenter=new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showTosast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void initdata(FuliBean fuliBean) {
        list.addAll(fuliBean.getResults());
        rcyadapter.notifyDataSetChanged();
    }
}
