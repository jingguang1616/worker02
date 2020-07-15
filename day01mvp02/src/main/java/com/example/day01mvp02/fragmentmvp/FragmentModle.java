package com.example.day01mvp02.fragmentmvp;

import com.example.day01mvp02.base.BaseModle;

public class FragmentModle extends BaseModle {

    public void getString(FragmentCallBork fragmentCallBork) {
        try {
            String a="asoidoashd";
            fragmentCallBork.Onsucceed(a);
        } catch (Exception e) {
            fragmentCallBork.OnFild(e.getMessage());
            e.printStackTrace();
        }
    }
}
