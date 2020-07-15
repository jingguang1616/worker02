package com.example.zuoye08;

import android.content.Intent;
import android.widget.Toast;

import com.example.zuoye08.base.BaseActivity;
import com.example.zuoye08.bean.Shitilei;
import com.example.zuoye08.presenter.MainPresenter;
import com.example.zuoye08.view.MainView;

import java.util.ArrayList;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter> implements MainView {

    @BindView(R.id.rcy)
    RecyclerView rcy;
    private ArrayList<Shitilei.BodyBean.ResultBean> list;
    private Myadapter myadapter;
    private int _position;
    @Override
    protected void initListen() {

    }

    @Override
    protected void initData() {
        moresenter.getstring();
    }

    @Override
    protected void initview() {
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        list = new ArrayList<>();
        myadapter = new Myadapter(list, this);
        rcy.setAdapter(myadapter);
        myadapter.setItemOnchickLis(new Myadapter.setOnchickLis() {
            @Override
            public void chick(int position) {
                Shitilei.BodyBean.ResultBean bean = list.get(position);
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                int id = bean.getID();
                intent.putExtra("bean",bean);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
        initweb();
    }

    private void initweb() {


    }

    @Override
    protected void initpresenter() {
        moresenter=new MainPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(Shitilei shitilei) {
        list.addAll(shitilei.getBody().getResult());
        myadapter.notifyDataSetChanged();
    }

    @Override
    public void showTsast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//    }
}
