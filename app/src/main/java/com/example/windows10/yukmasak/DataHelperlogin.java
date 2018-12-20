package com.example.windows10.yukmasak;

/**
 * Created by Windows 10 on 07-Dec-18.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelperlogin extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "biodataakun.db";//deklarasi nama DB
    private static final int DATABASE_VERSION = 1;


    public DataHelperlogin(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //TODO Auto-generated constructor stub
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table biodata(email String primary key, username  text null, password text null, confirmpassword text null);";//syntax create tabel biodata
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO biodata (email, username, password, confirmpassword) VALUES ('Email anda', 'Username anda', 'password anda', 'confirmpasswod anda');";
        db.execSQL(sql);
        //syntax inputan data pada tabel biodata di database biodataakun.db
    }


    private static final String TABLE_BIODATA = "biodata";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    public boolean autentikasi(String username, String password){


        String[] columns = {
                KEY_USERNAME
        };

        // mengambil dan password yang sesuai dengan yang di registerkan
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = KEY_USERNAME + " = ?" + " AND " + KEY_PASSWORD + " = ?";

        String[] selectionArgs = {username, password};

        Cursor cursor = db.query(TABLE_BIODATA, columns, selection, selectionArgs, null, null, null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }


}
