package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        ArrayList<Product> productList = new ArrayList<>();

        productList.add(new Product("Name1"
                , 100.5
                , "cat"
                , "shop"
                , "https://imgix.bustle.com/uploads/image/2020/6/1/c7dbe48c-d444-42ba-9c26-1354d4cafa30-1842106.jpg"));
        productList.add(new Product("Name2"
                , 100.5
                , "cat"
                , "shop"
                , "https://www.yankodesign.com/images/design_news/2020/06/PS5_redesigned_by_Touguet.jpg"));
        productList.add(new Product("Name3"
                , 100.5
                , "cat"
                , "shop"
                , "https://images.tweaktown.com/news/6/8/68046_5_sony-restructuring-prepare-ps5.jpg"));

        productList.add(new Product("Name1"
                , 100.5
                , "cat"
                , "shop"
                , "https://imgix.bustle.com/uploads/image/2020/6/1/c7dbe48c-d444-42ba-9c26-1354d4cafa30-1842106.jpg"));
        productList.add(new Product("Name2"
                , 100.5
                , "cat"
                , "shop"
                , "https://www.yankodesign.com/images/design_news/2020/06/PS5_redesigned_by_Touguet.jpg"));
        productList.add(new Product("Name3"
                , 100.5
                , "cat"
                , "shop"
                , "https://images.tweaktown.com/news/6/8/68046_5_sony-restructuring-prepare-ps5.jpg"));

        productList.add(new Product("Name1"
                , 100.5
                , "cat"
                , "shop"
                , "https://imgix.bustle.com/uploads/image/2020/6/1/c7dbe48c-d444-42ba-9c26-1354d4cafa30-1842106.jpg"));
        productList.add(new Product("Name2"
                , 100.5
                , "cat"
                , "shop"
                , "https://www.yankodesign.com/images/design_news/2020/06/PS5_redesigned_by_Touguet.jpg"));
        productList.add(new Product("Name3"
                , 100.5
                , "cat"
                , "shop"
                , "https://images.tweaktown.com/news/6/8/68046_5_sony-restructuring-prepare-ps5.jpg"));

        RecyclerView recyclerview = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerview.setLayoutManager(layoutManager);
        ProductAdapter productAdapter = new ProductAdapter(productList,this);
        recyclerview.setAdapter(productAdapter);

    }
}
