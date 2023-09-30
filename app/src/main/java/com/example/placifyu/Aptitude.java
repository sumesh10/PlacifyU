package com.example.placifyu;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Aptitude extends AppCompatActivity {
    TextView tv;
    MSGdb db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptitude);
        tv=(TextView) findViewById(R.id.tv);
        db=new MSGdb(this);
        List<MSG> rec=db.getAllvalues();
        String str="";
        for(MSG cr:rec){
            String log="Exam Code: "+cr.code+"\n Date: "+cr.date+"\n Excel link:"+cr.time+"\n";
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