package com.peace.localizedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

/**
 * A Second Activity Screen that displays text in the selected language set by the user
 */
public class Second extends AppCompatActivity {

    TextView mTextView;
    private Resources resources;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        preferences = getApplicationContext().getSharedPreferences("AppPref", 0); // 0 - for private mode
        Context context = LocaleHelper.setLocale(Second.this, preferences.getString("Locale.Helper.Selected.Language",""));
        resources = context.getResources();

        mTextView=findViewById(R.id.textView);
        mTextView.setText(resources.getString(R.string.title));
    }
}
