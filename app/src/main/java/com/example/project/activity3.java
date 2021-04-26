package com.example.project;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class activity3 extends AppCompatActivity {
    RecyclerView recyclerview;
    DBHelper DB;
    ArrayList<String>  name , email, phn, dob, qualification;
    customAdapter customadapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);
        recyclerview=findViewById(R.id.list);

       Intent intent = getIntent();


        DB=new DBHelper(activity3.this);
        name=new ArrayList<>();
        email=new ArrayList<>();
        phn=new ArrayList<>();
        dob=new ArrayList<>();
        qualification=new ArrayList<>();
        display();
        customadapter=new customAdapter(activity3.this,name,email,phn,dob,qualification);
        recyclerview.setAdapter(customadapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(activity3.this));

        Intent intent1=new Intent(activity3.this,activity4.class);
        startActivity(intent1);

    }
    void display(){
        Cursor cursor=DB.readAll();
        if(cursor.getCount()==0)
        {
            Toast.makeText(this,"no data to show",Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                email.add(cursor.getString(1));
                phn.add(cursor.getString(2));
                dob.add(cursor.getString(3));
                qualification.add(cursor.getString(4));
            }
        }
    }


}
