package com.app.shop.shopapp.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * <文字点击>
 *
 * @author lwli
 * @data: 2015/10/30 17:24
 * @version: V1.0
 */
public class ClickTextView extends TextView {
    public ClickTextView(Context context) {
        super(context);
    }

    public ClickTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ClickTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                //在按下事件中设置滤镜
                setFilter();
                break;
            case MotionEvent.ACTION_UP:
                //由于捕获了Touch事件，需要手动触发Click事件
                performClick();
            case MotionEvent.ACTION_CANCEL:
                //在CANCEL和UP事件中清除滤镜
                removeFilter();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     *   设置滤镜
     */
    private void setFilter() {
        Drawable[] drawables=getCompoundDrawables();
        if(drawables!=null&&drawables.length>0){
            for(Drawable dw:drawables){
                if(dw!=null)dw.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);;
            }
        }
    }
    /**
     *   清除滤镜
     */
    private void removeFilter() {
        Drawable[] drawables=getCompoundDrawables();
        if(drawables!=null&&drawables.length>0){
            for(Drawable dw:drawables){
                if(dw!=null)dw.clearColorFilter();
            }
        }
    }
}
