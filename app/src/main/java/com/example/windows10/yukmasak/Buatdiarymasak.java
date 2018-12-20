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
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.media.Image;


public class Buatdiarymasak extends AppCompatActivity {
    //deklarasi objek
    Cursor cursor;
    DataHelper dbHelper;
    Button ton1, ton2, btncamera;
    EditText text1, text2, text3, text4, text5;
    ImageView Image;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buatdiarymasak);

        //deklarasi id button dan id text dari layout juga instansiasi class datahelper
        dbHelper = new DataHelper(this);
        text1 = (EditText) findViewById(R.id.editText1);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        ton1 = (Button) findViewById(R.id.button1);
        ton2 = (Button) findViewById(R.id.button2);

        ton1.setOnClickListener(new View.OnClickListener() {
            //memasukkan data kedalam DB Sql lite dengan inputan casting ke string
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();//override method class datahelper
                db.execSQL("insert into diary(no, nama, alat, bahan, catatan) values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Diarymasak.dm.RefreshList();
                finish();
                //data berhasil diinputkan pada DB
            }
        });

        //KAMERA API
        //===========================================================================

        Image= (ImageView) findViewById(R.id.image);
        btncamera = (Button) findViewById(R.id.btnCamera);
        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(1 == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            Image.setImageBitmap(bitmap);
        }
    }

    public void back(View view) {
        Intent inte = new Intent(Buatdiarymasak.this, Diarymasak.class);
        startActivity(inte);
    }
}










