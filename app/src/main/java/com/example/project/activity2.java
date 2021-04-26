package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class activity2 extends AppCompatActivity {
    EditText email,password;
    Button log;
    DBHelper DB;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);

        email=findViewById(R.id.LoginEmail);
        password=findViewById(R.id.LoginPassword);
        log=findViewById(R.id.LoginButton);
        DB=new DBHelper(this);

        Intent intent=getIntent();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String logemail = email.getText().toString();
                String logpassword = password.getText().toString();
                if (logemail.equals("") || logpassword.equals(""))
                    Toast.makeText(activity2.this, "Please enter both fields", Toast.LENGTH_SHORT).show();
                else {
                    Cursor res = DB.get(logemail, logpassword);

                    if (res.getCount() == 0) {
                        Toast.makeText(activity2.this, "invalid email or password", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(activity2.this, "login Successful", Toast.LENGTH_SHORT).show();
                       Intent intent=new Intent(getApplicationContext(),activity3.class);
                        startActivity(intent);

                    }
                }
            }
        });
    }
  /*  public void sign1(View view)
    {
        Intent intent=new Intent(this,activity3.class);

        startActivity(intent);
    }*/

}
