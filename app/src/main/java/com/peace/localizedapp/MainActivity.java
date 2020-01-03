package com.peace.localizedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView mTextView;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getApplicationContext().getSharedPreferences("AppPref", 0); // 0 - for private mode

        mTextView=findViewById(R.id.hello);

        updateViews();

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase));
    }

    public void newActivity(View view) {
        //Log.d("DEFA",,""));
        //LocaleHelper.setLocale(this,"kha");
        startActivity(new Intent(this,Second.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            startActivity(new Intent(this,AppSettings.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateViews();

    }

    private void updateViews() {
        Context context = LocaleHelper.setLocale(MainActivity.this, preferences.getString("Locale.Helper.Selected.Language","en"));
        Resources resources = context.getResources();
        mTextView.setText(resources.getString(R.string.hello));
    }
}
