package com.example.placifyu;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ComDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CMS";

    public ComDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Company(cno integer primary key autoincrement,jd text,cname text,link text,crit text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Company");
        onCreate(db);
    }

    public void addCompany(Cname d) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("jd", d.jd);
            cv.put("cname", d.cname);
            cv.put("link", d.link);
            cv.put("crit", d.crit);
            db.insert("Company", null, cv);
            db.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    public int deleteCom(int cno) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Company", "cno=?", new String[]{String.valueOf(cno)});
    }

    public List<Cname> getAllvalues() {
        List<Cname> recList = new ArrayList<Cname>();
        String selectQuery = "SELECT * FROM Company";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Cname rec = new Cname();
                rec.id = Integer.parseInt(cursor.getString(0));
                rec.jd = cursor.getString(1);
                rec.cname = cursor.getString(2);
                rec.link = cursor.getString(3);
                rec.crit = cursor.getString(4);
                recList.add(rec);
            } while (cursor.moveToNext());
        }
        return recList;
    }
}
