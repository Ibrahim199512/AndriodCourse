package com.andriod.course;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.e("MyReceiverClass", "onReceive");
        context.startActivity(new Intent(context, FullSignupActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
