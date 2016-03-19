package com.app.shop.shopapp.activity;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.base.activity.BaseActivity;
import com.app.shop.shopapp.utils.ToastUtil;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/3/11 16:31
 * @version: V1.0
 */
public class CommentActivity extends BaseActivity {
    private EditText et_input;
    private TextView tv_count;
    @Override
    protected int bindLayout() {
        return R.layout.activity_comment;
    }

    @Override
    public void initView() {
        super.initView();
        setTitle("评论");
        et_input=findViewByIdU(R.id.et_input);
        tv_count=findViewByIdU(R.id.tv_count);
        TextView tv_right=findViewByIdU(R.id.tv_right);
        tv_right.setText("发表");
        tv_right.setVisibility(View.VISIBLE);
        tv_right.setOnClickListener(this);
    }

    @Override
    public void setListener() {
        super.setListener();
        et_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!TextUtils.isEmpty(s)){
                    tv_count.setText("您已输入"+s.toString().length()+"个字");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        ToastUtil.showToast("发表成功");
        finish(true);
    }
}
