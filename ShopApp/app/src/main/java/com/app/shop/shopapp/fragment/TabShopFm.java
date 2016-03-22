package com.app.shop.shopapp.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.app.shop.shopapp.R;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * Author: wangjie  email:tiantian.china.2@gmail.com
 * Date: 13-6-14
 * Time: 下午2:39
 */
public class TabShopFm extends Fragment{


    private Activity thiz;
    private ViewPager mViewPager;
    private ImageView iv;
    private LinearLayout layoutPGroup;
    private ArrayList<ImageView> imageViewlist;

    // 线程开关，当activity销毁后，线程也应该停止运行
    private boolean isStop = false;
    private int previousPoint = 0;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thiz = this.getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tab_shop, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        initBanner();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isStop = true;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }




    private void initBanner() {
        mViewPager = (ViewPager) thiz.findViewById(R.id.viewpager);
        layoutPGroup = (LinearLayout) thiz.findViewById(R.id.show_pointer);
        imageViewlist = new ArrayList<ImageView>();

        // 先拿到图片id
        int[] ivIDs = new int[] { R.mipmap.banner_a, R.mipmap.banner_a, R.mipmap.banner_a,
                R.mipmap.banner_a, R.mipmap.banner_a };
        // 遍历图片id
        for (int id : ivIDs) {
            // 构造新的图片对象，并根据id给图片设置背景
            iv = new ImageView(thiz);
            iv.setBackgroundResource(id);
            // 所有的图片存放在imageViewlist中
            imageViewlist.add(iv);

            // 构造小点
            View v = new View(thiz);
            // 设置小点的宽和高
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(10, 10);
            // 设置小点的左边距
            params.leftMargin = 12;
            v.setLayoutParams(params);
            // 设置小点是否可用，默认都不可用，当不可用时，小点是透明的，否则是白色的
            v.setEnabled(false);
            // 设置小点的背景，这个背景是使用xml文件画的一个小圆点
            v.setBackgroundResource(R.drawable.pointer_selector);
            // 把小点添加到它的布局文件中
            layoutPGroup.addView(v);
        }
        // 计算应用打开时显示的第一项 Integer.MAX_VALUE /2 - 3=0
        int index = Integer.MAX_VALUE / 2 - 3;
        // 给mViewPager设置数据
        mViewPager.setAdapter(new MyPagerAdapter());
        // 给mViewPager设置页面滑动事件
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

        // 设置应用打开时显示的第一项，index的值为0
        // 使用这种方式得到的0，和直接写0有什么区别呢？
        // 直接写0，应用打开后不能直接向右滑动，因为viewpager中存image位置不能为负值，只能先向左滑动
        // 这种方式得到的0，可以实现应用一打开，就可以向右滑动
        mViewPager.setCurrentItem(index);
    }


    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        // 开始
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        // 正在进行时
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        // 结束
        @Override
        public void onPageSelected(int position) {
            // 当页面滑动结束时，先对页面位置取模
            position = position % imageViewlist.size();
            // 将上一个点的可用性设置为false
            layoutPGroup.getChildAt(previousPoint).setEnabled(false);
            // 把当前点的可用性设置为true
            layoutPGroup.getChildAt(position).setEnabled(true);
            // 把当前位置值赋值给previousPoint
            previousPoint = position;
        }
    }



    private class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        // 当某一页滑出去的时候，将其销毁
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewlist.get(position% imageViewlist.size()));
        }

        // 向容器中添加图片，由于我们要实现循环滑动的效果，所以要对position取模
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewlist.get(position % imageViewlist.size()));
            return imageViewlist.get(position % imageViewlist.size());
        }
    }

}
