package com.example.windows10.yukmasak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //deklarasi global objek
    EditText inpUsername, inpPassword;
    Button buttonLogin, buttonDaftar;
    DataHelperlogin dataHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        inpUsername = findViewById(R.id.inputUsername);
        inpPassword = findViewById(R.id.inputPassword);
        buttonLogin = findViewById(R.id.login);
        buttonDaftar = findViewById(R.id.daftar);
        dataHelper = new DataHelperlogin(this);
        //instansiasi class session management



        //syntax yang menandakan bahwa data login harus diisi seluruhnya atau tidak kosong
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inpUsername.getText().toString();
                String password = inpPassword.getText().toString();


                if (username.equals("") || username.trim().isEmpty() || password.equals("") || password.trim().isEmpty()) {
                    Toast.makeText(Login.this, "USERNAME / PASSWORD HARUS DIISI", Toast.LENGTH_LONG).show();
                }
                //jika username dan password dimasukkan ada di database maka akan melakukan fungsi session dan goToActivity
                else if (dataHelper.autentikasi(username, password)) {

                    Intent mIntent = new Intent(getApplicationContext(),
                            Diarymasak.class);

                    startActivity(mIntent);
                }
                //jika username dan password tidak ada di database maka tampil pesan eror
                else {
                    Toast.makeText(Login.this, "Login Gagal , email belum terdaftar", Toast.LENGTH_LONG).show();
                }


            }

        });
        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivityregister();
            }
        });
    }


    private void goToActivityregister(){
        Intent mIntent = new Intent (getApplicationContext(), Register.class);
        startActivity(mIntent);
    }

    public void Home(View view) {
        Intent inte = new Intent(Login.this, ResepDanDiary.class);
        startActivity(inte);
    }
}
