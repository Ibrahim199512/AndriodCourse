package com.andriod.course;

import android.app.Application;
import android.content.IntentFilter;

import com.andriod.course.receivers.SmsReceiver;

public class SubApplication extends Application {
    // Overriding this method is totally optional!
    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!
        registerSmsReceiver();

    }

    private void registerSmsReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        SmsReceiver smsReceiver = new SmsReceiver();
        registerReceiver(smsReceiver, filter);
    }

}
