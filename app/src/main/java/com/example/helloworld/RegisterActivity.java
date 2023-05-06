package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button reg_button, login_button;
    EditText userNameEdt, passwordEdt;
    CreateDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        reg_button = (Button)findViewById(R.id.idBtnRegister);
        login_button = (Button)findViewById(R.id.idBtnLogin);

        userNameEdt = (EditText)findViewById(R.id.idEdtUsername);
        passwordEdt = (EditText)findViewById(R.id.idEdtPassword);

        db = new CreateDatabase(this);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting data from our edit text.
                String user = userNameEdt.getText().toString();
                String pass = passwordEdt.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(RegisterActivity.this, "Please enter all the username and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean check_exist_username = db.checkUsername(user);
                    if(check_exist_username){
                        Toast.makeText(RegisterActivity.this, "Username already exists", Toast.LENGTH_SHORT).show();
                    }else{
                        Boolean check = db.insertData(user, pass);
                        if(check){
                            Toast.makeText(RegisterActivity.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(RegisterActivity.this, HomeActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(RegisterActivity.this, "Register failed!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}