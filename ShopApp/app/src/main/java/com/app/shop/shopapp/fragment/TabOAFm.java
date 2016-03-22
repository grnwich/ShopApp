package com.app.shop.shopapp.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.activity.MainActivity;
import com.app.shop.shopapp.activity.OaBaoXiaoActivity;
import com.app.shop.shopapp.activity.OaPurchaseActivity;
import com.app.shop.shopapp.activity.OaRenShiActivity;
import com.app.shop.shopapp.activity.ProBxActivity;

/**
 * Created with IntelliJ IDEA.
 * Author:
 * Date: 13-6-14
 * Time: 下午2:39
 */
public class TabOAFm extends Fragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_oa, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().findViewById(R.id.iv_oa_stock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                // 获得TabAFm的控件
                Intent inte = new Intent(activity, OaPurchaseActivity.class);
                startActivity(inte);
            }
        });
        getView().findViewById(R.id.iv_oa_reimburse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                // 获得TabAFm的控件
                Intent inte = new Intent(activity, OaBaoXiaoActivity.class);
                startActivity(inte);
            }
        });
        getView().findViewById(R.id.iv_oa_person).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity activity = getActivity();
                // 获得TabAFm的控件
                Intent inte = new Intent(activity, OaRenShiActivity.class);
                startActivity(inte);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
