package com.example.day01mvp02.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day01mvp02.R;

import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Basefragment<P extends BasePre> extends Fragment implements BaseView {
    public P presenter;
    private View view;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(getLayout(),null);
        unbinder = ButterKnife.bind(this, view);
        initpresenter();
        if (presenter!=null){
            presenter.beanview(this);
        }
        initview();//初始化组件
        initdata();
        initListen();
        return view;
    }

    protected abstract int getLayout();

    protected abstract void initListen();

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract void initpresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.destroy();
            presenter=null;
        }
    }
}
