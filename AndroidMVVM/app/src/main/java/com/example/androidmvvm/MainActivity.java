package com.example.androidmvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
/**
 * Created by Satish on 09/06/2020.
 */
public class MainActivity extends AppCompatActivity  {

    public static boolean ISOFFLINE = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}