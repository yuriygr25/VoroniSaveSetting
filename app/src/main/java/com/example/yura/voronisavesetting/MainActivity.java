package com.example.yura.voronisavesetting;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCounter;
    private TextView mInfoTextView;

    // имя файла настройки
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        mInfoTextView = (TextView) findViewById(R.id.textViewInfo);
    }

    public void onClick(View v) {
        // Выводим на экран
        mInfoTextView.setText("Я насчитал " + ++mCounter + " ворон");
    }

    public void onClick1(View v) {
        // Выводим на экран
        onPause1();
    }

    public void onClick2(View v) {
        // Выводим на экран
        onResume1();
    }



        protected void onResume1() {
        //super.onResume();

        if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
            // Получаем число из настроек
            mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
            // Выводим на экран данные из настроек
            mInfoTextView.setText("Я насчитал "
                    + mCounter + " ворон");
        }
    }


    protected void onPause1() {
        //super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
        editor.apply();
    }
}