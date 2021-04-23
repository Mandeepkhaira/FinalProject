package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context,"User.db", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table User(name Text ,email Text primary key,phn Text,dob text,qualification Text,pwd Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists User");
    }
    public boolean register(String name,String email,String phn,String dob,String qualification,String pwd){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValue=new ContentValues();
        contentValue.put("name",name);
        contentValue.put("email",email);
        contentValue.put("phn",phn);
        contentValue.put("dob",dob);
        contentValue.put("qualification",qualification);
        contentValue.put("pwd",pwd);
        long result=DB.insert("User",null,contentValue);
        return result!=-1;
    }

}
