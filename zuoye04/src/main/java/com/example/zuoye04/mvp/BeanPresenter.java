package com.example.zuoye04.mvp;

import com.example.zuoye04.base.BasePresenter;
import com.example.zuoye04.bean.FuliBean;

public class BeanPresenter extends BasePresenter<BeanView> implements BeanCallBark {

    private BeanModle beanModle;

    @Override
    protected void initModle() {
        beanModle = new BeanModle();
        addModle(beanModle);
    }

    @Override
    public void Onsueecss(FuliBean fuliBean) {
        mview.setData(fuliBean);
    }

    @Override
    public void OnFail(String str) {
        mview.shouTosat(str);
    }

    public void getstring() {
        beanModle.getstring(this);
    }
}
