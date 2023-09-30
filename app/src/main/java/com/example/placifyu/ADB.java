package com.example.placifyu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ADB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DMS";

    // Table and column names for the "companies" table
    private static final String TABLE_COMPANIES = "companies";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_JOB_DESCRIPTION = "jobdescription";
    private static final String COLUMN_COMPANY_NAME = "companyname";
    private static final String COLUMN_EXCEL_LINK = "excellink";
    private static final String COLUMN_ELIGIBILITY_DETAILS = "eligibilitydetails";

    public ADB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the "companies" table
        String CREATE_TABLE_COMPANIES = "CREATE TABLE " + TABLE_COMPANIES + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_JOB_DESCRIPTION + " TEXT, " +
                COLUMN_COMPANY_NAME + " TEXT, " +
                COLUMN_EXCEL_LINK + " TEXT, " +
                COLUMN_ELIGIBILITY_DETAILS + " TEXT);";
        db.execSQL(CREATE_TABLE_COMPANIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPANIES);
        onCreate(db);
    }

    // Insert a new company record
    public void addCompany(String jobDescription, String companyName, String excelLink, String eligibilityDetails) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_JOB_DESCRIPTION, jobDescription);
            cv.put(COLUMN_COMPANY_NAME, companyName);
            cv.put(COLUMN_EXCEL_LINK, excelLink);
            cv.put(COLUMN_ELIGIBILITY_DETAILS, eligibilityDetails);
            db.insert(TABLE_COMPANIES, null, cv);
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Retrieve all companies
    public Cursor getAllCompanies() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_COMPANIES, null, null, null, null, null, null);
    }

    // Update a company record
    public void updateCompany(int id, String jobDescription, String companyName, String excelLink, String eligibilityDetails) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_JOB_DESCRIPTION, jobDescription);
            cv.put(COLUMN_COMPANY_NAME, companyName);
            cv.put(COLUMN_EXCEL_LINK, excelLink);
            cv.put(COLUMN_ELIGIBILITY_DETAILS, eligibilityDetails);
            db.update(TABLE_COMPANIES, cv, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete a company record
    public void deleteCompany(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_COMPANIES, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    // Retrieve a company record by ID
    public Cursor getCompanyById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_COMPANIES, null, COLUMN_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
    }
}
