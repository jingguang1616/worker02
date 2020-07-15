package com.example.lianxihuabu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Myline extends View {

    private final Paint paint;

    public Myline(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(15);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int filax=50;
        int filay=50;
        int startx=500;
        int starty=50;
        canvas.drawLine(filax,filay,startx,starty,paint);
    }
}
