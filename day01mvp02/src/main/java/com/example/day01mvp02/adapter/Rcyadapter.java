package com.example.day01mvp02.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.example.day01mvp02.FuliBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Rcyadapter extends RecyclerView.Adapter {
    private ArrayList<FuliBean.ResultsBean> list;
    private Context context;

    public Rcyadapter(ArrayList<FuliBean.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
