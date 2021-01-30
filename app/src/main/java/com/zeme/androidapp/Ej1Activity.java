package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ej1Activity extends AppCompatActivity {
    static int contador = 0;
    TextView tvContador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);

        findViewById(R.id.buttonLimpiar).setVisibility(View.INVISIBLE);
        findViewById(R.id.tvContador).setVisibility(View.INVISIBLE);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.buttonLimpiar).setVisibility(View.VISIBLE);
                findViewById(R.id.tvContador).setVisibility(View.VISIBLE);
                contador++;
                if (contador > 1)
                    tvContador.setText("Has pulsado "+Integer.toString(contador)+" veces");
                else
                    tvContador.setText("Has pulsado "+Integer.toString(contador)+" vez");
            }
        });
        findViewById(R.id.buttonLimpiar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.buttonLimpiar).setVisibility(View.INVISIBLE);
                findViewById(R.id.tvContador).setVisibility(View.INVISIBLE);
                contador = 0;
            }
        });

    }

    public void toMain(View view) {
        startActivity(new Intent(this,MainActivity.class));
    }

}