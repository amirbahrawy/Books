package com.example.android.books;

import android.content.Context;
import android.support.design.widget.TabLayout;
import androidx.core.app.Fragment;
import androidx.core.app.FragmentManager;
import androidx.core.app.FragmentPagerAdapter;
import androidx.core.view.ViewPager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     TabLayout tabLayout;
     ViewPager viewPager;
     BookFragment bookFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=(TabLayout)findViewById(R.id.tab);
        viewPager=(ViewPager) findViewById(R.id.view);
        bookFragment=new BookFragment(getSupportFragmentManager(),this);
         viewPager.setAdapter(bookFragment);
         tabLayout.setupWithViewPager(viewPager);
          tabLayout.getTabAt(0).setIcon(R.drawable.steering);
        tabLayout.getTabAt(1).setIcon(R.drawable.balll);
        tabLayout.getTabAt(2).setIcon(R.drawable.piza);

    }
 public class BookFragment extends FragmentPagerAdapter {
    Context mContext;
     public BookFragment(FragmentManager fm, Context mContext) {
         super(fm);
         this.mContext=mContext;
     }

     @Override
     public Fragment getItem(int position) {
         if (position==0)
             return new CarFragment();
         else if (position==1)
             return new RetrofitFragment();
         else
             return new CarFragment();
     }

     @Override
     public int getCount() {
         return 3;
     }
 }
}
