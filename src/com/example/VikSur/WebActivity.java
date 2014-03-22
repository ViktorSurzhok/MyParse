package com.example.VikSur;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import com.parse.ParsePush;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class WebActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        try {
            examineIntent(getIntent());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        try {
            examineIntent(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void examineIntent(Intent i) throws JSONException {
        JSONObject json = new JSONObject(i.getExtras().getString("com.parse.Data"));

        String u = "";
        Iterator itr = json.keys();

        while (itr.hasNext()) {
            String key = (String) itr.next();
            u += json.getString(key);
            u += "\n";
            break;
        }

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(u);
    }
}
