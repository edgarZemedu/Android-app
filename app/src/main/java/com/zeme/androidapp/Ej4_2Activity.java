package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        //visualizar saludo
        tvPersona.setText(getIntent().getStringExtra(MENSAJE));
        rgDespedida.setVisibility(View.INVISIBLE);

        cbDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //visualizamos el tipo de despedida
                rgDespedida.setVisibility(View.VISIBLE);

                Button bVolver = findViewById(R.id.bVolver);
                bVolver.setOnClickListener(view -> {
                    if (rgDespedida.getCheckedRadioButtonId()!=-1){

                        RadioButton rbSelectedID = rgDespedida.findViewById(rgDespedida.getCheckedRadioButtonId());
                        String mensajeToast = rbSelectedID.getText().toString()+", "+getIntent().getStringExtra("nombre");

                        Toast.makeText(view.getContext(),mensajeToast,Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(Ej4_2Activity.this,Ej4Activity.class);
                        i.putExtra("toast",mensajeToast);
                        startActivity(i);

                    }else{
                        Toast.makeText(view.getContext(),"ERROR. Debes elegir un tratamiento de despedida",Toast.LENGTH_SHORT).show();
                    }
                    /////////
                    Intent intent = new Intent(Ej4_2Activity.this,Ej4Activity.class);
                    startActivity(intent);

                });
            }
        });

    }

}