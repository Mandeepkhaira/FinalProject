package com.example.project;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.io.IOException;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;
import android.widget.Toast;


import java.lang.Class;

public class MainActivity extends AppCompatActivity {
    EditText name,email,phn,dob,qualification,pwd;
    Button rbtn,sign;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.mail);
        phn = findViewById(R.id.Phn);
        dob = findViewById(R.id.dob);
        qualification = findViewById(R.id.quali);
        pwd = findViewById(R.id.pwd);
        rbtn = findViewById(R.id.Registerbutton);
        sign=findViewById(R.id.btn2);

        DB=new DBHelper(this);


        rbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Phone = phn.getText().toString();
                String DOB = dob.getText().toString();
                String Qualification = qualification.getText().toString();
                String Password = pwd.getText().toString();
                if (Name.equals("") || Email.equals("") || Phone.equals("") || DOB.equals("") || Qualification.equals("") || Password.equals(""))
                    Toast.makeText(MainActivity.this, "please enter all the fields", Toast.LENGTH_SHORT).show();
                else {

                    Boolean check = DB.register(Name, Email, Phone, DOB, Qualification, Password);
                    if (check) {
                        Toast.makeText(MainActivity.this, "new entry inserted", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "new entry not inserted", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
    public void sign(View view){
        Intent intent=new Intent(this,activity2.class);

        startActivity(intent);
    }
}

        /*private JSONObject convertDataToJSON () throws IOException { */






