package com.srinidhi.dbapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void create(View v){

        EditText t=(EditText)findViewById(R.id.editText);
        t.setText("Created");
        //DatabaseHandler db = new DatabaseHandler(this);



    }
    public void insert(View v)
    {
        Intent intent= new Intent(this, insert.class);
        //DatabaseHandler db = new DatabaseHandler(this);
        //Bundle b= new Bundle();
        //intent.putExtra("database",);
        startActivity(intent);

    }
    public void retrieve(View v)
    {
        EditText t=(EditText)findViewById(R.id.editText9);
        String phn=t.getText().toString();
        int ph= Integer.parseInt(phn);

        Bundle data=db.getContact(ph);
        if (data.getInt("valid")==1){
        Intent intent = new Intent(this,retrieve.class);
        intent.putExtra("bundle",data);
        startActivity(intent);}
        else t.setText("Invalid");

    }
    public void update(View v){
        Intent intent=new Intent(this,update.class);
        startActivity(intent);
    }
    public void delete(View v)
    {
        EditText t=(EditText)findViewById(R.id.editText9);
        String phn=t.getText().toString();
        int ph= Integer.parseInt(phn);
        db.deleteContact(ph);

    }
}
