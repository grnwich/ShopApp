package com.app.shop.shopapp.fragment;

import android.content.Intent;
import android.view.View;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.activity.ComplaintAdviceActivity;
import com.app.shop.shopapp.activity.FeeInfoActivity;
import com.app.shop.shopapp.activity.HoseReportActivity;
import com.app.shop.shopapp.activity.PeopleContactActivity;
import com.app.shop.shopapp.activity.ProBxActivity;
import com.app.shop.shopapp.base.activity.fragment.BaseFragment;

/**
 * Created with IntelliJ IDEA.
 * Author: wangjie  email:wangjie@cyyun.com
 * Date: 13-6-14
 * Time: 下午2:39
 */
public class TabProFm extends BaseFragment{
    private static final int ID=100;
    @Override
    protected int bindLayout() {
        return R.layout.tab_pro;
    }

    @Override
    public void initView() {
        super.initView();
        findViewById(R.id.iv_pm_repair).setOnClickListener(this);//
        findViewById(R.id.iv_pm_ca).setOnClickListener(this);
        findViewById(R.id.iv_pm_pay).setOnClickListener(this);
        findViewById(R.id.iv_pm_report).setOnClickListener(this);
        findViewById(R.id.iv_pm_contact).setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void setListener() {
        super.setListener();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_pm_repair:
                startActivity(new Intent(getActivity(), ProBxActivity.class));
                break;
            case R.id.iv_pm_pay:
                startActivity(new Intent(getActivity(), FeeInfoActivity.class));
                break;
            case R.id.iv_pm_ca:
                startActivity(new Intent(getActivity(), ComplaintAdviceActivity.class));
                break;
            case R.id.iv_pm_report:
                startActivity(new Intent(getActivity(), HoseReportActivity.class));
                break;
            case R.id.iv_pm_contact:
                startActivity(new Intent(getActivity(), PeopleContactActivity.class));
                break;
            default:
                break;
        }
    }
}
