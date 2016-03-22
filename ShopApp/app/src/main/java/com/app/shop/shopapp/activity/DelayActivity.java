package com.app.shop.shopapp.activity;

import android.app.Activity;
import android.os.Bundle;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.utils.TitleManger;

/**
 * Created by Administrator on 2016/3/11.
 */
public class DelayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.delay_activity);
        TitleManger.show(this, "迟交次数", false, false);

        initView();
    }

    private void initView() {


    }
}
