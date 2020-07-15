package com.example.zuoye04.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zuoye04.R;
import com.example.zuoye04.bean.FuliBean;
import com.example.zuoye04.utils.ImageLoader;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

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
        View view = LayoutInflater.from(context).inflate(R.layout.rcyitem, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FuliBean.ResultsBean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        ImageLoader.setIMage(context,bean.getUrl(),holder1.rcyIv);
        holder1.rcyTv.setText(bean.getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcy_iv)
        ImageView rcyIv;
        @BindView(R.id.rcy_tv)
        TextView rcyTv;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
