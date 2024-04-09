package com.example.commidtermnguyenthetuyen;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "answers.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_ANSWERS = "answers";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_ANSWER = "answer";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_ANSWERS_TABLE = "CREATE TABLE " + TABLE_ANSWERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_ANSWER + " TEXT" + ")";
        db.execSQL(CREATE_ANSWERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWERS);
        onCreate(db);
    }

    public void addAnswer(String answer) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ANSWER, answer);
        db.insert(TABLE_ANSWERS, null, values);
        db.close();
    }

    public Cursor getAllAnswers() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_ANSWERS, null);
    }
}