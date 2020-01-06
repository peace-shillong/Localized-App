package com.peace.localizedapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Application
 * @author Kyrshanlang R Dkhar, Peace
 */
public class MyApplication extends Application {

    /**
     * The Default language
     */
    String lang="en";

    /**
     * This method gets the default language of the app and attaches it to the context of the application
     * using the LocaleHelper class, an external class
     * @param base
     */
    @Override
    protected void attachBaseContext(Context base) {
        SharedPreferences preferences=base.getSharedPreferences("AppPref", 0); // 0 - for private mode
        lang=preferences.getString("Locale.Helper.Selected.Language","");
       // Log.d("LANG",lang);
        super.attachBaseContext(LocaleHelper.onAttach(base, lang));
    }
}
