package com.andriod.course;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MDbHelper extends SQLiteOpenHelper {
    public static String dbname = "Test";
    public static int version = 1;

    public static String productTable = "Product";
    public static String productId = "productId";
    public static String productName = "productName";
    public static String productPrice = "productPrice";
    public static String productCatgory = "productCatgory";
    public static String shopName = "shopName";
    public static String productImage = "productImage";

    public MDbHelper(@Nullable Context context) {
        super(context, dbname, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlProductTable = "create table " + productTable + " ("
                + productId + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + productName + " TEXT NOT NULL,"
                + productPrice + " INTEGER NOT NULL,"
                + productCatgory + " TEXT NOT NULL,"
                + shopName + " TEXT NOT NULL,"
                + productImage + " TEXT NOT NULL" + " )";

        db.execSQL(sqlProductTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + productTable);
        onCreate(db);
    }

    public boolean insertProduct(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(productName, product.getProductName());
        values.put(productCatgory, product.getProductCatgory());
        values.put(productPrice, product.getProductPricr() + "");
        values.put(shopName, product.getShopName());
        values.put(productImage, product.getProductImage());
        Long id = db.insert(productTable, null, values);
        db.close();
        if (id == -1) return false;
        else
            return true;
    }
}
