package com.example.windows10.yukmasak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ResepDanDiary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_dan_diary);
    }


    public void diarymasak(View view) {
        Intent inte = new Intent(ResepDanDiary.this, Login.class);
        startActivity(inte);
    }

    public void Exit(View view) {
        Intent inte = new Intent(ResepDanDiary.this, MainActivity.class);
        startActivity(inte);
    }

    public void resep(View view) {
        Intent intent = new Intent(ResepDanDiary.this, Main2Activity.class);
        startActivity(intent);
    }
}
