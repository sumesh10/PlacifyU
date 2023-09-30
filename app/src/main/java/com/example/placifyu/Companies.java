package com.example.placifyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Companies extends AppCompatActivity {
    TextView t1;
    String s;
    EditText e1;
    ComDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_companies);
        e1=(EditText) findViewById(R.id.e1);
        db=new ComDB(this);



    }
    public void onAdd(View v){
        Intent i=new Intent("Add");
        startActivity(i);
    }
    public void onDelete(View v) {
        String cno = e1.getText().toString();
        if(cno.equals("")){
            Toast.makeText(this, "Please enter the id of company below", Toast.LENGTH_SHORT).show();
        }
        else{
            db.deleteCom(Integer.parseInt(cno));
        }

    }
    public void onBack(View v){
        finish();
    }
}