package com.example.myview1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Sping  extends RelativeLayout {
    private ListView listView;
    private ArrayList<String> list;
    private final View view;

    public Sping(Context context, AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(getContext()).inflate(R.layout.sping, this);
        initView();
        initdata();
    }



    private void initView() {
        final EditText et = findViewById(R.id.et);
        ImageView iv = findViewById(R.id.iv);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listView = new ListView(getContext());//给popup设置布局
                //绑定适配器 android.R.layout.simple_expandable_list_item_1系统自带的Textview
                listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,list));
                final PopupWindow popupWindow = new PopupWindow(listView, et.getWidth(),600);
                popupWindow.setBackgroundDrawable(null);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(et);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String s = list.get(position);
                        et.setText(s);
                        et.setSelection(s.length());
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
    private void initdata() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("张三"+i);
        }
    }
}
