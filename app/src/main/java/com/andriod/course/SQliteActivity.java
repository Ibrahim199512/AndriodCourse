package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class SQliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_qlite);

        MDbHelper mDbHelper = new MDbHelper(this);
//        Product product = new Product("new one2"
//                , 10.5, "cat"
//                , "Shop", "Image");
//        boolean b = mDbHelper.insertProduct(product);
//        Log.e("insertProduct", b + "");

        ArrayList<Product> list = mDbHelper.getAllProduct();
        for (int i = 0; i < list.size(); i++) {
            Log.e("ProductName", list.get(i).getProductName());
        }


//        mDbHelper.editProduct(1);
//        Log.e("deleteProduct", b2 + "");


    }
}
