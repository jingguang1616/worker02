package com.example.day01mvp02;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.day01mvp02.base.Basefragment;
import com.example.day01mvp02.fragmentmvp.FragmentView;
import com.example.day01mvp02.fragmentmvp.Fragmentpresenter;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Basefragment<Fragmentpresenter> implements FragmentView {

    @BindView(R.id.tv1)
    TextView tv1;

    @OnClick(R.id.tv1)
    public void onViewClicked() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_1;
    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void initdata() {
        presenter.getString();
    }

    @Override
    protected void initview() {
        tv1.setText("11111");
    }

    @Override
    protected void initpresenter() {
        presenter=new Fragmentpresenter();
    }

    @Override
    public void setdata(String str) {
        tv1.setText(str);
    }

    @Override
    public void showTosat(String str) {
        Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
    }
}
