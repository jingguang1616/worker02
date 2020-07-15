package com.example.zuoye04;

import android.os.Bundle;
import android.widget.Toast;

import com.example.zuoye04.adapter.Rcyadapter;
import com.example.zuoye04.base.BaseActicity;
import com.example.zuoye04.bean.FuliBean;
import com.example.zuoye04.mvp.BeanPresenter;
import com.example.zuoye04.mvp.BeanView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends BaseActicity<BeanPresenter> implements BeanView {

    @butterknife.BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<FuliBean.ResultsBean> list;
    private Rcyadapter rcyadapter;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        butterknife.ButterKnife.bind(this);
//    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void initdata() {
        mpresenter.getstring();
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
        mpresenter=new BeanPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void shouTosat(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(FuliBean fuliBean) {
        list.addAll(fuliBean.getResults());
        rcyadapter.notifyDataSetChanged();
    }
}
