package com.app.shop.shopapp.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;
import com.app.shop.shopapp.model.TelInfo;
import com.app.shop.shopapp.utils.Constant;
import com.app.shop.shopapp.utils.ToastUtil;
import com.app.shop.shopapp.view.SegmentControl;
import com.jiongbull.jlog.JLog;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import java.util.ArrayList;
import java.util.List;

public class ProBxActivity extends BaseActivity {

    private SegmentControl segment_control;
    private ViewPager vp_pager;
    private ListView lv_pro_dh;
    private List<TelInfo.DataEntity>dataEntities;
    @Override
    protected int bindLayout() {
        return R.layout.activity_segement;
    }

    @Override
    public void initView() {
        super.initView();
        vp_pager=findViewByIdU(R.id.vp_pager);
        segment_control=findViewByIdU(R.id.segment_control);
        segment_control.setText("报修类型","应急电话");
        segment_control.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                vp_pager.setCurrentItem(index);
            }
        });
        vp_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                segment_control.setSelectedIndex(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    private void loadPhoneData(){
        dataEntities=new ArrayList<>();
        FinalHttp fh=new FinalHttp();
        JLog.d(Constant.HOST_URL + "maintain/phoneList");
        fh.get(Constant.HOST_URL + "maintain/phoneList", new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                super.onSuccess(o);
                TelInfo telInfo=TelInfo.parse(o);
                if(telInfo.getData()!=null){
                    dataEntities.addAll(telInfo.getData());
                    ((MyAdapter)lv_pro_dh.getAdapter()).notifyDataSetChanged();

                }
                JLog.json(o);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                ToastUtil.showToast("加载失败");
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
        dataEntities=new ArrayList<>();
        List<View> viewLists=new ArrayList<>();
        LayoutInflater inflater=LayoutInflater.from(this);
        View v1=inflater.inflate(R.layout.pro_bx_lx, null);
        View v2=inflater.inflate(R.layout.pro_bx_dh, null);
        vp_pager.setPageMargin(15);

        viewLists.add(v1);
        viewLists.add(v2);
        lv_pro_dh= (ListView) v2.findViewById(R.id.lv_pro_dh);
        vp_pager.setAdapter(new MyPagerAdapter(viewLists));
        lv_pro_dh.setAdapter(new MyAdapter(this));
        loadPhoneData();
    }

    @Override
    public void setListener() {
        super.setListener();
        lv_pro_dh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(dataEntities!=null&& dataEntities.get(position)!=null){
                    TelInfo.DataEntity dataEntity=  dataEntities.get(position);
                    if(!TextUtils.isEmpty(dataEntity.getPhone())){
                        Intent phoneIntent = new Intent(
                                "android.intent.action.CALL", Uri.parse("tel:"
                                + dataEntity.getPhone()));
                        startActivity(phoneIntent);
                    }
                }

            }
        });

    }

    class MyPagerAdapter extends PagerAdapter{
        List<View> viewLists;
        public MyPagerAdapter(List<View> viewLists){
            this.viewLists=viewLists;
        }
        @Override
        public int getCount() {
            return viewLists.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(viewLists.get(position), 0);
            return viewLists.get(position);
        }

    }
    @Override
    public void onClick(View v) {

    }


    class MyAdapter extends ArrayAdapter<TelInfo.DataEntity> {

        LayoutInflater mInflater = null;

        public MyAdapter(Context context) {
            super(context, 0);
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return dataEntities.size();
        }
        @Override
        public TelInfo.DataEntity getItem(int position) {
            return dataEntities.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TelInfo.DataEntity dataEntity=getItem(position);
            Holder holder=null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.pro_bx_dh_item, null);
                holder=new Holder(convertView);
                convertView.setTag(holder);
            }
            holder= (Holder) convertView.getTag();
            holder.txt.setText(dataEntity.getTitle());

            return convertView;
        }
        class Holder{
            TextView txt;
            public Holder(View v){
                txt= (TextView) v.findViewById(R.id.tv_pro_dh_des);
            }
        }
    }
}
