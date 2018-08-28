package com.bms.com.seenittest.aplication;

import android.app.Application;
import android.content.Context;

import com.bms.com.seenittest.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/*
    Raju Kumar Sah
* */

public class SeenItApp extends Application
{

    static int counter = 0;
    //app context
    private static Context context;
    private static SeenItApp mInstance;

    /**
     * get app context
     *
     * @return context
     */
    public static Context getAppContext()
    {
        return context;
    }

    public static synchronized SeenItApp getInstance()
    {
        return mInstance;
    }

    public static Context getContext()
    {
        return context;
    }

    /**
     * called on app created
     */
    @Override
    public void onCreate()
    {
        super.onCreate();
        //app context
        context = getApplicationContext();
        mInstance = this;

        //        Stetho.initializeWithDefaults(this);
        //
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Lato-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());

    }
}
