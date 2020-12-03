package com.andriod.course.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.andriod.course.activities.FullSignupActivity;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Log.e("MyReceiverClass", "onReceive");
        context.startActivity(new Intent(context, FullSignupActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
}
