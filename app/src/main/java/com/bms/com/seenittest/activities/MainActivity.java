package com.bms.com.seenittest.activities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bms.com.seenittest.R;
import com.bms.com.seenittest.tabAdapter.PagerAdapter;
import com.bms.com.seenittest.utils.CircleTransform;
import com.bms.com.seenittest.utils.GlideApp;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
{

    private CollapsingToolbarLayout collapsingToolbar;
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private AppBarLayout appBarLayout;
    private ImageView ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initCollapsingToolbar();
        setViews();
    }

    /**
     * Initialize the views
     */
    private void initViews()
    {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        appBarLayout = findViewById(R.id.appbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewpager);
        ivProfile = findViewById(R.id.ivProfile);
    }

    /**
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar()
    {

        collapsingToolbar.setTitle(" ");
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener()
        {
            boolean isShow = false;
            int scrollRange = - 1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset)
            {
                if (scrollRange == - 1)
                {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0)
                {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow)
                {
                    appBarLayout.setExpanded(true);
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void setViews()
    {
        GlideApp
                .with(Objects.requireNonNull(this))
                .load(R.drawable.raju)
                .transform(new CircleTransform(this))
                .into(ivProfile);
        tabLayout.addTab(tabLayout.newTab().setText("Womenswear"));
        tabLayout.addTab(tabLayout.newTab().setText("Menswear"));
        tabLayout.addTab(tabLayout.newTab().setText("Grooming"));
        tabLayout.addTab(tabLayout.newTab().setText("Fine Jewellery"));
        tabLayout.addTab(tabLayout.newTab().setText("Other items"));

        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewpager.setAdapter(adapter);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });
    }
}
