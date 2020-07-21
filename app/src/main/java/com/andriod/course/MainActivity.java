package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("onCreate", "onCreate");
        Button testButton = findViewById(R.id.test_button);

        testButton.setText("New Text");

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SimpleCalculatorActivity.class);
                intent.putExtra("Name", "Ibrahim Alwadiya");
                startActivity(intent);
                finish();


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
