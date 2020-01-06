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

/**
 * The Main Activity for the Application,
 * This is the first Screen the user sees
 * @author Kyrshanlang R Dkhar, Peace
 * <a href="https://kyrshan.com">Visit my website</a>
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Watch me document this code
     */

    /**
     * TextView for user to see
     */
    TextView mTextView;
    /**
     * SharedPreference object
     */
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

    /**
     * opens the next activity
     * @see Second
     * @param view the view that called the function
     */
    public void newActivity(View view) {
        //Log.d("DEFA",,""));
        //LocaleHelper.setLocale(this,"kha");
        startActivity(new Intent(this,Second.class));
    }

    /**
     * inflates the menu
     * @param menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * This method gets called when user select an option from the menu
     * @param item a MenuItem Selected
     * @return the selected Item
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.settings) {
            startActivity(new Intent(this,AppSettings.class));
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Method called on Resume of the activity
     */
    @Override
    protected void onResume() {
        super.onResume();
        updateViews();

    }

    /**
     * This method will update all the views with text in the current selected language
     */
    private void updateViews() {
        Context context = LocaleHelper.setLocale(MainActivity.this, preferences.getString("Locale.Helper.Selected.Language","en"));
        Resources resources = context.getResources();
        mTextView.setText(resources.getString(R.string.hello));
    }
}
