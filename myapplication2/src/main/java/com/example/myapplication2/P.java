package com.example.myapplication2;

import com.example.myapplication2.base.BAsePreserter;
import com.example.myapplication2.base.View;

public class P extends BAsePreserter<View> implements CollBack {
    private Model model;
    @Override
    protected void initModel() {
        model=new Model();
        addMOdel(model);
    }

    public void getData() {

    }
}
