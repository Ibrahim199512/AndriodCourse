package com.andriod.course.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.andriod.course.R;

public class FCMActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_c_m);

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getString("type") != null) {
                Log.e("type", getIntent().getExtras().getString("type") + "");
                openWithNotification(getIntent().getExtras().getString("type"));
            } else {
                //Regular Case
            }
        } else {
            //Regular Case
        }


    }

    private void openWithNotification(String type) {
        Intent intent = null;
        switch (Integer.parseInt(type)) {
            case 0:
                intent = new Intent(this, FullSignupActivity.class);
                break;
            case 1:
                intent = new Intent(this, UploadFileAndImagesActivity.class);
                break;
            default:
                intent = new Intent(this, RealTimeDatabaseActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
