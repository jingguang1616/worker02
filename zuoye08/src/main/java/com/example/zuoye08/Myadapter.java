package com.example.zuoye08;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.zuoye08.bean.Shitilei;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class Myadapter extends RecyclerView.Adapter {
    private ArrayList<Shitilei.BodyBean.ResultBean> list;
    private Context context;
    public boolean guanzhu;

    public Myadapter(ArrayList<Shitilei.BodyBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main1_item, null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ItemOnchickLis !=null){
                    ItemOnchickLis.chick(holder.getLayoutPosition());
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Shitilei.BodyBean.ResultBean bean = list.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        RequestOptions requestOptions = new RequestOptions();
        RequestOptions crop = requestOptions.circleCrop();
        Glide.with(context).load(bean.getTeacherPic()).apply(crop).into(holder1.rcy1Iv);
        holder1.rcy1Name.setText(bean.getTeacherName());
        holder1.zhiwei.setText(bean.getTitle());
//        holder1.biaoqian.setText(bean.get);
    }
    public interface setOnchickLis{
        void chick(int position);
    }
    setOnchickLis ItemOnchickLis;

    public Myadapter.setOnchickLis getItemOnchickLis() {
        return ItemOnchickLis;
    }

    public void setItemOnchickLis(Myadapter.setOnchickLis itemOnchickLis) {
        this.ItemOnchickLis = itemOnchickLis;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rcy1_iv)
        ImageView rcy1Iv;
        @BindView(R.id.rcy1_name)
        TextView rcy1Name;
        @BindView(R.id.zhiwei)
        TextView zhiwei;
        @BindView(R.id.biaoqian)
        TextView biaoqian;
        @BindView(R.id.bt)
        Button bt;
        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
