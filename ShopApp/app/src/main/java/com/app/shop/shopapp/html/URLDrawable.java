package com.app.shop.shopapp.html;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class URLDrawable extends BitmapDrawable {

	private Drawable drawable;
	int width=0;

	public URLDrawable(Context context,Drawable defaultDraw) {
		setDrawable(defaultDraw);
		width=context.getResources().getDisplayMetrics().widthPixels;

	}

	public void setDrawable(Drawable nDrawable) {
		drawable = nDrawable;
		int height=width*2-width/2;

		drawable.setBounds(0, 0, width,
				height);

		setBounds(0, 0, width,height);

	}

	@Override
	public void draw(Canvas canvas) {

		drawable.draw(canvas);

	}

}
