package com.srinidhi.dbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class update extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
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
    }
    public void update_val(View v){
        EditText t1=(EditText)findViewById(R.id.editText10);//name gen ph dept
        EditText t2=(EditText)findViewById(R.id.editText11);
        EditText t3=(EditText)findViewById(R.id.editText12);
        EditText t4=(EditText)findViewById(R.id.editText13);
        String name,dept,gender;
        int ph;
        name=t1.getText().toString();
        gender=t2.getText().toString();
        dept=t4.getText().toString();
        ph=Integer.parseInt(t3.getText().toString());
        DatabaseHandler db= new DatabaseHandler(this);
        db.updateContact(ph,name,gender,dept);
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);

    }

}
