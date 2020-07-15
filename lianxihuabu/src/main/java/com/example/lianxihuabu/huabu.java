package com.example.lianxihuabu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class huabu extends TextView {
    public huabu(Context context) {
        super(context);
    }
    public huabu(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public huabu(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLUE);
        canvas.rotate(30,getMeasuredHeight()/10,getMeasuredWidth()/10);
        super.onDraw(canvas);
    }
}
