package com.andriod.course.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "sdsad", Toast.LENGTH_SHORT).show();
        Log.e("SmsReceiverClass", "onReceive");
        final Bundle bundle = intent.getExtras();
        String senderNumber = "", messege = "";
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                String s = "";
                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    senderNumber = currentMessage.getDisplayOriginatingAddress();
                    messege = currentMessage.getDisplayMessageBody();
                    s += messege;
                    Log.d("senderNumber", senderNumber + "");
                    Log.d("messege", messege + "");
                }
            }
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" + e);
        }
    }
}
