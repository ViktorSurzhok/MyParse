package com.example.VikSur;

import android.app.Activity;
import android.os.Bundle;
import com.parse.ParseAnalytics;

public class MyActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ParseAnalytics.trackAppOpened(getIntent());
    }
}
