package com.zeme.androidapp;

import android.view.View;
import android.widget.Toast;

public class MiOnClickListenerErrores implements View.OnClickListener {

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(),"ERROR. Debes elegir un tratamiento.",Toast.LENGTH_SHORT).show();
    }
   public void onClickEj3(View view){
        Toast.makeText(view.getContext(),"ERROR. Debes poner un valor numérico",Toast.LENGTH_SHORT).show();
    }
}
