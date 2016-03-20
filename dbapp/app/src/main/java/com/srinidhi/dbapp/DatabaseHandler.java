package com.srinidhi.dbapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

/**
 * Created by HI on 2/24/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION=2;
        private static final String DATABASE_NAME="contacts_database";
        private static final String TABLE_CONTACTS="contacts";
        private static final String KEY_PHONE_NUMBER="phone_number";
        private static final String KEY_NAME="name";
        private static final String KEY_GENDER="gender";
        private static final String KEY_DEPT="dept";
        public DatabaseHandler(Context context){
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE="CREATE TABLE "+TABLE_CONTACTS +"("+KEY_PHONE_NUMBER+ " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_GENDER +" TEXT," + KEY_DEPT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    public void onCreate1(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE="CREATE TABLE "+TABLE_CONTACTS +"("+KEY_PHONE_NUMBER+ " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_GENDER +" TEXT," + KEY_DEPT + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }
    public void addContact(String name, String dept, String gender, int ph){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(KEY_PHONE_NUMBER,ph);
        values.put(KEY_NAME, name);
        values.put(KEY_GENDER, gender);
        values.put(KEY_DEPT, dept);
        db.insert(TABLE_CONTACTS, null, values);
        db.close();

    }
    public Bundle getContact(int ph)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * FROM " + TABLE_CONTACTS + " WHERE " + KEY_PHONE_NUMBER + " = " + ph;
        Cursor cursor=db.rawQuery(query,null);

        //Cursor cursor=db.query(TABLE_CONTACTS,new String[] {KEY_PHONE_NUMBER, KEY_NAME, KEY_GENDER,KEY_DEPT}, KEY_PHONE_NUMBER+"=?", new String[] {String.valueOf(ph)},null,null,null,null);
        if (cursor!=null) {
            cursor.moveToFirst();

            String name, dept, gender;
            int phone_num,valid=1;
            phone_num = Integer.parseInt(cursor.getString(0));
            name = cursor.getString(1);
            gender = cursor.getString(2);
            dept = cursor.getString(3);
            Bundle b = new Bundle();
            b.putInt("phone_number", phone_num);
            b.putString("name", name);
            b.putString("dept", dept);
            b.putString("gender", gender);
            b.putInt("valid",valid);
            return b;
        } else
        { Bundle b = new Bundle();
            int valid=-1;
            b.putInt("valid",valid);
            return b;
        }

    }
    public int updateContact(int ph,String name,String gender,String dept)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_PHONE_NUMBER, ph);
        values.put(KEY_NAME, name);
        values.put(KEY_GENDER, gender);
        values.put(KEY_DEPT, dept);
        return db.update(TABLE_CONTACTS,values,KEY_PHONE_NUMBER+ " = ?", new String[] { Integer.toString(ph)});
    }

    public void deleteContact(int ph)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_PHONE_NUMBER+ " = ?",new String[] { Integer.toString(ph)});
        db.close();
    }


}
