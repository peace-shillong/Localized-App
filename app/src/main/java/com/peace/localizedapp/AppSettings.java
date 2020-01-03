package com.peace.localizedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AppSettings extends AppCompatActivity {

    private Spinner language;
    private Resources resources;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);

        language=findViewById(R.id.language);

        preferences=getApplicationContext().getSharedPreferences("AppPref", 0); // 0 - for private mode
        editor= preferences.edit();

        ArrayAdapter mAdapter = new ArrayAdapter<String>(AppSettings.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.languages));
        language.setAdapter(mAdapter);

        //setSelected Option for language
        if (LocaleHelper.getLanguage(AppSettings.this).equalsIgnoreCase("en")) {
            language.setSelection(mAdapter.getPosition("English"));
        } else if (LocaleHelper.getLanguage(AppSettings.this).equalsIgnoreCase("kha")) {
            language.setSelection(mAdapter.getPosition("Khasi"));
        }

        language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(AppSettings.this, "en");
                        resources = context.getResources();
                        editor.putString("Locale.Helper.Selected.Language", "en"); // Storing string
                        editor.commit(); // commit changes
                        Toast.makeText(context, "Language Set to English", Toast.LENGTH_SHORT).show();
                        updateViews();
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(AppSettings.this, "kha");
                        resources = context.getResources();
                        editor.putString("Locale.Helper.Selected.Language", "kha"); // Storing string
                        editor.commit(); // commit changes
                        Toast.makeText(context, "Language Set to Khasi", Toast.LENGTH_SHORT).show();
                        updateViews();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    private void updateViews() {

    }
}
