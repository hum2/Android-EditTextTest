package com.example.shuheisuzuki.edittexttest;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    private EditText mTitleText;
    private EditText mContentText;
    private ActionBar mActionBar;
    private boolean isFullScreen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mActionBar = getSupportActionBar();

        mTitleText = (EditText) findViewById(R.id.title);
        mContentText = (EditText) findViewById(R.id.content);
        mContentText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.d("HOGE", "hasFocus = " + hasFocus);
                if (hasFocus) {
                    isFullScreen = true;
                    mTitleText.setVisibility(View.GONE);
                    mActionBar.hide();
//                    mContentText.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.abc_slide_in_top));
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//                    requestWindowFeature(Window.FEATURE_NO_TITLE);
                } else {
                    mActionBar.show();
                    mTitleText.setVisibility(View.VISIBLE);
//                    mContentText.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.abc_slide_in_bottom));
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && isFullScreen) {
            mTitleText.setVisibility(View.VISIBLE);
            mTitleText.requestFocus();
//            mContentText.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.abc_slide_in_bottom));
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public MenuInflater getMenuInflater() {
        try {
//            return (MenuInflater) Activity.class.getMethod("getMenuInflater").invoke(this);
        } catch (Exception e) {
        }
        return super.getMenuInflater();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
