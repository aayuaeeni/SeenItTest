package com.bms.com.seenittest.tabAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bms.com.seenittest.fragments.FineJewelleryFragment;
import com.bms.com.seenittest.fragments.GromingFragment;
import com.bms.com.seenittest.fragments.MensWearFragment;
import com.bms.com.seenittest.fragments.OtheItemFragment;
import com.bms.com.seenittest.fragments.WomensWearFragment;

public class PagerAdapter extends FragmentStatePagerAdapter
{
    private int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position)
    {

        switch (position)
        {
            case 0:
                return new WomensWearFragment();
            case 1:
                return new MensWearFragment();
            case 2:
                return new GromingFragment();
            case 3:
                return new FineJewelleryFragment();
            case 4:
                return new OtheItemFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return mNumOfTabs;
    }
}