package com.example.tareacalificada2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private EditText et1;
    private EditText et2;
    private CheckBox n1, n2, n3, n4, n5;
    private RadioGroup asdna;
    String lenguajes = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);

        n1 = (CheckBox) findViewById(R.id.n1);
        n2 = (CheckBox) findViewById(R.id.n2);
        n3 = (CheckBox) findViewById(R.id.n3);
        n4 = (CheckBox) findViewById(R.id.n4);
        asdna = (RadioGroup) findViewById(R.id.asdna);

    }
    public void Siguiente(View view){
        Intent siguiente = new Intent(this, MainActivity2.class);

            //Vaciar String
            lenguajes = "";

            if(n1.isChecked()){
                lenguajes += "Hogar - ";
            }
            if(n2.isChecked()){
                lenguajes += "Trabajo - ";
            }
            if(n3.isChecked()){
                lenguajes += "Urbano - ";
            }
            if(n4.isChecked()){
                lenguajes += "Limite Urbano - ";
            }
            if(lenguajes.substring(lenguajes.length() - 3).equals(" - ")){
                lenguajes = lenguajes.substring(0, lenguajes.length() - 3);
            }
        //Obtener radioButton

        int id = asdna.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton) findViewById(id);

        ///--------------------------------------------------------
        siguiente.putExtra("lenguajePrincipal", rb.getText().toString());
        siguiente.putExtra("dato", et1.getText().toString());
        siguiente.putExtra("casa", et2.getText().toString());
        siguiente.putExtra("lenguajes", lenguajes);

        startActivity(siguiente);
    }
}
