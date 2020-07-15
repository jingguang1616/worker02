package com.example.zuoye06;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.Toast;

import com.example.zuoye06.adapter.Rcyadapter;
import com.example.zuoye06.base.BaseActicity;
import com.example.zuoye06.bean.Shitilei;
import com.example.zuoye06.presenter.MainPresenter;
import com.example.zuoye06.view.MainView;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActicity<MainPresenter> implements MainView {

    @BindView(R.id.tb)
    Toolbar tb;
    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<Shitilei.DataBean.DatasBean> list;
    private Rcyadapter rcyadapter;
    int _position;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }

    @Override
    protected void initListen() {

    }

    @Override
    protected void initdata() {
        mpresenter.getString();
    }

    @Override
    protected void initview() {
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        rcyadapter = new Rcyadapter(list, this);
        rcy.setAdapter(rcyadapter);
        rcyadapter.setListen(new Rcyadapter.Listen() {
            @Override
            public void Chick(int position) {
                Shitilei.DataBean.DatasBean bean = list.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                String link = bean.getLink();
                intent.putExtra("link", link);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initPresenter() {
        mpresenter = new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setdata(Shitilei shitilei) {
        list.addAll(shitilei.getData().getDatas());
        rcyadapter.notifyDataSetChanged();
    }

    @Override
    public void showTosat(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
//跑马灯
    public class MarqueeTextView extends AppCompatTextView {

        private int marqueeNum = -1;//-1为永久循环，大于0是循环次数。`

        public void setMarqueeNum(int marqueeNum) {
            this.marqueeNum = marqueeNum;
        }

        public MarqueeTextView(Context context) {
            super(context);
            setAttr();
        }

        public MarqueeTextView(Context context, AttributeSet attrs) {
            super(context, attrs);
            setAttr();
        }

        public MarqueeTextView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            setAttr();
        }

        @Override
        public boolean isFocused() {
            return true;
        }

        private void setAttr() {
            this.setEllipsize(TextUtils.TruncateAt.MARQUEE);//设置跑马等效果
            this.setMarqueeRepeatLimit(marqueeNum);//设置跑马灯重复次数
            this.setSingleLine(true);//设置单行
        }
    }
}
