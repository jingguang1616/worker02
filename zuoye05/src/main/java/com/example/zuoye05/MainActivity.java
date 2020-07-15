package com.example.zuoye05;

import android.os.Bundle;
import android.transition.Visibility;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zuoye05.adapter.Rcyadapter;
import com.example.zuoye05.base.BaseActicity;
import com.example.zuoye05.base.BasePresenter;
import com.example.zuoye05.bean.Shitilei;
import com.example.zuoye05.presenter.MainPresenter;
import com.example.zuoye05.view.MainView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActicity<MainPresenter> implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    @BindView(R.id.bt1)
    Button bt1;
    @BindView(R.id.bt2)
    Button bt2;
    @BindView(R.id.bt3)
    Button bt3;
    private ArrayList<Shitilei.T1348647909107Bean> list;
    private Rcyadapter rcyadapter;


    @OnClick({R.id.bt1, R.id.bt2, R.id.bt3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt1:
//                bt1.setVisibility(View.VISIBLE);
                rcyadapter.isshow=true;
                rcyadapter.notifyDataSetChanged();
                break;
            case R.id.bt2:
                initchick();
                break;
            case R.id.bt3:
                rcyadapter.isshow=false;
                rcyadapter.notifyDataSetChanged();
                break;
        }
    }

    private void initchick() {
        ArrayList<Shitilei.T1348647909107Bean> beans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Shitilei.T1348647909107Bean bean = list.get(i);
            if (!bean.isIschick()){
                beans.add(bean);
            }
        }
        list.clear();
        list.addAll(beans);
        rcyadapter.notifyDataSetChanged();
    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void initdata() {
        mpresenter.getString();
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
    protected void initpresenter() {
        mpresenter=new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(Shitilei shitilei) {
        list.addAll(shitilei.getT1348647909107());
        rcyadapter.notifyDataSetChanged();
    }
}
