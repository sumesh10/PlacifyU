package com.example.placifyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Admin extends AppCompatActivity {
    TextView t1;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Intent intent=getIntent();
        t1= (TextView) findViewById(R.id.t1);
        t1.setText("Hi "+intent.getStringExtra("username").toUpperCase());
        s=intent.getStringExtra("username");
    }
    public void onchange(View v){
        Intent i=new Intent("change");

        i.putExtra("username",s);
        startActivity(i);
    }
    public void onRecruitment(View v){
        Intent i=new Intent("Comp");
        startActivity(i);

    }
    public void onCgpa(View v){
        Intent i=new Intent("msg");
        startActivity(i);
    }
    public void onLogout(View v){
        finish();
    }
}