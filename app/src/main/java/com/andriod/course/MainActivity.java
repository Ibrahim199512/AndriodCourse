package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email");
//        intent.putExtra(Intent.EXTRA_TEXT, "Body of email");
//        intent.setData(Uri.parse("mailto:default@recipient.com")); // or just "mailto:" for blank
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
//        startActivity(intent);

    }
}
