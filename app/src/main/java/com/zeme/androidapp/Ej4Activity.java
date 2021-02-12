package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Ej4Activity extends AppCompatActivity {

    static String MENSAJE;
    EditText editTextNombre;
    RadioGroup rgSraSr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);

        editTextNombre = findViewById(R.id.editTextNombre);
        rgSraSr = findViewById(R.id.rgSraSr);

        Button bHola = findViewById(R.id.bHola);
        bHola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((!editTextNombre.getText().toString().isEmpty()) && (rgSraSr.getCheckedRadioButtonId()!=-1)){

                    Intent intent = new Intent(Ej4Activity.this,Ej4_2Activity.class);
                    //capturar lo que haya seleccionado del radioButton
                    RadioButton rbSelectedId = rgSraSr.findViewById(rgSraSr.getCheckedRadioButtonId());
                    String mensajeSaludo = rbSelectedId.getText().toString()+" "+editTextNombre.getText().toString();
                    String nombres = editTextNombre.getText().toString();
                    //Añadimos al intent la opción que se haya seleccionado con su nombre
                    intent.putExtra(MENSAJE, mensajeSaludo);
                    intent.putExtra("nombre",nombres);
                    startActivity(intent);
                }else{
                    Toast.makeText(view.getContext(),"ERROR. Debes elegir un tratamiento o poner tu nombre.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}