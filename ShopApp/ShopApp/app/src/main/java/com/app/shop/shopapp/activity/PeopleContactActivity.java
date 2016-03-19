package com.app.shop.shopapp.activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;
import com.app.shop.shopapp.model.PeopleContactModel;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.domain.EaseUser;

import java.util.ArrayList;
import java.util.List;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/11 12:29
 * @version: V1.0
 */
public class PeopleContactActivity extends BaseActivity {
    private ListView lv_data;
    private List<PeopleContactModel>datas;
    @Override
    protected int bindLayout() {
        return R.layout.activity_people_contact;
    }

    @Override
    public void initView() {
        super.initView();
        setTitle("邻里互动");
        lv_data=findViewByIdU(R.id.lv_data);
        TextView tv_right=findViewByIdU(R.id.tv_right);
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setText("发贴");
        tv_right.setOnClickListener(this);
    }

    @Override
    public void initData() {
        super.initData();
        datas=new ArrayList<PeopleContactModel>();
        datas.add(new PeopleContactModel());
        datas.add(new PeopleContactModel());
        datas.add(new PeopleContactModel());
        datas.add(new PeopleContactModel());
        datas.add(new PeopleContactModel());
        lv_data.setAdapter(new Adapter(this));
    }

    @Override
    public void setListener() {
        super.setListener();
        lv_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                EaseUser easeUser=new EaseUser("123");
//                startActivity(new Intent(PeopleContactActivity.this, ChatActivity.class).putExtra(EaseConstant.EXTRA_USER_ID, easeUser.getUsername()));
            }
        });
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,SendPostActivity.class));

    }
    class Adapter extends BaseAdapter{
        private LayoutInflater inflater;
        public Adapter(Context context){
            inflater=LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public PeopleContactModel getItem(int position) {
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
                convertView=inflater.inflate(R.layout.item_people_contact,null);
                holder=new Holder(convertView);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            holder.iv_comment.setOnClickListener(mCKListener);
            holder.iv_favor.setOnClickListener(mCKListener);
            return convertView;
        }
        class Holder{
            ImageView iv_comment;
            ImageView iv_favor;
            public Holder(View v){
                iv_comment= (ImageView) v.findViewById(R.id.iv_comment);
                iv_favor= (ImageView) v.findViewById(R.id.iv_favor);
            }

        }
        private View.OnClickListener mCKListener=new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.iv_favor:
                        break;
                    case R.id.iv_comment:
                        startActivity(new Intent(PeopleContactActivity.this,CommentActivity.class));
                        break;
                    default:
                        break;
                }

            }
        };
    }
}
