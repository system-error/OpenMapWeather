package com.example.openweathermap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DownloadTask task;
    EditText ediText;
    TextView resultTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ediText = findViewById(R.id.editText);
        resultTextView= findViewById(R.id.resultTextView);


    }

    public void getWeather(View v){

        task = new DownloadTask();
        task.execute("https://openweathermap.org/data/2.5/weather?q="+ ediText.getText().toString() +"&appid=439d4b804bc8187953eb36d2a8c26a02");

        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(ediText.getWindowToken(),0);
    }
}