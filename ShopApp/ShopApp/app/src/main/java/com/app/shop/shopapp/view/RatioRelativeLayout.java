package com.app.shop.shopapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.app.shop.shopapp.R;


/**
 * Created by cml on 2015/5/10.
 */
public class RatioRelativeLayout extends RelativeLayout {

    private float mRatioWidth;
    private float mRatioHeight;
    private float mRatio;

    public RatioRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public RatioRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray t = getContext().obtainStyledAttributes(attrs, R.styleable.RatioLayout);
        mRatioWidth = t.getFloat(R.styleable.RatioLayout_ratioWidth, 1);
        mRatioHeight = t.getFloat(R.styleable.RatioLayout_ratioHeight, 1);
        t.recycle();
        mRatio = mRatioHeight / mRatioWidth;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int wMode = MeasureSpec.getMode(widthMeasureSpec);
        // 根据宽和高宽比来设置高
        if (wMode == MeasureSpec.EXACTLY) {
            int wSize = MeasureSpec.getSize(widthMeasureSpec);
            int hSize = (int) (wSize * mRatio);
            super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(hSize, MeasureSpec.EXACTLY));
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
