package com.nadhif.matriksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class DeterminanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_determinan);
    }

    public void HasilDeterminan(View view){

        EditText[][] e = new EditText[1][9];
        TextView tvHasil = findViewById(R.id.tvHasil);
        TextView determinan = findViewById(R.id.T10);
        String hasilDeterminan;
        int[] matriksA = new int[9];
        int hasil;
        int i,j;

        for (i=0;i<1;i++){
            for (j=0;j<9;j++){
                String s = "T"+i+j;
                e[i][j]=findViewById(getResources().getIdentifier(s, "id", getPackageName()));

                if (e[i][j].length()==0){
                    e[i][j].setError("Masukan Angka");
                }

                try {
                    matriksA[j] = Integer.parseInt(e[i][j].getText().toString());
                }catch (NumberFormatException nfe){
                    matriksA[j] = 0;
                }
            }
        }

        hasil =  matriksA[0]*matriksA[4]*matriksA[8]
                +matriksA[1]*matriksA[5]*matriksA[6]
                +matriksA[2]*matriksA[3]*matriksA[7]
                -matriksA[2]*matriksA[4]*matriksA[6]
                -matriksA[0]*matriksA[5]*matriksA[7]
                -matriksA[1]*matriksA[3]*matriksA[8];

        hasilDeterminan = Integer.toString(hasil);

        determinan.setText(hasilDeterminan);

        tvHasil.setVisibility(View.VISIBLE);
        determinan.setVisibility(View.VISIBLE);

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
