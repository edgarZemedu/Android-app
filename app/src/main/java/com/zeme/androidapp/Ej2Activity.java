package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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

        bHola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton rbSelected = (RadioButton) rgSraSr.findViewById(rgSraSr.getCheckedRadioButtonId());

                if ((!editTextNombre.getText().toString().isEmpty())  && (rgSraSr.getCheckedRadioButtonId()!=-1)){
                    //boolean cB = ((CheckBox) view).isChecked();
                    String mensaje = bHola.getText().toString()+", "+rbSelected.getText().toString()+""+ editTextNombre.getText().toString();
                    tvResultado.setText(mensaje);

                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            rgDespedida.setVisibility(view.VISIBLE);
                            if (!checkBox.isChecked()){
                                rgDespedida.setVisibility(view.INVISIBLE);
                            }
                        }
                    });
                    RadioButton rbSelectedD = rgDespedida.findViewById(rgDespedida.getCheckedRadioButtonId());
                    if (checkBox.isChecked())
                        if (rgDespedida.getCheckedRadioButtonId()!=-1) {
                            mensaje = bHola.getText().toString() + ", " + rbSelected.getText().toString() +""+ editTextNombre.getText().toString() +
                                    "\n"+rbSelectedD.getText().toString();
                            tvResultado.setText(mensaje);
                        }else{
                            Toast.makeText(view.getContext(),R.string.Error1,Toast.LENGTH_SHORT).show();
                        }
                }else{
                    Toast.makeText(view.getContext(),R.string.Error2,Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
/* Creando un botón a parte, no sé me ejecutaba la clase anónima y tube que reahacer

    public void onClickHOLA(View view) {

        //String mensaje = null;
        RadioButton rbSelected = (RadioButton) rgSraSr.findViewById(rgSraSr.getCheckedRadioButtonId());

        if ((editTextNombre.getText().toString()!=null)  && (rgSraSr.getCheckedRadioButtonId()!=-1)){ //|| (editTextNombre.getText().toString()!="")
            boolean cB = ((CheckBox) view).isChecked();
            String mensaje = bHola.getText().toString()+", "+rbSelected.getText().toString()+" "+ editTextNombre.getText().toString();
            tvResultado.setText(mensaje);

            //if (checkBox.is)
            rgDespedida.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {

                    if (!cB){
                        rgDespedida.setVisibility(view.VISIBLE);
                        RadioButton rbSelectedD = rgDespedida.findViewById(rgDespedida.getCheckedRadioButtonId());
                        //rbSelectedD.isSelected(), rgDespedida.getCheckedRadioButtonId()!=-1
                        String mensaje = bHola.getText().toString() + ", " + rbSelected.getText().toString() + editTextNombre.getText().toString()+
                                "\n"+ rbSelectedD.getText().toString();
                        tvResultado.setText(mensaje);


                    }
                }
            });

        }else{
            Toast.makeText(view.getContext(),"ERROR. Debes elegir un tratamiento o poner tu nombre.",Toast.LENGTH_SHORT).show();
        }
    }*/
}