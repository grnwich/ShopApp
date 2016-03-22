package com.app.shop.shopapp.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.app.shop.shopapp.R;

public class OaRsLcActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oa_rs_lc);
        findViewById(R.id.iv_pro_baoxiao_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ((TextView)findViewById(R.id.tv_baoxiao_title)).setText(getString(R.string.str_oa_rs_rslc));
    }
}
