package com.zeme.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void toActivity1(View view){
        startActivity(new Intent(this,Ej1Activity.class));
    }

    public void toActivity2(View view) {
        startActivity(new Intent(this,Ej2Activity.class));
    }

    public void toActivity3(View view) {
        startActivity(new Intent(this,Ej3Activity.class));
    }

    public void toActivity4(View view) {
        startActivity(new Intent(this,Ej4Activity.class));
    }
}