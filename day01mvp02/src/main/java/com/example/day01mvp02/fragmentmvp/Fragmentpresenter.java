package com.example.day01mvp02.fragmentmvp;

import com.example.day01mvp02.base.BasePre;
import com.example.day01mvp02.mvp.MainView;

public class Fragmentpresenter extends BasePre<FragmentView> implements FragmentCallBork {

    private FragmentModle modle;

    @Override
    protected void initModle() {
        modle = new FragmentModle();
        addModle(modle);
    }

    public void getString() {
        modle.getString(this);
    }

    @Override
    public void Onsucceed(String str) {
        mview.setdata(str);
    }

    @Override
    public void OnFild(String str) {
        mview.showTosat(str);
    }
}
