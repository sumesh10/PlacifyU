package com.example.placifyu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Recruitment extends AppCompatActivity {
    TextView tv;
    ComDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruitment);
        tv=(TextView) findViewById(R.id.tv);
        db=new ComDB(this);
        List<Cname> rec=db.getAllvalues();
        String str="";
        for(Cname cr:rec){
            String log="Slno: "+cr.id+"\n JD: "+cr.jd+"\n Comapny Namne: "+cr.cname+"\n Excel link:"+cr.link+"\n Criteria:\n"+cr.crit+"\n";
            log=log+"\n";
            str=str+log;

        }
        TextView t=(TextView) findViewById(R.id.tv);
        t.setText(str);



    }
    public void onBack(View v){
        finish();
    }

}