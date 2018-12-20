package com.example.windows10.yukmasak;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Updatediarymasak extends AppCompatActivity {
    //deklarasi objek
    Cursor cursor;
    DataHelper dbHelper;
    Button ton1;
    EditText text1, text2, text3, text4, text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatediarymasak);

        //deklarasi id button dan id text dari layout juga instansiasi class datahelper
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM diary WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'",null);
        cursor.moveToFirst();//syntax select database data dari tabel biodata keseluruhan

        if (cursor.getCount()>0)     {
            cursor.moveToPosition(0);
            text1.setText(cursor.getString(0).toString());
            text2.setText(cursor.getString(1).toString());
            text3.setText(cursor.getString(2).toString());
            text4.setText(cursor.getString(3).toString());
            text5.setText(cursor.getString(4).toString());
        }
        ton1 = (Button) findViewById(R.id.button1);
        //deklarasi button 1
        // daftarkan even onClick pada btnSimpan
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update diary set nama='"+
                        text2.getText().toString() +"', alat='" +
                        text3.getText().toString()+"', bahan='"+
                        text4.getText().toString() +"', catatan='" +
                        text5.getText().toString() + "' where no='" +
                        text1.getText().toString()+"'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Diarymasak.dm.RefreshList();
                finish();
                //syntax update isi tabel yang dipilih dengan akses class data helper, method getwritabledatabase
            }
        });

    }


    public void Back(View view) {
        Intent inte = new Intent(Updatediarymasak.this, Diarymasak.class);
        startActivity(inte);
    }
}
