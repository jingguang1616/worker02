package com.example.myview02;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class Simping extends RelativeLayout {

    private ArrayList<String> list;
    private ListView listView;
    private PopupWindow popupWindow;

    public Simping(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.simping, this);
        init();
        initdata();
    }

    private void init() {
        final EditText et = findViewById(R.id.et);
        ImageView iv = findViewById(R.id.iv);
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listView = new ListView(getContext());
                listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_expandable_list_item_1,list));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String s = list.get(position);
                        et.setText(s);
                        et.setSelection(s.length());
                        popupWindow.dismiss();
                    }
                });
                popupWindow = new PopupWindow(listView, et.getWidth(), 600);
                popupWindow.setBackgroundDrawable(null);
                popupWindow.setOutsideTouchable(true);
                popupWindow.setFocusable(true);
                popupWindow.showAsDropDown(et);

            }
        });
    }

    private void initdata() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("又帅了"+i);
        }
    }

}
