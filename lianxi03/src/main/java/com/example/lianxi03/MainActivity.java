package com.example.lianxi03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager systemService;
    private int[] video={R.raw.a1,R.raw.a2};
    private int index=0;
    private MediaPlayer mediaPlayer;

    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        systemService = (SensorManager) getSystemService(SENSOR_SERVICE);
//        initsensor();//所有传感器
//       inituser();
//        initusera();//方向传感器
//        initlieft();//光线传感器
        initmusic();
    }

    private void initmusic() {
        mediaPlayer = MediaPlayer.create(this, video[index]);
        mediaPlayer.start();
        Sensor sensor = systemService.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        systemService.registerListener(new Lismusic(),sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public class Lismusic implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                Log.e("111","X__"+x+"Y__"+y+"z__"+z);
                if (z>12){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    index++;
                    index=index%video.length;
                    mediaPlayer=MediaPlayer.create(MainActivity.this,video[index]);
                    mediaPlayer.start();
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void initlieft() {
        Sensor sensor1 = systemService.getDefaultSensor(Sensor.TYPE_LIGHT);
        systemService.registerListener(new lieft(),sensor1,SensorManager.SENSOR_DELAY_NORMAL);
    }
    public class lieft implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType()==Sensor.TYPE_LIGHT){
                float value = event.values[0];
                Log.e("121", "onSensorChanged: value"+value );
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void initusera() {
        Sensor sensor = systemService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        systemService.registerListener(new listen1(),sensor,SensorManager.SENSOR_DELAY_NORMAL);

    }
    public class  listen1 implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            float value = event.values[0];
            Log.e("222", "onSensorChanged: value"+value );
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }

    private void inituser() {
        Sensor defaultSensor = systemService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        systemService.registerListener(new listen(),defaultSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
    private  class listen implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent event) {
            float value = event.values[0];
            Log.e("111", "onSensorChanged: value"+value );
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    }
    private void initsensor() {
        List<Sensor> list = systemService.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < list.size(); i++) {
            Sensor sensor = list.get(i);
            String name = sensor.getName();
            String vendor = sensor.getVendor();
            int version = sensor.getVersion();
            Log.e("111","名字："+name+"生产商："+vendor+"版本号："+version);
        }
    }
}
