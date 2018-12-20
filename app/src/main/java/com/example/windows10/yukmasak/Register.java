package com.example.windows10.yukmasak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    //deklarasi objek
    Cursor cursor;
    DataHelperlogin dbHelper;
    Button ton1;
    EditText email, username, password, confirmpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //deklarasi id button dan id text dari layout juga instansiasi class datahelper
        dbHelper = new DataHelperlogin(this);
        email = (EditText) findViewById(R.id.inputEmail);
        username = (EditText) findViewById(R.id.inputUsername);
        password = (EditText) findViewById(R.id.inputPassword);
        confirmpassword = (EditText) findViewById(R.id.confirmPassword);
        ton1 = (Button) findViewById(R.id.btnDaftar);


        ton1.setOnClickListener(new View.OnClickListener()

        {
            //memasukkan data kedalam DB Sql lite dengan inputan casting ke string
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                String Username = username.getText().toString();
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Confirmpassword = confirmpassword.getText().toString();

                if (Username.equals("") || Username.trim().isEmpty() || Email.equals("") || Email.trim().isEmpty() || Password.equals("") || Password.trim().isEmpty()) {
                    Toast.makeText(Register.this, "Username Password harus diisi", Toast.LENGTH_LONG).show();
                }

                //jika email tidak memiliki @ maka tampil pesa eror
                else if (!(Email.contains("@"))) {
                    Toast.makeText(Register.this, "Masukkan format email dengan benar", Toast.LENGTH_LONG).show();
                } else if (!Password.equals(Confirmpassword)) {
                    Toast.makeText(Register.this, "Confirm Password tidak sama", Toast.LENGTH_LONG).show();
                } else {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();//override method class datahelper
                    db.execSQL("insert into biodata(email, username, password, confirmpassword) values('" +
                            email.getText().toString() + "','" +
                            username.getText().toString() + "','" +
                            password.getText().toString() + "','" +
                            confirmpassword.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    goToActivity();
                    finish();
                }
                //data berhasil diinputkan pada DB
            }
        });
    }



    private void goToActivity(){
        Intent mIntent = new Intent (getApplicationContext(), Login.class);
        startActivity(mIntent);
    }

    public void Back(View view) {
        Intent inte = new Intent(Register.this, Login.class);
        startActivity(inte);
    }
}
