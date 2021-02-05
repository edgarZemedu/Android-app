package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Ej2Activity extends AppCompatActivity {
    EditText editTextNombre;
    RadioGroup rgSraSr, rgDespedida;
    TextView tvTecleaN, tvResultado;
    CheckBox checkBox;
    Button bHola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);

        editTextNombre = findViewById(R.id.editTextNombre);
        rgSraSr = findViewById(R.id.rgSraSr);
        checkBox = findViewById(R.id.checkBox);
        rgDespedida = findViewById(R.id.rgDespedida);
        tvTecleaN = findViewById(R.id.tvTecleaN);
        tvResultado = findViewById(R.id.tvResultdo);
        bHola = findViewById(R.id.bHola);

        rgDespedida.setVisibility(View.INVISIBLE);
    }

    public void onClickHOLA(View view) {
        String mensaje = null;
        RadioButton rbSelected = (RadioButton) rgSraSr.findViewById(rgSraSr.getCheckedRadioButtonId());
        if (editTextNombre.getText().toString()!="" && rbSelected.isActivated()){

            mensaje = bHola.getText().toString()+", "+rbSelected.getText().toString()+" "+ editTextNombre.getText().toString();
            tvResultado.setText(mensaje);

            if (checkBox.isSelected()){
                rgDespedida.setVisibility(view.VISIBLE);

                RadioButton rbSelectedD = rgDespedida.findViewById(rgDespedida.getCheckedRadioButtonId());
                if (rgDespedida.isSelected()) {
                    mensaje = bHola.getText().toString() + ", " + rbSelected.getText().toString() + editTextNombre.getText().toString()+
                            "\n"+ rbSelectedD.getText().toString();
                    tvResultado.setText(mensaje);
                }
            }

        }else{
            Toast.makeText(view.getContext(),"ERROR. Debes elegir un tratamiento o poner tu nombre.",Toast.LENGTH_SHORT).show();
        }
    }
}