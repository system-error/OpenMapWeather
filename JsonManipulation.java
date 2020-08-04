package com.example.openweathermap;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonManipulation {

    private String informationFromJson;
    private JSONObject jsonObject;
//    private ArrayList<JSONArray> dataFromWeatherMap;

    public JsonManipulation(String response){
        informationFromJson = response;
    }

    public JSONArray getTheWeatherResults(){
        try {
            jsonObject = new JSONObject(informationFromJson);
            Log.i("JSONOBJECT:::::::::", jsonObject.toString());
            String weatherInfo = jsonObject.getString("weather");
            JSONArray arrWeatherInfo = new JSONArray(weatherInfo);
            return arrWeatherInfo;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public JSONObject getTheTempResults(){
        try {
            jsonObject = new JSONObject(informationFromJson);
            Log.i("JSONOBJECT:::::::::", jsonObject.toString());
            String mainInfo = jsonObject.getString("main");
            JSONObject jsonObjectMainInfo = new JSONObject(mainInfo);
            return jsonObjectMainInfo;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
