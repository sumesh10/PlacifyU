package com.example.placifyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Cgpa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

    }
    public void onMca(View v){
        Intent i=new Intent("calc");
        startActivity(i);
    }
    public void onBack(View v){
       finish();


    }
}