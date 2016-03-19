package com.app.shop.shopapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.shop.shopapp.R;

/**
 * 人事管理
 */
public class OaRenShiActivity extends Activity implements View.OnClickListener {

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
        setContentView(R.layout.oa_ren_shi);
        initUI();
    }

    /**
     * UI加载
     */
    private void initUI() {
        layRsda = (LinearLayout) findViewById(R.id.oa_rs_rsda);
        layTxl = (LinearLayout) findViewById(R.id.oa_rs_txl);
        ivRsda = (ImageView) findViewById(R.id.iv_oa_rs_rsda);
        ivTxl = (ImageView) findViewById(R.id.iv_oa_rs_txl);

        findViewById(R.id.btn_oa_rs_rsda).setOnClickListener(this);
        findViewById(R.id.btn_oa_rs_txl).setOnClickListener(this);
        findViewById(R.id.tv_oa_rs_lc).setOnClickListener(this);
        findViewById(R.id.tv_oa_rs_lz).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_oa_rs_lc:
                gotoLz(1);
                break;
            case R.id.tv_oa_rs_lz:
                gotoLz(2);
                break;
            case R.id.tv_oa_rs_ct:
                gotoLz(2);
                break;


            case R.id.btn_oa_rs_rsda:
                layRsda.setVisibility(View.VISIBLE);
                layTxl.setVisibility(View.GONE);
                ivRsda.setVisibility(View.VISIBLE);
                ivTxl.setVisibility(View.INVISIBLE);
                break;
            case R.id.btn_oa_rs_txl:
                layRsda.setVisibility(View.GONE);
                layTxl.setVisibility(View.VISIBLE);
                ivRsda.setVisibility(View.INVISIBLE);
                ivTxl.setVisibility(View.VISIBLE);
                break;

        }
    }

    private void gotoLz(int type) {
        Intent inte = new Intent();
        switch (type){
            case 1:
                //人事流程
                inte.setClass(this, OaRsLcActivity.class);
                break;
            case 2:
                //离职
                inte.setClass(this,OaRsLzActivity.class);
                break;
        }
        startActivity(inte);
    }
}
