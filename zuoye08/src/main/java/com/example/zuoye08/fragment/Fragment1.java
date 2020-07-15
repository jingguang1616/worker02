package com.example.zuoye08.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zuoye08.R;
import com.example.zuoye08.adapter.F1adapter;
import com.example.zuoye08.bean.Jianjie;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    private View view;
    private ArrayList<Jianjie.BodyBean.ResultBean> list;
    private F1adapter f1adapter;
    private RecyclerView rcy;


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_1, container, false);
        TextView tv = view.findViewById(R.id.tvf1);
//        rcy = view.findViewById(R.id.rcya);
//        rcy.setLayoutManager(new LinearLayoutManager(getActivity()));
//        rcy.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));
//        list = new ArrayList<>();
//        f1adapter = new F1adapter(list, getActivity());
//        rcy.setAdapter(f1adapter);
//        initview();
        tv.setText("11111111111111111111111111");
        return view;
    }
}
