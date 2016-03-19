package com.app.shop.shopapp.base.activity.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2015/9/9 16:06
 * @version: V1.0
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected View view;
    protected LayoutInflater inflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(bindLayout()!=0){
            view = inflater.inflate(bindLayout(), container, false);
            init();
            return view;
        } else{
            return null;
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        inflater= LayoutInflater.from(activity);
    }

    /**界面布局
     * @return
     */
    protected abstract int bindLayout();

    /**
     * @return
     */
    protected int bindTitleLayout(){return 0;}    /**

    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT findViewById(@IdRes int id) {
        return (VT) view.findViewById(id);
    }
    public void init() {
        initView();
        initData();
        setListener();
    }

    public void finish(boolean animation) {
        getActivity().finish();
    }

    public void startActivity(Intent intent, boolean isFinish) {
        super.startActivity(intent);
        if (isFinish)
            getActivity().finish();
    }

    public void startActivityForResult(Intent intent, int reqCode,
                                       boolean isFinish) {
        super.startActivityForResult(intent, reqCode);
        if (isFinish)
            getActivity().finish();
    }
    protected boolean isLogin(int requestCode){
        return true;
    }
    public void initView() {
    };

    public void initData() {
    };

    public void setListener() {
    };
    protected boolean isLogin(boolean start){
        return true;
    }

    
}
