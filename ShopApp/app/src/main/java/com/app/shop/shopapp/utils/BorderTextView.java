package com.app.shop.shopapp.utils;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/14.
 */
public class BorderTextView extends TextView {


     public BorderTextView(Context context) {
        super(context);
    }
    public BorderTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

private int sreken_width=1;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();

        paint.setColor(Color.GRAY);
        //画四条边
        canvas.drawLine(0, 0, this.getWidth() - sreken_width, 0, paint);
        canvas.drawLine(0, 0, 0, this.getWidth() - sreken_width, paint);
        setTextUnLine(paint,canvas);

        canvas.drawLine(0,this.getHeight()-sreken_width,this.getWidth()-sreken_width,this.getHeight()-sreken_width,paint);
}

    private void setTextUnLine(Paint paint, Canvas canvas) {

        canvas.drawLine(this.getWidth() - sreken_width, 0, this.getWidth()-sreken_width,this.getHeight()-sreken_width,paint);
    }
}
