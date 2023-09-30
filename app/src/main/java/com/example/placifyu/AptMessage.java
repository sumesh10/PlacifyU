package com.example.placifyu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class AptMessage extends AppCompatActivity {
    EditText e1,e2,e3;
    MSGdb db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aptmessage);
        e1=(findViewById(R.id.e1));
        e2=(findViewById(R.id.e2));
        e3=(findViewById(R.id.e3));
        db=new MSGdb(this);


    }
    public void onSend(View v){
        String code=e1.getText().toString();
        String date=e2.getText().toString();
        String time=e3.getText().toString();
        if(code.equals("")||date.equals("")||time.equals("")){
            Toast.makeText(this, "fill all the field", Toast.LENGTH_SHORT).show();
        }
        else {
            db.addmsg(code,date,time);
            Toast.makeText(this, "updated succesfully", Toast.LENGTH_SHORT).show();
            sendEmail();
            e1.setText("");
            e2.setText("");
            e3.setText("");
        }

    }
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain"); emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            Log.i("Finished sending email", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}