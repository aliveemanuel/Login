package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    private EditText username,password,confirm_password;
    Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username= (EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        confirm_password=(EditText) findViewById(R.id.confirm_password);
        register=(Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username != null && password != null && confirm_password != null) {
                    if(password == confirm_password){

                    }else{
                        Toast.makeText(Register.this, "Password and Confirmed password don't match", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(Register.this, "All field must be filled", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}