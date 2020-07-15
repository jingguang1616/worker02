package com.example.day04mvp;

import com.example.day04mvp.base.BaseModle;

public class Beanmodle extends BaseModle {
    public void getstring(Beancallbork beancallbork){
        try {
            String str="来自星星的我";
            beancallbork.Onseelcss(str);
        } catch (Exception e) {
            e.printStackTrace();
            beancallbork.OnFail(e.getMessage());
        }
    }
}
