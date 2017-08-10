package com.acadgild.application102;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Pri on 7/27/2017.
 */

public class MyHelper extends SQLiteOpenHelper {

    public MyHelper(Context context){
        super(context,"productsDB",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
     db.execSQL("CREATE TABLE TABLE_PRODUCTS (COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,COLUMN_PRODUCTNAME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,  int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS TABLE_PRODUCTS");
        onCreate(db);
    }
    public void Addproducts(String productname){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values  = new ContentValues();

        values.put("COLUMN_PRODUCTNAME",productname);
        db.insert("TABLE_PRODUCTS",null,values);
    }
    public ArrayList Databasetoarray(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db =getReadableDatabase();


        String query = "SELECT * FROM TABLE_PRODUCTS WHERE 1";
        Cursor c = db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast()){
            if (c.getString(c.getColumnIndex("COLUMN_PRODUCTNAME"))!=null){
                arrayList.add(c.getString(c.getColumnIndex("COLUMN_PRODUCTNAME")));
                c.moveToNext();

            }

        }
        db.close();
        return arrayList;
    }

}

