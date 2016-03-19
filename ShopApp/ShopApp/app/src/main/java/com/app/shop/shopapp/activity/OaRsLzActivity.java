package com.app.shop.shopapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.shop.shopapp.R;

/**
 * 人事离职
 */
public class OaRsLzActivity extends Activity implements View.OnClickListener {

    private LinearLayout layRsda;
    private LinearLayout layTxl;
    private ImageView ivRsda;
    private ImageView ivTxl;
    private TextView tvOaRslc;//人事流程
    private TextView tvOaRslz;//人事离职
    private TextView tvOaRsct;//辞退

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oa_rs_lz);
        initUI();
    }

    /**
     * UI加载
     */
    private void initUI() {

        ((TextView)findViewById(R.id.tv_baoxiao_title)).setText(getString(R.string.str_oa_rs_rslc));
        findViewById(R.id.tv_oa_rs_lzsq).setOnClickListener(this);
        findViewById(R.id.tv_oa_rs_lzcx).setOnClickListener(this);
        findViewById(R.id.iv_pro_baoxiao_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_oa_rs_lzsq:
//                Intent inte = new Intent();
//                startActivity(inte);
                break;
            case R.id.tv_oa_rs_lzcx:
                break;
            case R.id.iv_pro_baoxiao_back:
                finish();
                break;

        }
    }
}
