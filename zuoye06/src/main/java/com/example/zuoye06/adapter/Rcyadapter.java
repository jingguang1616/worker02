package com.example.zuoye06.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zuoye06.R;
import com.example.zuoye06.bean.Shitilei;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Rcyadapter extends RecyclerView.Adapter {
    private ArrayList<Shitilei.DataBean.DatasBean> list;
    private Context context;
    private int TYPE1 = 1;
    private int TYPE2 = 2;

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 1) {
            return TYPE1;
        } else {
            return TYPE2;
        }
    }

    public Rcyadapter(ArrayList<Shitilei.DataBean.DatasBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE1) {
            View view = LayoutInflater.from(context).inflate(R.layout.rcy1, parent, false);
            ViewHolder1 holder1 = new ViewHolder1(view);
            return holder1;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.rcy2, parent, false);
            ViewHolder2 holder2 = new ViewHolder2(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listen!=null){
                        listen.Chick(holder2.getLayoutPosition());
                    }
                }
            });
            return holder2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Shitilei.DataBean.DatasBean bean = list.get(position);
        if (getItemViewType(position)==TYPE1){
            ViewHolder1 holder1= (ViewHolder1) holder;
            holder1.rcy1Tv1.setText(bean.getLink());
            holder1.rcy1Tv2.setText(bean.getChapterName());
            holder1.rcy1Tv3.setText(bean.getDesc());
        }else {
            ViewHolder2 holder2= (ViewHolder2) holder;
            Glide.with(context).load(bean.getEnvelopePic()).into(holder2.rcy2Iv);
            holder2.rcy2Tv1.setText(bean.getLink());
            holder2.rcy2Tv2.setText(bean.getChapterName());
            holder2.rcy2Tv3.setText(bean.getDesc());
        }
    }
    public interface Listen{
        void Chick(int position);
    }
    Listen listen;

    public Listen getListen() {
        return listen;
    }

    public void setListen(Listen listen) {
        this.listen = listen;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.rcy1_tv1)
        TextView rcy1Tv1;
        @BindView(R.id.rcy1_tv2)
        TextView rcy1Tv2;
        @BindView(R.id.rcy1_tv3)
        TextView rcy1Tv3;

        ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static
    class ViewHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.rcy2_tv1)
        TextView rcy2Tv1;
        @BindView(R.id.rcy2_tv2)
        TextView rcy2Tv2;
        @BindView(R.id.rcy2_tv3)
        TextView rcy2Tv3;
        @BindView(R.id.rcy2_iv)
        ImageView rcy2Iv;

        ViewHolder2(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
