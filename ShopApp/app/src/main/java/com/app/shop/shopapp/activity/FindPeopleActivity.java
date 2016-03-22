package com.app.shop.shopapp.activity;

import android.content.Context;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;
import com.app.shop.shopapp.dialog.AddDialog;
import com.app.shop.shopapp.model.NeighborItem;
import com.app.shop.shopapp.utils.ToastUtil;

import java.util.List;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/11 18:55
 * @version: V1.0
 */
public class FindPeopleActivity extends BaseActivity {
    private ListView lv_data;
    private SearchView search_view;
    List<NeighborItem>datas;
    @Override
    protected int bindLayout() {
        return R.layout.activity_find_people;
    }

    @Override
    public void initView() {
        super.initView();
        setTitle("找邻居");
        lv_data=findViewByIdU(R.id.lv_data);
        search_view=findViewByIdU(R.id.search_view);
        findViewByIdU(R.id.tv_title).setOnClickListener(this);
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
    public void onClick(View v) {

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
            holder.iv_chat.setOnClickListener(mCKListener);
            holder.iv_add_people.setOnClickListener(mCKListener);
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
                        new AddDialog(FindPeopleActivity.this)
                                .setCallBack(new AddDialog.ICallBack() {
                                    @Override
                                    public void onClickOk() {
                                        ToastUtil.showToast("添加成功");
                                    }
                                })
                                .setInfo("李").show();
                        break;
                    default:
                        break;
                }

            }
        };
    }
}
