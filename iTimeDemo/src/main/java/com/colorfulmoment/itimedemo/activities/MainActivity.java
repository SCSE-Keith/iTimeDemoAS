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
	
	private static final int[] ITEM_DRAWABLES = { R.drawable.composer_camera, R.drawable.composer_music, R.drawable.composer_thought, R.drawable.composer_with };
    private ViewPager mPager;//页卡内容
    private ArcMenu mMenu;
    private ArrayList<Fragment> mFragmentList;
    private long exitTime = 0;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
        Stat.initStat();
        initMenu(ITEM_DRAWABLES);
		initViewPager();
	}
    
    private void initMenu(int[] itemDrawables) {
		mMenu = (ArcMenu)findViewById(R.id.arc_menu);
        final int itemCount = itemDrawables.length;
        for (int i = 0; i < itemCount; i++) {
            ImageView item = new ImageView(this);
            item.setImageResource(itemDrawables[i]);
            final int position = i;
            mMenu.addItem(item, new OnClickListener() {
                @Override
                public void onClick(View v) {
                	mPager.setCurrentItem(position);
                    //Toast.makeText(MainActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
	}

	private void initViewPager() {
        mPager = (ViewPager)findViewById(R.id.main_pager);
        mFragmentList = new ArrayList<Fragment>();
        
        Fragment todayFragment = TodayFragment.newInstance();  
        Fragment personalFragment = PersonalFragment.newInstance();
        Fragment groupFragment = GroupFragment.newInstance();
        Fragment activitiesFragment = ActivitiesFragment.newInstance();
        
        mFragmentList.add(todayFragment);  
        mFragmentList.add(personalFragment);
        mFragmentList.add(groupFragment);
        mFragmentList.add(activitiesFragment);
        
        mPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), mFragmentList));
        mPager.setCurrentItem(0);
    }
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
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
