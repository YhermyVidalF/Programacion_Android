package com.yvidal.evaluacionu1;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button boton;
    private EditText nombre;
    //private EditText

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton=(Button) findViewById(R.id.button);
        nombre=(EditText) findViewById(R.id.nombre);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),nombre.getText().toString()+ ", Pedido confirmado!",Toast.LENGTH_LONG).show();
            }
        });
    }

    }
