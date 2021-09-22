package com.example.tareacalificada2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView) findViewById(R.id.tv1);
        String dato = getIntent().getStringExtra("dato");
        String casa = getIntent().getStringExtra("casa");
        tv1.setText(dato + "  " + casa);

        tv2 = (TextView) findViewById(R.id.tv2);
        String lenguajes = getIntent().getStringExtra("lenguajes");
        tv2.setText(lenguajes);

        tv3 = (TextView) findViewById(R.id.tv3);
        String lenguajePrincipal = getIntent().getStringExtra("lenguajePrincipal");
        tv3.setText(lenguajePrincipal);
    }
    //metodo boton regresar
    public void Atras(View view){
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }
}