package com.example.readsensordata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mSensorLight;
    private Sensor mSensorProximity;
    private Sensor mSensorAmbience;
    private Sensor mSensorPressure;
    private Sensor mSensorHumidity;

    private TextView mTextSensorLight;
    private TextView mTextSensorProximity;
    private TextView mTextSensorAmbience;
    private TextView mTextSensorPressure;
    private TextView mTextSensorHumidity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
//        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
//        StringBuilder sensorText = new StringBuilder();
//        for (Sensor currentSensor : sensorList) {
//            sensorText.append(currentSensor.getName())
//                    .append(System.getProperty("line.separator"));
//        }
//
//        TextView sensorTextView = findViewById(R.id.sensor_list) ;
//        sensorTextView.setText(sensorText);


        mTextSensorLight = findViewById(R.id.label_light);
        mTextSensorProximity = findViewById(R.id.label_proximity);
        mTextSensorAmbience = findViewById(R.id.label_temperature);
        mTextSensorPressure = findViewById(R.id.label_pressure);
        mTextSensorHumidity = findViewById(R.id.label_humidity);

        mSensorLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mSensorProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        mSensorAmbience = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mSensorPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mSensorHumidity = mSensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        String sensor_error = "No Sensor";

        if (mSensorLight == null) {
            mTextSensorLight.setText(sensor_error);
        }
        if (mSensorProximity == null) {
            mTextSensorProximity.setText(sensor_error);
        }
        if (mSensorAmbience == null) {
            mTextSensorAmbience.setText(sensor_error);
        }
        if (mSensorPressure == null) {
            mTextSensorPressure.setText(sensor_error);
        }
        if (mSensorHumidity == null) {
            mTextSensorHumidity.setText(sensor_error);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mSensorProximity != null) {
            mSensorManager.registerListener(this, mSensorProximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorLight != null) {
            mSensorManager.registerListener(this, mSensorLight,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorAmbience != null) {
            mSensorManager.registerListener(this, mSensorAmbience,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorPressure != null) {
            mSensorManager.registerListener(this, mSensorPressure,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (mSensorHumidity != null) {
            mSensorManager.registerListener(this, mSensorHumidity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType = sensorEvent.sensor.getType();
        float currentValue = sensorEvent.values[0];

        switch (sensorType) {
            case Sensor.TYPE_LIGHT:
                mTextSensorLight.setText(
                        String.format("Light sensor : %1$.2f", currentValue)
                );
                changeBackgroundColor(currentValue);
                break;

            case Sensor.TYPE_PROXIMITY:
                mTextSensorProximity.setText(
                        String.format("Proximity sensor : %1$.2f", currentValue)
                );
                break;

            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                mTextSensorAmbience.setText(
                        String.format("Ambience sensor : %1$.2f", currentValue)
                );
                break;

            case Sensor.TYPE_PRESSURE:
                mTextSensorPressure.setText(
                        String.format("Pressure sensor : %1$.2f", currentValue)
                );
                break;

            case Sensor.TYPE_RELATIVE_HUMIDITY:
                mTextSensorHumidity.setText(
                        String.format("Humidity sensor : %1$.2f", currentValue)
                );
                break;
        }
    }

    private void changeBackgroundColor (float currentValue) {
        ConstraintLayout layout = findViewById(R.id.layout_constraint);
        if (currentValue >= 4000) layout.setBackgroundColor(Color.WHITE);
        else if (currentValue < 4000 && currentValue >= 0) layout.setBackgroundColor(Color.BLACK);
        }


    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}