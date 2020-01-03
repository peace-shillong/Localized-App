package com.peace.localizedapp;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MyApplication extends Application {

    String lang="en";

    @Override
    protected void attachBaseContext(Context base) {
        SharedPreferences preferences=base.getSharedPreferences("AppPref", 0); // 0 - for private mode
        lang=preferences.getString("Locale.Helper.Selected.Language","");
        Log.d("LANG",lang);
        super.attachBaseContext(LocaleHelper.onAttach(base, lang));
    }
}
