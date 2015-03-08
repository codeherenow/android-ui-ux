package com.codeherenow.walkthrough;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * @author Ragunath Jawahar <www.codeherenow.com>
 */
public class WalkthroughPagerAdapter extends FragmentPagerAdapter {

    /*
     * Mandatory constructor.
     */
    public WalkthroughPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    /*
     * This method is responsible for creating and returning "pages" for the
     * `ViewPager`. You can return any `Fragment` based on the position. It's not
     * necessary to return the same type of `Fragment` all the time.
     */
    @Override
    public Fragment getItem(int position) {
        return new WalkthroughItemFragment();
    }

    /*
     * The number of pages in the `ViewPager` will be equal to the count
     * that is returned by this method.
     */
    @Override
    public int getCount() {
        return 4;
    }
}
