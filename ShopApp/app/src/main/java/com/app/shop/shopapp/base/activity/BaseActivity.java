package com.app.shop.shopapp.base.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.shop.shopapp.R;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2015/9/9 16:29
 * @version: V1.0
 */
public abstract class BaseActivity extends FragmentActivity implements View.OnClickListener {
    /**
     * 登入请求码
     */
    public static final int LOGIN_REQUEST_CODE = 333;
    public static final String GLOBAL_ITEM = "global_item";
    protected LayoutInflater mInflater;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        init();
    }

    /**
     * 界面布局
     *
     * @return
     */
    protected abstract int bindLayout();

    /**
     * @return
     */
    protected int bindTitleLayout() {
        return 0;
    }

    public void init() {
        mInflater = LayoutInflater.from(this);
        initView();
        initData();
        setListener();
    }

    protected View inflateView(int resId) {
        return mInflater.inflate(resId, null);
    }

    public void initView() {
        ImageView iv_back=findViewByIdU(R.id.iv_back);
        if(iv_back!=null){
            iv_back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(true);
                }
            });
        }

    }

    ;

    public void setTitle(int res) {
        TextView tvTitle = findViewByIdU(R.id.tv_title);
        if (tvTitle != null) tvTitle.setText(res);
    }

    protected void setTitle(String str) {
        TextView tvTitle = findViewByIdU(R.id.tv_title);
        if (tvTitle != null) tvTitle.setText(str);
    }

    protected boolean isLogin(boolean start) {
            return false;
    }

    protected boolean isLogin(int requestCode) {
            return true;
    }

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT findViewByIdU(@IdRes int id) {
        return (VT) findViewById(id);
    }

    public void initData() {
    }

    ;

    public void setListener() {
        View v = findViewByIdU(R.id.iv_back);
        if (v != null) {
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish(true);
                }
            });
        }
    }

    ;

    public void finish(boolean animation) {
        finish();
    }

    public void startActivity(Intent intent, boolean isFinish) {
        startActivity(intent);
        if (isFinish)
            finish();
    }

    public void startActivityForResult(Intent intent, int reqCode, boolean isFinish) {
        super.startActivityForResult(intent, reqCode);
        if (isFinish)
            finish();
    }


    private long click;

    @Override
    public void startActivity(Intent intent) {
        if (System.currentTimeMillis() - click < 1000) {
            return;
        }
        click = System.currentTimeMillis();
        super.startActivity(intent);
    }
}
