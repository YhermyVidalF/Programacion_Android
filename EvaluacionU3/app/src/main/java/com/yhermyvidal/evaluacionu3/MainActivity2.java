package com.yhermyvidal.evaluacionu3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity2 extends AppCompatActivity {
    private TextView tt2, tt3, tt5, tt6, tt7, tt1;
    private Button btn1,btn2;
    private DatabaseReference database;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tt1 = (TextView) findViewById(R.id.txt10);
        tt2 = (TextView) findViewById(R.id.txt2);
        tt3 = (TextView) findViewById(R.id.txt3);
        tt5 = (TextView) findViewById(R.id.txt5);
        tt6 = (TextView) findViewById(R.id.txt6);
        tt7 = (TextView) findViewById(R.id.txt9);
        btn1 = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.editbtn);
        edit = (EditText) findViewById(R.id.ed);

        database = FirebaseDatabase.getInstance().getReference();

        database.child("Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String nombre = dataSnapshot.child("Nombre del sensor").getValue().toString(); //variable para imprimir datos de nombre
                    tt7.setText("Nombre: " + nombre);

                    String Val = dataSnapshot.child("Valor").getValue().toString(); //variable del Valor de sensor
                    tt1.setText("Valor: " + Val);

                    String Fecha = dataSnapshot.child("Fecha y Hora").getValue().toString(); //Variable de tiempo
                    tt2.setText("Fecha y Hora: " + Fecha);

                    String tipoo = dataSnapshot.child("Tipo").getValue().toString(); //variable del tipo de sensor
                    tt3.setText("Tipo: " + tipoo);

                    String ubi = dataSnapshot.child("Ubicación").getValue().toString(); //variable de ubicacion de sensor
                    tt5.setText("Ubicación: " + ubi);

                    String obs = dataSnapshot.child("Observación").getValue().toString(); //variable de Observación de sensor
                    tt6.setText(obs);

                    btn1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                            startActivity(intent); //Funcion para regresar al menu principal
                        }
                    });

                    btn2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String Observacion = tt6.getText().toString();
                            tt6.setText(edit.getText().toString());
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

