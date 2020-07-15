package com.example.day01mvp02;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
//import butterknife.BindView;
//import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity {


    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    private ArrayList<Fragment> list;
    private Vpadapter vpadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        list = new ArrayList<>();
        list.add(new Fragment1());
        vpadapter = new Vpadapter(getSupportFragmentManager(),0,list);
        vp.setAdapter(vpadapter);
        tab.setupWithViewPager(vp);
        tab.getTabAt(0).setText("1");
////        tab.getTabAt(1).setText("2");
    }
}
