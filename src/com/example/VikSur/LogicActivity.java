package com.example.VikSur;

import android.app.Application;
import android.content.Context;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseInstallation;
import com.parse.PushService;

public class LogicActivity extends Application {

    private static final String APPLICATION_ID = "mtUTgWsjYQaOR7lNG17l14XQ5toHS9bSGJWHTx6j";
    private static final String CLIENT_KEY = "2PJg409fvbLPnEfhFS11REcReVcPakCFT0UKJMsa";

    public LogicActivity() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

        PushService.setDefaultPushCallback(this, WebActivity.class);
        ParseInstallation pi = ParseInstallation.getCurrentInstallation();

        Context ctx = this.getApplicationContext();
        PushService.subscribe(ctx, "ch1", WebActivity.class);
        pi.saveEventually();

    }
}
