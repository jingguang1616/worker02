package com.example.lianxihuabu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class sanjiao extends View {

    private final Paint paint;
    private Path path;

    public sanjiao(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        path = new Path();
        int x1=50,y1=50;
        int x2=150,y2=50;
        int x3=100,y3=100;
        path.moveTo(x1,y1);
        path.lineTo(x1,y1);
        path.lineTo(x2,y2);
        path.lineTo(x3,y3);
        path.lineTo(x1,y1);
        canvas.drawPath(path,paint);
        
        super.onDraw(canvas);

    }

}
