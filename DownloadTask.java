package com.example.openweathermap;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DownloadTask extends AsyncTask<String,Void,String> {
    JsonManipulation jsonManipulation;
    Weather weather;

    @Override
    protected String doInBackground(String... urls) {
        String result = "";
        URL url;
        HttpsURLConnection connection;
        try {
            url = new URL(urls[0]);
            connection = (HttpsURLConnection) url.openConnection();
            InputStream in =connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while (data != -1){
                char current = (char) data;
                result += current;
                data = reader.read();
            }
            return result;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        jsonManipulation = new JsonManipulation(s);
        JSONArray arr = jsonManipulation.getTheWeatherResults();
        JSONObject obj = jsonManipulation.getTheTempResults();
        for (int i=0; i< arr.length(); i++){
            try {
                JSONObject jsonPart = arr.getJSONObject(i);
                weather = new Weather();
                weather.setMain(jsonPart.getString("main"));
                weather.setDescription(jsonPart.getString("description"));
                Log.i("main",jsonPart.getString("main"));
                Log.i("description",jsonPart.getString("description"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        try {
            String temperature = obj.getString("temp");
            Log.i("Temperature",temperature);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        
        Log.i("Weather Content",arr.toString());
    }
}
