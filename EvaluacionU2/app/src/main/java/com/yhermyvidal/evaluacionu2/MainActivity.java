package com.yhermyvidal.evaluacionu2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SensorEventListener {

    private Button btnAgregarSensor, btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregarSensor = (Button) findViewById(R.id.btnAgregarSensor);
        btnAgregarSensor.setOnClickListener(this);

        btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAgregarSensor:
                Intent agregarSensorIntent = new Intent(this, AgregarSensor.class);
                startActivity(agregarSensorIntent);
                break;

            case R.id.btnMap:
                Intent mapActivityIntent = new Intent(this, MapsActivity.class);
                startActivity(mapActivityIntent);
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}