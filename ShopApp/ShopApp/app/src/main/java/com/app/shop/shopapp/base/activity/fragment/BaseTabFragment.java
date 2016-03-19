package com.app.shop.shopapp.base.activity.fragment;

import android.os.Bundle;

import com.app.shop.shopapp.model.FragmentTabItem;


/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2015/9/12 16:18
 * @version: V1.0
 */
public abstract class BaseTabFragment extends BaseFragment {
    protected FragmentTabItem tabItem;
    public static final String BUNDLE_KEY_CATALOG = "tab_top";
    private TabChangedListener mListener;

    public static interface TabChangedListener {
        /**
         * @param fragment
         * @return
         */
        public abstract boolean isCurrent(BaseTabFragment fragment);
    }

    public BaseTabFragment() {
    }

    /**更新item
     * @param position
     * @param obj
     */
    public void updateItem(int position,Object obj){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            tabItem = (FragmentTabItem) bundle.getSerializable(BaseTabFragment.BUNDLE_KEY_CATALOG);
        }
    }
    public void setIArguments(Bundle bundle) {

    }

    public final void addTabChangeListener(TabChangedListener listener) {
        mListener = listener;
    }

    public void tabFragmentRefresh() {
    }

    public void g() {
    }

    public void location(boolean isSuccess) {

    }

    public void h(String message) {
    }

    public void doBusiness() {

    }
    public int d(){
        return 0;
    }
}
