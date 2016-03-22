package com.app.shop.shopapp.activity;

import android.view.View;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/12 9:16
 * @version: V1.0
 */
public class PayFeeActivity extends BaseActivity {
    private int pay_type;
    private TextView tv_submit_order;
    private TextView tv_address_right;
    private TextView tv_pay_right;
    private TextView tv_pay_address_info;
    private TextView tv_pay_info;
    private View llyt_pay_info;
    private View llyt_parking_info;
    private TextView tv_pay_type;


    @Override
    protected int bindLayout() {
        return R.layout.activity_pay_fee;
    }

    @Override
    public void initView() {
        super.initView();
        pay_type=getIntent().getIntExtra(FeeInfoActivity.PAY_FEE_TYPE, 0);
        tv_submit_order=findViewByIdU(R.id.tv_submit_order);
        tv_address_right=findViewByIdU(R.id.tv_address_right);
        tv_pay_right=findViewByIdU(R.id.tv_pay_right);
        tv_pay_address_info=findViewByIdU(R.id.tv_pay_address_info);
        tv_pay_info=findViewByIdU(R.id.tv_pay_info);
        llyt_pay_info=findViewByIdU(R.id.llyt_pay_info);
        llyt_parking_info=findViewByIdU(R.id.llyt_parking_info);
        tv_pay_type=findViewByIdU(R.id.tv_pay_type);

        StringBuffer buffer=new StringBuffer();
        StringBuffer buffer2=new StringBuffer();
        switch (pay_type){
            case FeeInfoActivity.PAY_GUARANTEE:
                setTitle("装修押金");
                tv_submit_order.setText("立即缴费");
                buffer.append("小区:XX小区\n")
                        .append("房间号:")
                        .append("XX期XX栋XXX")
                        .append("\n")
                        .append("户主:XXXX");
                tv_pay_address_info.setText(buffer);
                buffer2.append("待缴费月数:XX个月")
                        .append("\n")
                        .append("待缴费金额:XX元");
                tv_pay_info.setText(buffer2);
                tv_address_right.setVisibility(View.GONE);
                tv_pay_right.setVisibility(View.GONE);
                tv_submit_order.setVisibility(View.VISIBLE);
                tv_submit_order.setText("立即缴费");
                break;
            case FeeInfoActivity.PAY_PARKING:
                setTitle("停车费");
                llyt_pay_info.setVisibility(View.GONE);
                tv_submit_order.setVisibility(View.VISIBLE);
                llyt_parking_info.setVisibility(View.VISIBLE);
                tv_submit_order.setText("提交订单");
                buffer.append("小区:XX小区\n")
                        .append("房间号:")
                        .append("XX期XX栋XXX")
                        .append("\n")
                        .append("户主:XXXX");
                tv_pay_address_info.setText(buffer);
                break;
            case FeeInfoActivity.PAY_PM:
                setTitle("物业费");
                tv_pay_type.setText("待缴费信息");
                buffer.append("小区:XX小区\n")
                .append("房间号:")
                .append("XX期XX栋XXX")
                .append("\n")
                .append("户主:XXXX");
                tv_pay_address_info.setText(buffer);
                buffer2.append("待缴费月数:XX个月")
                        .append("\n")
                .append("待缴费金额:XX元");
                tv_pay_info.setText(buffer2);
                break;
            default:
                break;
        }

    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void setListener() {
        super.setListener();
        tv_submit_order.setOnClickListener(this);
        tv_pay_right.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_pay_right:
                break;
            case R.id.tv_submit_order:
                break;
            default:
                break;
        }

    }
}
