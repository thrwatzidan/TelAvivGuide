package com.example.android.telavivguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static ViewPager viewPager;
    private TabLayout tabLayout;
    MyFragmentPagerAdapter adapterViewPager;
    FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        fm = getSupportFragmentManager();
        adapterViewPager = new MyFragmentPagerAdapter(fm, this);
        viewPager.setAdapter(adapterViewPager);
        // Set the tabs onto the view pager
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public void onBackPressed() {
        int position= tabLayout.getSelectedTabPosition();
        // if the current tab is the first one and you press back - then the app is doing the regular "onBackPressed() and exit
        if (position==0) {
        super.onBackPressed();}
        else {
            // if the current tab is different from the first tab and you press back - the tab is set on the first one
            viewPager.setCurrentItem(0);
        }
    }
}

