package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static com.zeme.androidapp.Ej4Activity.MENSAJE;

public class Ej4_2Activity extends AppCompatActivity {

    TextView tvPersona;
    CheckBox cbDespedida;
    RadioGroup rgDespedida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4_2);

        tvPersona = findViewById(R.id.tvPersona);
        cbDespedida = findViewById(R.id.cbDespedida);
        rgDespedida = findViewById(R.id.rgDespedida);

        tvPersona.setText(getIntent().getStringExtra(MENSAJE));

        Button bVolver = findViewById(R.id.bVolver);
        bVolver.setOnClickListener(view -> {
            if (cbDespedida.isSelected()){
                onClickDespedida(view);
                if (rgDespedida.isSelected()){
                    RadioButton rbSelectedID = rgDespedida.findViewById(rgDespedida.getCheckedRadioButtonId());
                    String mensajeToast = rbSelectedID.getText().toString()+", ";

                    Intent i = new Intent(Ej4_2Activity.this,Ej4Activity.class);
                    i.putExtra("toast",mensajeToast);
                    startActivity(i);

                }else{
                    new MiOnClickListenerErrores();
                }
            }else{
                Intent intent = new Intent(Ej4_2Activity.this,Ej4Activity.class);
                startActivity(intent);
            }
        });

    }

    public void onClickDespedida(View view) {
        if (cbDespedida.isSelected())
            rgDespedida.setVisibility(view.VISIBLE);
        else
            rgDespedida.setVisibility(view.INVISIBLE);

    }
}