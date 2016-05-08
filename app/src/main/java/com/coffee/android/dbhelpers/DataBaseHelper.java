package com.coffee.android.dbhelpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.coffee.android.entities.Fact;
import com.coffee.android.enums.FactName;

import static com.coffee.android.dbhelpers.FactsDbContract.TEXT;

/**
 * Created by michal_re on 06/05/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_TABLE = "facts.db";
    private static final int    DATABASE_VERSION = 1;
    private static final String SQL_DROP_FACTS_TABLE =
            "DROP TABLE IF EXISTS " + FactsDbContract.FACTS_TBL;

    private static final String SQL_CREATE_TABLE_FACT = "CREATE TABLE "
            + FactsDbContract.FACTS_TBL + "(" + FactsDbContract.KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TEXT
            + " TEXT," + FactsDbContract.FACT_NAME + " TEXT" +")";//," + FactsDbContract.IMAGE_ID + " INTEGER " + ")";
/*
    private static final String SQL_CREATE_TABLE_FACT = "CREATE TABLE "
            + FACTS_TBL + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TEXT
            + " TEXT," + FACT_NAME + " TEXT," + IMAGE_ID + " INTEGER " + ")";*/
    public DataBaseHelper(Context context) {
        super(context, FactsDbContract.FACTS_TBL, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create db tables
        db.execSQL(SQL_CREATE_TABLE_FACT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop and recreate DB
        db.execSQL(SQL_DROP_FACTS_TABLE);
        onCreate(db);
    }

    public Fact getData(FactName factName) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " +FactsDbContract. FACTS_TBL + " WHERE "
                + FactsDbContract.FACT_NAME + " = '" + factName.getId() +"'";

        Cursor c = db.rawQuery(selectQuery, null);

        Fact fact = null;
        if (c != null){
            c.moveToFirst();
            fact = new Fact();
            fact.setId(c.getInt(c.getColumnIndex(FactsDbContract.KEY_ID)));
            fact.setText(c.getString(c.getColumnIndex(FactsDbContract.TEXT)));
        }

        return fact;
    }

    public long insertFact(Fact fact){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
      // values.put(FactsDbContract.KEY_ID, fact.getId());
        values.put(FactsDbContract.FACT_NAME, fact.getId());
        values.put(FactsDbContract.TEXT, fact.getText());

        // insert row
        long id = db.insert(FactsDbContract.FACTS_TBL, null, values);

        return id;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}