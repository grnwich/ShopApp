package com.app.shop.shopapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.activity.DelayActivity;
import com.app.shop.shopapp.activity.MyAccountActivity;
import com.app.shop.shopapp.activity.MyComplaintActivity;
import com.app.shop.shopapp.activity.MyMaintainActivity;
import com.app.shop.shopapp.activity.MyPasswordActivity;
import com.app.shop.shopapp.activity.MyPropertyFeeActivity;


/**
 * Created with IntelliJ IDEA.
 * Author: wangjie  email:wangjie@cyyun.com
 * Date: 13-6-14
 * Time: 下午2:39
 */
public class TabPersonFm extends Fragment implements View.OnClickListener {
    private View view;

    private ImageView iv_person_tccs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        return view = inflater.inflate(R.layout.tab_person, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    private void initView() {

        iv_person_tccs = (ImageView) view.findViewById(R.id.iv_person_tccs);
        iv_person_tccs.setOnClickListener(this);
        LinearLayout ll_person_zh = (LinearLayout) view.findViewById(R.id.ll_person_zh);
        ll_person_zh.setOnClickListener(this);
        LinearLayout ll_person_bx = (LinearLayout) view.findViewById(R.id.ll_person_bx);
        ll_person_bx.setOnClickListener(this);
        LinearLayout ll_person_mm = (LinearLayout) view.findViewById(R.id.ll_person_mm);
        ll_person_mm.setOnClickListener(this);
        LinearLayout ll_person_ts = (LinearLayout) view.findViewById(R.id.ll_person_ts);
        ll_person_ts.setOnClickListener(this);
        LinearLayout ll_person_wyf = (LinearLayout) view.findViewById(R.id.ll_person_wyf);
        ll_person_wyf.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.iv_person_tccs:
                intent = new Intent(getActivity(), DelayActivity.class);
                startActivity(intent);
                break;

            case R.id.ll_person_zh:
                intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_person_bx:
                intent = new Intent(getActivity(), MyMaintainActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_person_mm:
                intent = new Intent(getActivity(), MyPasswordActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_person_ts:
                intent = new Intent(getActivity(), MyComplaintActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_person_wyf:
                intent = new Intent(getActivity(), MyPropertyFeeActivity.class);
                startActivity(intent);
                break;

        }


    }
}
