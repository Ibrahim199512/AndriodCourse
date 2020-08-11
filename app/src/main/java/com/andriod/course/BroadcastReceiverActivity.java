package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class BroadcastReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_receiver);

        registerSmsReceiver();
        requestSmsPermission();

        findViewById(R.id.custem_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.ibrahim.alwadiya.CUSTEM_ACTION");
                sendBroadcast(intent);
            }
        });


    }

    private void registerSmsReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(getPackageName() + "android.provider.Telephony.SMS_RECEIVED");
        SmsReceiver smsReceiver = new SmsReceiver();
        registerReceiver(smsReceiver, filter);
    }

    private void requestSmsPermission() {
        String readSms = Manifest.permission.READ_SMS;
        String receiveSms = Manifest.permission.RECEIVE_SMS;
        int grant = ContextCompat.checkSelfPermission(this, readSms)
                + ContextCompat.checkSelfPermission(this, receiveSms);
        if (grant != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this
                    , new String[]{readSms, receiveSms}, 1);
        } else {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            Log.d("", "Permission granted");
        }
    }
}
