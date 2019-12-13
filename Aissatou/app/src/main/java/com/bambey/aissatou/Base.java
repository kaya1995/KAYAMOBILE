package com.bambey.aissatou;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Base extends SQLiteOpenHelper {
    private static String DATABASENAME = "student1.db";
    private static int DATABASEVERSION = 1;
    public Base(Context context){
        super (context, DATABASENAME, null, DATABASEVERSION);

    }
    public void onCreate (SQLiteDatabase db) {
        db.execSQL("Create  TABLE student1(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");
    }
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion ){
        //TODO
   }
   public void onOpen (SQLiteDatabase db){
        super.onOpen(db);
   }

}
