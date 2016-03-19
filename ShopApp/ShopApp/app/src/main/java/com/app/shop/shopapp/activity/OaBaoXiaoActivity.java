package com.app.shop.shopapp.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.shop.shopapp.R;

/**
 * Oa报销
 */
public class OaBaoXiaoActivity extends Activity {


    private LinearLayout layoutOrders;
    private LinearLayout layoutSplc;
    private ImageView ivOrder;
    private ImageView ivSplc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oa_bao_xiao);
        initUI();
    }

    /**
     * UI加载
     */
    private void initUI() {
        layoutOrders = (LinearLayout) findViewById(R.id.oa_bx_type_layout);
        layoutSplc = (LinearLayout) findViewById(R.id.oa_pur_splc_layout);
        ivOrder = (ImageView) findViewById(R.id.iv_oa_baoxiao_order);
        ivSplc = (ImageView) findViewById(R.id.iv_oa_bx_splc);

        findViewById(R.id.btn_oa_baoxiao_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutOrders.setVisibility(View.VISIBLE);
                layoutSplc.setVisibility(View.GONE);
                ivOrder.setVisibility(View.VISIBLE);
                ivSplc.setVisibility(View.INVISIBLE);
            }
        });
        findViewById(R.id.btn_oa_bx_splc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutOrders.setVisibility(View.GONE);
                layoutSplc.setVisibility(View.VISIBLE);
                ivOrder.setVisibility(View.INVISIBLE);
                ivSplc.setVisibility(View.VISIBLE);
            }
        });
    }
}
