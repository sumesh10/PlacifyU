package com.example.placifyu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculate extends AppCompatActivity {
    EditText e11,e12,e13,e14,e15,e16,e17;
    EditText e21,e22,e23,e24,e25,e26,e27,e28;
    EditText e31,e32,e33,e34,e35,e36,e37,e38;
    EditText e41,e42,e43,e44,e45;
    TextView sgpa1,sgpa2,sgpa3,sgpa4,cgpa;
    public float s1=0,s2=0,s3=0,s4=0,dm=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        e11=(EditText) findViewById(R.id.e11);
        e12=(EditText) findViewById(R.id.e12);
        e13=(EditText) findViewById(R.id.e13);
        e14=(EditText) findViewById(R.id.e14);
        e15=(EditText) findViewById(R.id.e15);
        e16=(EditText) findViewById(R.id.e16);
        e17=(EditText) findViewById(R.id.e17);
        sgpa1=(TextView) findViewById(R.id.sgpa1);
        e21=(EditText) findViewById(R.id.e21);
        e22=(EditText) findViewById(R.id.e22);
        e23=(EditText) findViewById(R.id.e23);
        e24=(EditText) findViewById(R.id.e24);
        e25=(EditText) findViewById(R.id.e25);
        e26=(EditText) findViewById(R.id.e26);
        e27=(EditText) findViewById(R.id.e27);
        e28=(EditText) findViewById(R.id.e28);
        sgpa2=(TextView) findViewById(R.id.sgpa2);
        e31=(EditText) findViewById(R.id.e31);
        e32=(EditText) findViewById(R.id.e32);
        e33=(EditText) findViewById(R.id.e33);
        e34=(EditText) findViewById(R.id.e34);
        e35=(EditText) findViewById(R.id.e35);
        e36=(EditText) findViewById(R.id.e36);
        e37=(EditText) findViewById(R.id.e37);
        e38=(EditText) findViewById(R.id.e38);
        sgpa3=(TextView) findViewById(R.id.sgpa3);
        e41=(EditText) findViewById(R.id.e41);
        e42=(EditText) findViewById(R.id.e42);
        e43=(EditText) findViewById(R.id.e43);
        e44=(EditText) findViewById(R.id.e44);
        e45=(EditText) findViewById(R.id.e45);
        sgpa4=(TextView) findViewById(R.id.sgpa4);
        cgpa=(TextView) findViewById(R.id.cgpa);

    }
    public void sgpaSem1(View v){
        float c1,c2,c3,c4,c5,c6,c7;
        c1=Integer.parseInt(e11.getText().toString());
        c2=Integer.parseInt(e12.getText().toString());
        c3=Integer.parseInt(e13.getText().toString());
        c4=Integer.parseInt(e14.getText().toString());
        c5=Integer.parseInt(e15.getText().toString());
        c6=Integer.parseInt(e16.getText().toString());
        c7=Integer.parseInt(e17.getText().toString());
        float sum;
        sum=(3*c1)+(3*c2)+(3*c3)+(3*c4)+(2*c5)+(3*c6)+(3*c7);
        float ci=20;
        float sgpa=sum/ci;
        sgpa1.setText("Sgpa is : "+sgpa);
        s1=sgpa;
        dm=dm+20;


    }
    public void sgpaSem2(View v){
        float c1,c2,c3,c4,c5,c6,c7,c8;
        c1=Integer.parseInt(e21.getText().toString());
        c2=Integer.parseInt(e22.getText().toString());
        c3=Integer.parseInt(e23.getText().toString());
        c4=Integer.parseInt(e24.getText().toString());
        c5=Integer.parseInt(e25.getText().toString());
        c6=Integer.parseInt(e26.getText().toString());
        c7=Integer.parseInt(e27.getText().toString());
        c8=Integer.parseInt(e28.getText().toString());
        float sum;
        sum=(3*c1)+(2*c2)+(4*c3)+(3*c4)+(3*c5)+(2*c6)+(3*c7)+(3*c8);
        float ci=23;
        float sgpa=sum/ci;
        sgpa2.setText("Sgpa is : "+sgpa);
        s2=sgpa;
        dm=dm+23;

    }

    public void sgpaSem3(View v){
        float c1,c2,c3,c4,c5,c6,c7,c8;
        c1=Integer.parseInt(e31.getText().toString());
        c2=Integer.parseInt(e32.getText().toString());
        c3=Integer.parseInt(e33.getText().toString());
        c4=Integer.parseInt(e34.getText().toString());
        c5=Integer.parseInt(e35.getText().toString());
        c6=Integer.parseInt(e36.getText().toString());
        c7=Integer.parseInt(e37.getText().toString());
        c8=Integer.parseInt(e38.getText().toString());
        float sum;
        sum=(3*c1)+(3*c2)+(3*c3)+(3*c4)+(4*c5)+(3*c6)+(2*c7)+(2*c8);
        float ci=23;
        float sgpa=sum/ci;
        sgpa3.setText("Sgpa is : "+sgpa);
        s3=sgpa;
        dm=dm+23;

    }
    public void sgpaSem4(View v){
        float c1,c2,c3,c4,c5;
        c1=Integer.parseInt(e41.getText().toString());
        c2=Integer.parseInt(e42.getText().toString());
        c3=Integer.parseInt(e43.getText().toString());
        c4=Integer.parseInt(e44.getText().toString());
        c5=Integer.parseInt(e45.getText().toString());
        float sum;
        sum=(3*c1)+(4*c2)+(2*c3)+(3*c4)+(12*c5);
        float ci=24;
        float sgpa=sum/ci;
        sgpa4.setText("Sgpa is : "+sgpa);
        s4=sgpa;
        dm=dm+24;

    }

    public void getCgpa(View v){
        float sum,fcgpa;
        sum=(20*s1)+(23*s2)+(23*s3)+(24*s4);
        fcgpa=sum/dm;
        cgpa.setText("CGPA is :"+fcgpa);
    }

}