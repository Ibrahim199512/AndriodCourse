package com.andriod.course.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andriod.course.R;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String fileName = "fileName";
    String key1 = "name";
    String key2 = "name2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("onCreate", "onCreate");
        Button testButton = findViewById(R.id.test_button);

        testButton.setText("New Text");


        sharedPreferences =
                getSharedPreferences(fileName, MODE_PRIVATE);
        String temp = sharedPreferences.getString(key1, "No value");
        boolean temp2 = sharedPreferences.getBoolean(key2, false);
        Toast.makeText(this, "" + temp, Toast.LENGTH_SHORT).show();


        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(key1);
                editor.apply();


            }
        });
//        testButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String CUSTOM_ACTION = "asdf";
//
////Intent i = new Intent(this, FeedBackActivity.class);  // <--- You might need to do it this way.
//                Intent i = new Intent();
//                i.setAction(CUSTOM_ACTION);
//
//                startActivity(i);
//            }
//        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("onRestart", "onRestart");
    }

    //    public void textMethod(View view) {
//        Log.d("textMethod", "Done");
//        Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
//    }
}
