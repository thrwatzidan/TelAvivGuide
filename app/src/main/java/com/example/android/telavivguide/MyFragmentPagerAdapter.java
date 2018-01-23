
package com.example.android.telavivguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private static int NUM_ITEMS = 5;
    private Context mContext;

    public MyFragmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        mContext = context;
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show MapFragment
                return MapFragment.newInstance(0, getPageTitle(0).toString());
            case 1: // Fragment # 1 - This will show RestaurantsFragment
                return RestaurantsFragment.newInstance(1, getPageTitle(1).toString());
            case 2: // Fragment # 2- This will show MarketsFragment
                return MarketsFragment.newInstance(2, getPageTitle(2).toString());
            case 3: // Fragment # 3 - This will show MuseumsFragment
                return MuseumsFragment.newInstance(3, getPageTitle(3).toString());
            case 4: // Fragment # 4 - This will show OtherAttractionsFragment
                return OtherAttractionsFragment.newInstance(4, getPageTitle(4).toString());
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show MapFragment
                return   mContext.getResources().getString(R.string.category_main);
            case 1: // Fragment # 1 - This will show RestaurantsFragment
                return mContext.getResources().getString(R.string.category_restaurants);
            case 2: // Fragment # 2- This will show MarketsFragment
                return mContext.getResources().getString(R.string.category_markets);
            case 3: // Fragment # 3 - This will show MuseumsFragment
                return mContext.getResources().getString(R.string.category_Museums);
            case 4: // Fragment # 4 - This will show OtherAttractionsFragment
                return mContext.getResources().getString(R.string.category_other_attractions);
            default:
                return null;
        }
    }
}
