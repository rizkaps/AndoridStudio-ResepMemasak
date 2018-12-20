package com.example.windows10.yukmasak;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Windows 10 on 06-Dec-18.
 */

public class DataHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "diarymasak.db";//deklarasi nama DB
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table diary(no integer primary key, nama text null, alat text null, bahan text null, catatan text null);";//syntax create tabel biodata
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO diary (no, nama, alat, bahan, catatan) VALUES ('1', 'Nama', 'alat', 'bahan', 'catatan');";
        db.execSQL(sql);
        //syntax inputan data pada tabel biodata di database diary.db
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

}
