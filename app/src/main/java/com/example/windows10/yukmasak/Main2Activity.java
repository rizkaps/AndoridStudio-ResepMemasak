package com.example.windows10.yukmasak;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    public DataAdapter dataAdapter;
    public RecyclerView recyclerView;
    public ArrayList<DataModel> dataModelArrayList=new ArrayList<DataModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //membuat data yang akan ditampilkan dalam list file .html mengambil di folder assets
        inputData("Ayam Geprek","ayam_geprek.html");
        inputData("Sosis Kentang","sosis_kentang.html");
        inputData("Sandwich","sandwich.html");
        inputData("Nasi Liwet Khas Sunda", "nasi_liwet_khas_sunda.html");
        inputData("Pizza Sosis Jumbo", "pizza.html");
        inputData("Nasi Goreng Mawut", "nasgor_mawut.html");
        inputData("Fuyung Hai", "fuyunghai.html");
        inputData("Lobster bumbu Padang", "lobster.html");
        inputData("Sop Iga Sapi","sop_iga_sapi.html");
        inputData("Opor Ayam Kampung", "opor_ayam.html");
        inputData("Bebek Goreng Sambel Ijo", "bebek_goreng.html");
        inputData("Soto Ayam Kampung", "soto_ayam.html");
        inputData("Rawon","rawon.html");
        inputData("Ikan Gurame Bakar", "ikan_gurame_bakar.html");
        inputData("Pisang Bakar Coklat Keju", "pisang_bakar.html");
        inputData("Martabak Terang Bulan", "martabak.html");

        //menampilkan data ke dalam recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        dataAdapter = new DataAdapter(this,dataModelArrayList);
        recyclerView.setAdapter(dataAdapter);

        //menambahakan header
        DataModel headerModel = new DataModel();
        headerModel.setViewType(2);
        dataModelArrayList.add(0,headerModel);
    }

    //fungsi input
    public void inputData(String judul,String konten){
        DataModel dataModel = new DataModel();
        dataModel.setJudul(judul);
        dataModel.setKonten(konten);
        dataModel.setViewType(1);
        dataModelArrayList.add(dataModel);
    }
}
