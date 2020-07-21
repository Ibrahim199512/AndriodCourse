package com.andriod.course;

import java.util.ArrayList;

public class Product {
    private String productName;
    private double productPricr;
    private String productCatgory;
    private String shopName;
    private String productImage;

    public Product(String productName, double productPricr, String productCatgory, String shopName, String productImage) {
        this.productName = productName;
        this.productPricr = productPricr;
        this.productCatgory = productCatgory;
        this.shopName = shopName;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPricr() {
        return productPricr;
    }

    public void setProductPricr(double productPricr) {
        this.productPricr = productPricr;
    }

    public String getProductCatgory() {
        return productCatgory;
    }

    public void setProductCatgory(String productCatgory) {
        this.productCatgory = productCatgory;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}