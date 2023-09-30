package com.example.placifyu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class MSGdb extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=2;
    private static final String DATABASE_NAME="MMS";
    public MSGdb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Msgtable(mno integer primary key autoincrement,code text,mdate text,time text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Msgtable");
        onCreate(db);

    }
    public void addmsg(String code,String date,String time){
        try{
            SQLiteDatabase db=getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("code",code);
            cv.put("mdate",date);
            cv.put("time",time);
            db.insert("Msgtable",null,cv);
            db.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public List<MSG> getAllvalues() {
        List<MSG> recList = new ArrayList<MSG>();
        String selectQuery = "SELECT * FROM MsgTable";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MSG rec = new MSG();
                rec.code = cursor.getString(1);
                rec.date = cursor.getString(2);
                rec.time = cursor.getString(3);
                recList.add(rec);
            } while (cursor.moveToNext());
        }
        return recList;
    }
}
