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
    TextView tvTecleaN, tvtMensaje;
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
        tvtMensaje = findViewById(R.id.tvMensaje);
        bHola = findViewById(R.id.bHola);
    }

    public void onClickHOLA(View view) {
        
        rgDespedida.setVisibility(view.INVISIBLE);

        if (editTextNombre.getText()!=null && rgSraSr.isSelected()){
            RadioButton rbSelected = (RadioButton) rgSraSr.findViewById(rgSraSr.getCheckedRadioButtonId());

            if (checkBox.isSelected()){
                rgDespedida.setVisibility(view.VISIBLE);
                RadioButton rbSelectedD = rgDespedida.findViewById(rgDespedida.getCheckedRadioButtonId());
                if (rgDespedida.isSelected()) {
                    String mensaje = bHola.getText().toString() + ", " + rbSelected.getText().toString() + editTextNombre.getText().toString()+
                            "\n"+ rbSelectedD.getText().toString();
                    tvtMensaje.setText(mensaje);
                }

            }else{
                String mensaje = bHola.getText().toString()+", "+rbSelected.getText().toString()
                        + editTextNombre.getText().toString();
                tvtMensaje.setText(mensaje);
            }
        }else{
           bHola.setOnClickListener(new MiOnClickListenerErrores());
        }
    }
}