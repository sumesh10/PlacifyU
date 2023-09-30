package com.example.placifyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Adding extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    String s;
    ComDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);
        e1=(EditText) findViewById(R.id.e1);
        e2=(EditText) findViewById(R.id.e2);
        e3=(EditText) findViewById(R.id.e3);
        e4=(EditText) findViewById(R.id.e4);
        db=new ComDB(this);
    }
    public void onAdd(View v){
        String jd,cmp,link,cri;
        jd=e1.getText().toString();
        cmp=e2.getText().toString();
        link=e3.getText().toString();
        cri=e4.getText().toString();
        if(jd.equals("")||cmp.equals("")||link.equals("")||cri.equals("")){
            Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show();
        }
        else{
            Cname rec=new Cname();
            rec.jd=e1.getText().toString();
            rec.cname=e2.getText().toString();
            rec.link=e3.getText().toString();
            rec.crit=e4.getText().toString();
            db.addCompany(rec);
            e1.setText("");
            e2.setText("");
            e3.setText("");
            e4.setText("");
            Toast.makeText(this, "Company added successfully", Toast.LENGTH_SHORT).show();
        }


    }
    public void onBack(View v){
        finish();
    }
}