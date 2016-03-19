package com.app.shop.shopapp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;
import com.app.shop.shopapp.html.CImageGetter;
import com.app.shop.shopapp.html.CTagHandler;
import com.app.shop.shopapp.model.NeighborItem;
import com.app.shop.shopapp.model.ReportItem;
import com.app.shop.shopapp.model.RportInfo;
import com.app.shop.shopapp.utils.Constant;
import com.app.shop.shopapp.utils.ToastUtil;
import com.app.shop.shopapp.view.SegmentControl;
import com.jiongbull.jlog.JLog;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/11 17:24
 * @version: V1.0
 */
public class HoseReportActivity extends BaseActivity {
    private SegmentControl segment_control;
    private ViewPager vp_pager;
    private TextView tv_add;
    List<NeighborItem>datas;
    List<ReportItem>reportDatas;
    private ListView lv_data;
    private ListView lv_data_report;
    @Override
    protected int bindLayout() {
        return R.layout.activity_segement;
    }

    @Override
    public void initView() {
        super.initView();
        setTitle("小区公告");
        vp_pager=findViewByIdU(R.id.vp_pager);
        tv_add=findViewByIdU(R.id.tv_add);
        tv_add.setText("添加");
        segment_control=findViewByIdU(R.id.segment_control);
        segment_control.setText("通知","闲聊");
    }

    @Override
    public void initData() {
        super.initData();
        datas=new ArrayList<>();
        reportDatas=new ArrayList<>();
        datas.add(new NeighborItem());
        datas.add(new NeighborItem());
        datas.add(new NeighborItem());
        datas.add(new NeighborItem());
        datas.add(new NeighborItem());
        datas.add(new NeighborItem());

        List<View> viewLists=new ArrayList<>();
        LayoutInflater inflater=LayoutInflater.from(this);
        View v1=inflater.inflate(R.layout.layout_report_repair, null);
        View v2=inflater.inflate(R.layout.layout_people_contact, null);
        lv_data= (ListView) v2.findViewById(R.id.lv_data);
        lv_data_report= (ListView) v1.findViewById(R.id.lv_data_report);
        lv_data.setAdapter(new Adapter(this));
        lv_data_report.setAdapter(new ReportAdapter(this));
        viewLists.add(v1);
        viewLists.add(v2);
        vp_pager.setAdapter(new MyPagerAdapter(viewLists));
        loadReportData();
    }
    private void loadReportData(){
        FinalHttp fh=new FinalHttp();
        fh.get(Constant.HOST_URL + "community/notice?community_id=1", new AjaxCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                super.onSuccess(o);
                JLog.json(o);
                RportInfo rportInfo=RportInfo.parse(o);
                reportDatas.addAll(rportInfo.getData());
                ((ReportAdapter)lv_data_report.getAdapter()).notifyDataSetChanged();
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                ToastUtil.showToast("加载失败");
            }
        });
    }

    @Override
    public void setListener() {
        super.setListener();
        tv_add.setOnClickListener(this);
        segment_control=findViewByIdU(R.id.segment_control);
        segment_control.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                if(index==0){
                    tv_add.setVisibility(View.GONE);
                }else{
                    tv_add.setVisibility(View.VISIBLE);
                }
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
    class ReportAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private CImageGetter imageGetter;
        private Html.TagHandler tagHandler;
        private Context context;
        public ReportAdapter(Context context){
            inflater=LayoutInflater.from(context);
            this.context=context;
            tagHandler=new CTagHandler(context);
        }
        @Override
        public int getCount() {
            return reportDatas.size();
        }

        @Override
        public ReportItem getItem(int position) {
            return reportDatas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder=null;
            ReportItem reportItem=reportDatas.get(position);
            if(convertView==null){
                convertView=inflater.inflate(R.layout.item_report,null);
                holder=new Holder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            imageGetter=new CImageGetter(context, holder.tv_content);
            holder.tv_content.setText(Html.fromHtml(reportItem.getContent().toString(), imageGetter, tagHandler));
            return convertView;
        }
        class Holder{
            TextView tv_content;
            public Holder(View v){
                tv_content= (TextView) v.findViewById(R.id.tv_content);
            }
        }
        private View.OnClickListener mCKListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.iv_chat:
                        break;
                    case R.id.iv_add_people:

                        break;
                    default:
                        break;
                }

            }
        };
    }
    class Adapter extends BaseAdapter {
        private LayoutInflater inflater;
        public Adapter(Context context){
            inflater=LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public NeighborItem getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder holder=null;
            if(convertView==null){
                convertView=inflater.inflate(R.layout.item_people,null);
                holder=new Holder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            holder.iv_chat.setVisibility(View.GONE);
            holder.iv_add_people.setVisibility(View.GONE);
            return convertView;
        }
        class Holder{
            ImageView iv_chat;
            ImageView iv_add_people;
            public Holder(View v){
                iv_chat= (ImageView) v.findViewById(R.id.iv_chat);
                iv_add_people= (ImageView) v.findViewById(R.id.iv_add_people);
            }

        }
        private View.OnClickListener mCKListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.iv_chat:
                        break;
                    case R.id.iv_add_people:

                        break;
                    default:
                        break;
                }

            }
        };
    }
    class MyPagerAdapter extends PagerAdapter {
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
        switch (v.getId()){
            case R.id.tv_add:
                startActivity(new Intent(this,FindPeopleActivity.class));
                break;
            default:
                break;
        }

    }
}
