package com.nadhif.matriksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Penjumlahan(View view){
        Intent intent = new Intent(this, PenjumlahanActivity.class);
        startActivity(intent);
    }


    public void Pengurangan(View view){
        Intent intent = new Intent(this, PenguranganActivity.class);
        startActivity(intent);
    }


    public void Perkalian(View view){
        Intent intent = new Intent(this, PerkalianActivity.class);
        startActivity(intent);
    }

    public void Determinan(View view) {
        Intent intent = new Intent(this, DeterminanActivity.class);
        startActivity(intent);
    }

    }
