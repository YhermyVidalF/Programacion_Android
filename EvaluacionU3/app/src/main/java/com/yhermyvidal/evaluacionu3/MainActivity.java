package com.yhermyvidal.evaluacionu3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView txtbe;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtbe = (TextView) findViewById(R.id.txt1);

        database = FirebaseDatabase.getInstance().getReference();

        database.child("Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    String Val = dataSnapshot.child("Valor").getValue().toString(); //variable del Valor de sensor
                    String nombre = dataSnapshot.child("Nombre del sensor").getValue().toString(); //variable para imprimir datos de nombre
                    txtbe.setText("Nombre: " + nombre + "   Valor: " + Val);

                    txtbe.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (MainActivity.this,MainActivity2.class);
                            startActivity(intent);  //Funcion para desplegar segunda ventana y poder ver mas detallado los sensores
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
