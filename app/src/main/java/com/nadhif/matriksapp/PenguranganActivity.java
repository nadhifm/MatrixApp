package com.nadhif.matriksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PenguranganActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengurangan);
    }


    public void HasilPengurangan(View view){

        EditText[][] e = new EditText[2][9];
        int[] matriksA = new int[9];
        int[] matriksB = new int[9];
        int[] hasil = new int[9];
        TextView[] t = new TextView[9];
        String[] g = new String[9];
        LinearLayout lLHasil = findViewById(R.id.lLHasil);
        TextView tvHasil = findViewById(R.id.tvHasil);
        int i,j;

        for (i=0;i<2;i++){
            for (j=0;j<9;j++){
                String s = "T"+i+j;
                e[i][j]=findViewById(getResources().getIdentifier(s, "id", getPackageName()));

                if (e[i][j].length()==0){
                    e[i][j].setError("Masukan Angka");
                }

                if (i==0){
                    try {
                        matriksA[j] = Integer.parseInt(e[i][j].getText().toString());
                    }catch (NumberFormatException nfe){
                        matriksB[j] = 0;
                    }}

                if (i==1){
                    try {
                        matriksB[j] = Integer.parseInt(e[i][j].getText().toString());
                    }catch (NumberFormatException nfe){
                        matriksB[j] = 0;
                    }
                }

                hasil[j]= matriksA[j]-matriksB[j];
            }
        }

        for (j=0;j<9;j++){
            String s = "T"+j;
            t[j]=findViewById(getResources().getIdentifier(s, "id", getPackageName()));
            g[j]= Integer.toString(hasil[j]);
            t[j].setText(g[j]);
        }


        lLHasil.setVisibility(View.VISIBLE);
        tvHasil.setVisibility(View.VISIBLE);

        closeKeyboard();
    }

    public void onBackPressed(View view) {
        super.onBackPressed();
    }

    public void closeKeyboard(){
        View view = this.getCurrentFocus();

        if (view != null) {
            InputMethodManager imm =(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }
}
