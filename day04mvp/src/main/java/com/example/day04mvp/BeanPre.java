package com.example.day04mvp;

import com.example.day04mvp.base.BaseModle;
import com.example.day04mvp.base.BasePre;

import java.util.ArrayList;

public class BeanPre extends BasePre<BeanView>implements Beancallbork {
    public Beanmodle beanmodle;

    @Override
    protected void initmodle() {
        beanmodle = new Beanmodle();
        addModle(beanmodle);
    }

    @Override
    public void getString() {
        beanmodle.getstring(this);

    }


    @Override
    public void Onseelcss(String str) {
        mview.setdata(str);
    }

    @Override
    public void OnFail(String str) {
        mview.ShowTosat(str);
    }
}
