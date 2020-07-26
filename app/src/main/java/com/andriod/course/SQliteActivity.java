package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SQliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_qlite);

        MDbHelper mDbHelper = new MDbHelper(this);
        Product product = new Product("new one"
                , 10, "cat"
                , "Shop", "Image");
        boolean b = mDbHelper.insertProduct(product);
        Log.e("insertProduct", b + "");


    }
}
