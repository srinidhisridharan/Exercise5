package com.srinidhi.dbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class insert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
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
    public void insert_val(View v){
        EditText name = (EditText)findViewById(R.id.editText);
        EditText ph = (EditText)findViewById(R.id.editText2);
        EditText gender = (EditText)findViewById(R.id.editText3);
        EditText dept = (EditText)findViewById(R.id.editText4);

        DatabaseHandler db=new DatabaseHandler(this);
        db.addContact(name.getText().toString(),dept.getText().toString(),gender.getText().toString(),Integer.parseInt(ph.getText().toString()));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

}
