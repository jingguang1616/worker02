package com.example.xiaoqiu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class BallView extends View {

    private final Paint paint;
    private float OKX=50;
    private float OKY=50;
    private Path path;
    int radius=50;
    private boolean ishsow;
    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (ishsow!=true){
            path = new Path();
            canvas.drawCircle(OKX,OKY,radius,paint);
        }
        super.onDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        radius=60;
        if (event.getAction()==MotionEvent.ACTION_MOVE){
            OKX=event.getX();
            OKY=event.getY();
            invalidate();
        }else if (event.getAction()==MotionEvent.ACTION_DOWN){
            OKX=event.getX();
            OKY=event.getY();
            invalidate();
        }else if (event.getAction()==MotionEvent.ACTION_UP){
            radius=0;
            invalidate();
        }
        return true;
    }
}
