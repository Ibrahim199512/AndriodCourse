package com.andriod.course.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.andriod.course.modules.Product;

import java.util.ArrayList;

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
                + productPrice + " REAL NOT NULL,"
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

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] project = {productId, productName, productPrice
                , productCatgory, shopName, productImage};
        Cursor cursor = db.query(productTable, project
                , null, null
                , null, null, null);
        cursor.moveToFirst();
        try {
            int productIdColumnIndex = cursor.getColumnIndex(productId);
            int productNameColumnIndex = cursor.getColumnIndex(productName);
            int productPriceColumnIndex = cursor.getColumnIndex(productPrice);
            int productCatgoryColumnIndex = cursor.getColumnIndex(productCatgory);
            int shopNameColumnIndex = cursor.getColumnIndex(shopName);
            int productImageColumnIndex = cursor.getColumnIndex(productImage);
            while (!cursor.isAfterLast()) {
                int temp1 = cursor.getInt(productIdColumnIndex);
                String temp2 = cursor.getString(productNameColumnIndex);
                double temp3 = cursor.getDouble(productPriceColumnIndex);
                String temp4 = cursor.getString(productCatgoryColumnIndex);
                String temp5 = cursor.getString(shopNameColumnIndex);
                String temp6 = cursor.getString(productImageColumnIndex);
                Product product = new Product(temp2, temp3, temp4, temp5, temp6);
                list.add(product);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
            db.close();
        }
        return list;
    }

    public boolean deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int res = db.delete(productTable, "productId = ? ", new String[]{String.valueOf(id)});
        db.close();
        if (res != 0) return true;
        else return false;
    }

    public void editProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(productName, "Test value");
        db.update(productTable, values, "productId = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}
