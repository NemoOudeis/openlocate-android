package com.openlocate.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG = BootReceiver.class.getSimpleName();
    @Override
    public void onReceive(Context context, Intent intent) {

        SharedPreferences sharedPref = context.getSharedPreferences(Constants.OPENLOCATE, Context.MODE_PRIVATE);
        String serverUrl = sharedPref.getString(Constants.URL_KEY,"");
        boolean isServiceStarted = sharedPref.getBoolean(Constants.IS_SERVICE_STARTED, false);

        if (TextUtils.isEmpty(serverUrl) || !isServiceStarted) {
            return;
        }

        OpenLocate.initialize(new OpenLocate.Configuration.Builder(context, serverUrl).build());

    }
}
