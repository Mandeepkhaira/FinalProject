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
        db.execSQL("create table User(name Text ,email Text primary key,phn number,dob text,qualification Text,pwd Text)");
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
    public Cursor get(String email,String pwd){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from User where email=? and pwd=?", new String[] {email,pwd});
        return cursor;

    }

    Cursor readAll()
    {
        String query="select * from  User";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null)
        {
            cursor=db.rawQuery(query,null);
        }
        return cursor;

    }
    public boolean updateuserdata(String name,String email,String phone,String dob,String qualification,String password)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValue=new ContentValues();
        contentValue.put("name",name);
        contentValue.put("email",email);
        contentValue.put("qualification",qualification);
        contentValue.put("password",password);
        contentValue.put("dob",dob);
        Cursor cursor=DB.rawQuery("select * from User where email=?",new String[]{email});
        if(cursor.getCount()>0) {
            long result = DB.update("User", contentValue, "email=?", new String[]{email});


            return result != -1;
        }
        return false;
    }




}

