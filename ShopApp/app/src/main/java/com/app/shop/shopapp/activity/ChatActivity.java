package com.app.shop.shopapp.activity;

import android.content.Intent;
import android.view.View;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;
import com.hyphenate.easeui.ui.EaseChatFragment;

/**
 * <聊天界面>
 *
 * @author lwli
 * @data: 2016/3/12 17:02
 * @version: V1.0
 */
public class ChatActivity extends BaseActivity {
    private EaseChatFragment chatFragment;
    String toChatUsername="123";
    @Override
    protected int bindLayout() {
        return R.layout.activity_chat;
    }

    @Override
    public void initView() {
        super.initView();
        //聊天人或群id
//        toChatUsername = getIntent().getExtras().getString("userId");
        //可以直接new EaseChatFratFragment使用
        chatFragment = new EaseChatFragment();
        //传入参数
        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.container, chatFragment).commit();
    }
    @Override
    protected void onNewIntent(Intent intent) {
        // 点击notification bar进入聊天页面，保证只有一个聊天页面
        String username = intent.getStringExtra("userId");
        if (toChatUsername.equals(username))
            super.onNewIntent(intent);
        else {
            finish();
            startActivity(intent);
        }

    }
    @Override
    public void onBackPressed() {
        chatFragment.onBackPressed();
    }

    public String getToChatUsername(){
        return toChatUsername;
    }
    @Override
    public void onClick(View v) {

    }
}
