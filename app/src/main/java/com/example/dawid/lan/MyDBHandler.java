package com.example.dawid.lan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDBHandler extends SQLiteOpenHelper {

    private String TAG="problem";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB111.db";
    public static final String TABLE_PRODUCTS = "products11";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";
    public static final String COLUMN_NUMBER = "number";

    //We need to pass database information along to superclass
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRODUCTNAME + " TEXT, " + COLUMN_NUMBER + " Integer " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }

    //Add a new row to the database
    public void addProduct(Product product){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NUMBER, product.getId());
        values.put(COLUMN_PRODUCTNAME, product.getString());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    //Delete a product from the database
    public void deleteProduct(int number) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_NUMBER + "=\"" + number + "\";");
    }

    public String databaseToString(int number){
        String dbString = "problem";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 1";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            Log.v(TAG,"while");
            if (c.getInt(c.getColumnIndex("number"))==number) {
               Log.v(TAG,"====");
                dbString = c.getString(c.getColumnIndex("productname"));
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

}