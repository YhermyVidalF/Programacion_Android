package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int nClics=0;
    private TextView txtShowClics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtShowClics =(TextView) findViewById(R.id.txt_show_view);
        txtShowClics.setText(Integer.toString(nClics));
        }

        public void mostrarTostada(View view){
            Toast.makeText(this,"Demostración de una tostada", Toast.LENGTH_SHORT).show();
        }

        public void contarClics(View view){
             nClics++;
             txtShowClics.setText(Integer.toString(nClics));
        }

        public void menosClics( View view){
              nClics--;
              txtShowClics.setText(Integer.toString(nClics));
        }
        public void resetClics(View view){
              nClics=0;
              txtShowClics.setText(Integer.toString(nClics));
        }
    }
