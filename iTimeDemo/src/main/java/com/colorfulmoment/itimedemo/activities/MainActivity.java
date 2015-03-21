package com.colorfulmoment.itimedemo.activities;

import java.util.ArrayList;

import com.capricorn.ArcMenu;
import com.colorfulmoment.itimedemo.R;
import com.colorfulmoment.itimedemo.adapters.MainPagerAdapter;
import com.colorfulmoment.itimedemo.fragments.ActivitiesFragment;
import com.colorfulmoment.itimedemo.fragments.GroupFragment;
import com.colorfulmoment.itimedemo.fragments.PersonalFragment;
import com.colorfulmoment.itimedemo.fragments.TodayFragment;
import com.colorfulmoment.itimedemo.tools.Stat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

    /*
        主Acivity，搭载了几个页面
     */

	private static final int[] ITEM_DRAWABLES = { R.drawable.composer_camera, R.drawable.composer_music, R.drawable.composer_thought, R.drawable.composer_with };
    private ViewPager mPager;//页卡内容
    private ArcMenu mMenu;
    private ArrayList<Fragment> mFragmentList;
    private long exitTime = 0;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        //设置Activity布局
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); //去掉了原有的标题栏
		setContentView(R.layout.activity_main);

        //初始化数据
        Stat.initStat();

        //设置浮动按钮菜单
        initMenu(ITEM_DRAWABLES);

        //设置页面
		initViewPager();
	}
    
    private void initMenu(int[] itemDrawables) {
		mMenu = (ArcMenu)findViewById(R.id.arc_menu);//在XML布局中找到ArcMenu对应的视图
        final int itemCount = itemDrawables.length;//图标的个数
        for (int i = 0; i < itemCount; i++) {
            //把图标加入菜单
            ImageView item = new ImageView(this);
            item.setImageResource(itemDrawables[i]);
            final int position = i;
            mMenu.addItem(item, new OnClickListener() {
                @Override
                public void onClick(View v) {
                    //点击时按位置切换页面
                	mPager.setCurrentItem(position);
                    //Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
	}

	private void initViewPager() {
        mPager = (ViewPager)findViewById(R.id.main_pager); //承载各页面的ViewPager
        mFragmentList = new ArrayList<Fragment>(); //页面上对应的Fragment链表

        //初始化所有Fragment并全部加入链表
        Fragment todayFragment = TodayFragment.newInstance();  
        Fragment personalFragment = PersonalFragment.newInstance();
        Fragment groupFragment = GroupFragment.newInstance();
        Fragment activitiesFragment = ActivitiesFragment.newInstance();

        mFragmentList.add(todayFragment);  
        mFragmentList.add(personalFragment);
        mFragmentList.add(groupFragment);
        mFragmentList.add(activitiesFragment);

        mPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), mFragmentList)); //为ViewPager设置Adapter
        mPager.setCurrentItem(0); //起始页面为第1页
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            //防止意外退出应用
			if(System.currentTimeMillis() - exitTime > 2000){
				Toast.makeText(getApplicationContext(), "再按一次以退出应用", Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			}
			else {
				finish();
			}
			return true;
		}
		else
			return super.onKeyDown(keyCode, event);
	}
}
