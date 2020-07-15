package com.example.day01mvp02;

import android.content.Intent;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day01mvp02.base.BaseActivity;
import com.example.day01mvp02.mvp.MainPresenter;
import com.example.day01mvp02.mvp.MainView;

import java.util.ArrayList;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<FuliBean.ResultsBean> list;
    private Myadapter myadapter;

    @Override
    protected void initListen() {

    }

    @Override
    protected void initview() {
        tv.setText("我的天");
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        myadapter = new Myadapter(list, this);
        rcy.setAdapter(myadapter);
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void initdata() {
        mbasepre.getString();
    }

    @Override
    protected void initpresenter() {
        mbasepre=new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(FuliBean fuliBean) {
        list.addAll(fuliBean.getResults());
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void showTosat(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
