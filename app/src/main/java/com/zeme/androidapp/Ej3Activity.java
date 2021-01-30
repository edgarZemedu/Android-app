package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Ej3Activity extends AppCompatActivity {
    Button bCambiar;
    RadioGroup rgMoneda;
    EditText editTextValor;
    TextView tvMensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3);

        bCambiar = findViewById(R.id.bCambiar);
        rgMoneda = findViewById(R.id.rgMoneda);
        editTextValor = findViewById(R.id.editTextValor);
        tvMensaje = findViewById(R.id.tvMensaje);

    }
    public void cambiarMoneda(View view){
        bCambiar.setOnClickListener(view1 -> {
            double valor = (double) Double.parseDouble(editTextValor.getText().toString());

            if (rgMoneda.isSelected() && editTextValor.getText().toString()!="") {
                RadioButton rbSelectedD = (RadioButton) rgMoneda.findViewById(rgMoneda.getCheckedRadioButtonId());

                if (rbSelectedD.equals("Pts. a Euros")){
                    String mensajeSalida = editTextValor.getText().toString() + " pesetas equivalen a " +
                            String.valueOf(obtener2Decimales(deEurosAPeseta(valor))+ " Euros.");
                    tvMensaje.setText(mensajeSalida);

                } else{
                    String mensajeSalida = editTextValor.getText().toString() + " euros equivalen a " +
                            String.valueOf(obtener2Decimales(dePesetaAEuros(valor))+ " Pesetas.");
                    tvMensaje.setText(mensajeSalida);
                }
            }else{
                Toast.makeText(this, "Error.Debes poner un valor numérico", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //método para pasar de pesetas a euros
    public double dePesetaAEuros(double valor){
        double x = valor * 0.006;
        return x;
    }
    //método para pasar de euros a peseta
    public double deEurosAPeseta(double valor){
        double x = valor *166.386;
        return x;
    }

    //metodo para limitar los decimales
    public String obtener2Decimales(double valor){
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        return df.format(valor);
    }

}