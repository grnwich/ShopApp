package com.app.shop.shopapp.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;
import com.app.shop.shopapp.fragment.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/11 14:01
 * @version: V1.0
 */
public class ComplaintAdviceActivity extends BaseActivity {
    private List<Item>datas=new ArrayList<>();
    private ListView lv_data;
    @Override
    protected int bindLayout() {
        return R.layout.activity_complaint_advice;
    }

    @Override
    public void initView() {
        super.initView();
        lv_data=findViewByIdU(R.id.lv_data);
    }

    @Override
    public void initData() {
        super.initData();
        setTitle("投诉建议");
        datas.add(new Item(R.mipmap.ic_cleaner_leader, "保洁主管"));
        datas.add(new Item(R.mipmap.ic_project_leader, "工程主管"));
        datas.add(new Item(R.mipmap.ic_safe_leader, "安全主管"));
        datas.add(new Item(R.mipmap.ic_service_leader, "客服主管"));
        datas.add(new Item(R.mipmap.ic_other_leader,"其它"));
        lv_data.setAdapter(new MyAdapter(this));

    }

    @Override
    public void setListener() {
        super.setListener();
        lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
    class MyAdapter extends ArrayAdapter<Item> {

        LayoutInflater mInflater = null;

        public MyAdapter(Context context) {
            super(context, 0);
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Item getItem(int position) {
            return datas.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Item item=getItem(position);
            Holder holder=null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_complaint_advice, null);
                holder=new Holder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            holder.tv_name.setText(item.getName());
            holder.iv_icon.setImageResource(item.getRes());
            return convertView;
        }
        class Holder{
            TextView tv_name = null;
            ImageView iv_icon = null;
            public Holder(View v){
                tv_name= (TextView) v.findViewById(R.id.tv_name);
                iv_icon= (ImageView) v.findViewById(R.id.iv_icon);

            }
        }
    }
}
