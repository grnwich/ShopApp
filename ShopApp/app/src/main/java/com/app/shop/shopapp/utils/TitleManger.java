package com.app.shop.shopapp.utils;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.shop.shopapp.R;

/**
 * Created by Administrator on 2016/3/11.
 */
public class TitleManger {

    private static ImageView left_arraw;
    private static ImageView top_layout_right_iv;
    private static TextView  top_layout_right_tv;
    private static TextView  top_layout_title;

    public static void show(final Activity context,String title,boolean rightText,boolean rightImgview){

      left_arraw = (ImageView) context.findViewById(R.id.left_arraw);
        top_layout_title = (TextView) context.findViewById(R.id.top_layout_title);
        top_layout_right_tv = (TextView) context.findViewById(R.id.top_layout_right_tv);
         top_layout_right_iv = (ImageView) context.findViewById(R.id.top_layout_right_iv);


        left_arraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.finish();

            }
        });


        top_layout_title.setText(title);

        if(rightText)
        {
            top_layout_right_tv.setVisibility(View.VISIBLE);
        }else
        {
            top_layout_right_tv.setVisibility(View.INVISIBLE);
        }

        if (rightImgview)
        {
            top_layout_right_iv.setVisibility(View.VISIBLE);
        }else {
            top_layout_right_iv.setVisibility(View.INVISIBLE);
        }
    }



}
