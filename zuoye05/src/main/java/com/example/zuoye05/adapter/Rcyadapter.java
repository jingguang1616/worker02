package com.example.zuoye05.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zuoye05.R;
import com.example.zuoye05.bean.Shitilei;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Rcyadapter extends RecyclerView.Adapter {
    private ArrayList<Shitilei.T1348647909107Bean> list;
    private Context context;
    public boolean isshow;
    public Rcyadapter(ArrayList<Shitilei.T1348647909107Bean> list, Context context) {
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
        Shitilei.T1348647909107Bean bean = list.get(position);
        ViewHolder holder1= (ViewHolder) holder;
        Glide.with(context).load(bean.getUrl()).into(holder1.rcyIv);
        holder1.rcyTv.setText(bean.getTitle());
        if (isshow){
            holder1.cb.setVisibility(View.VISIBLE);
        }else {
            holder1.cb.setVisibility(View.INVISIBLE);
        }
        holder1.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                bean.setIschick(isChecked);

            }
        });
        if (bean.isIschick()){
            holder1.cb.setChecked(true);
        }else {
            holder1.cb.setChecked(false);
        }

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
        @BindView(R.id.cb)
        CheckBox cb;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
