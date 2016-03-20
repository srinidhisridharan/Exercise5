package com.srinidhi.dbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class retrieve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent=getIntent();
        Bundle b=intent.getBundleExtra("bundle");
        EditText t1=(EditText)findViewById(R.id.editText5);
        EditText t2 =(EditText)findViewById(R.id.editText6);
        EditText t3 =(EditText)findViewById(R.id.editText7);
        EditText t4 =(EditText)findViewById(R.id.editText8);
        String n,g,d;
        int valid=b.getInt("valid");
        if (valid==1){
        n=b.getString("name");
        g=b.getString("gender");
        d=b.getString("dept");
        int p=b.getInt("phone_number");
        t1.setText(String.valueOf(p));
        t2.setText(n);
        t3.setText(g);
        t4.setText(d);}
        else t1.setText("INVALID");




    }

    public void back(View v){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}

