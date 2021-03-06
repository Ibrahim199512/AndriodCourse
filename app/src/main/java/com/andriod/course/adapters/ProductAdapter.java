package com.andriod.course.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andriod.course.R;
import com.andriod.course.modules.Product;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    ArrayList<Product> productsList;
    Context context;
    Product product;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView productName, productPrice, productCatgory, shopName;
        ImageView productImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productCatgory = itemView.findViewById(R.id.product_catgory);
            shopName = itemView.findViewById(R.id.shop_name);
            productImage = itemView.findViewById(R.id.product_image);
        }
    }

    public ProductAdapter(ArrayList<Product> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        product = productsList.get(position);
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(product.getProductPricr() + " $");
        holder.productCatgory.setText(product.getProductCatgory());
        holder.shopName.setText(product.getShopName());
        holder.shopName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product = productsList.get(position);
                Toast.makeText(context, product.getProductName(), Toast.LENGTH_SHORT).show();
                Log.e("position", position + "");
            }
        });
        Glide.with(context).load(product.getProductImage()).into(holder.productImage);

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }


}
