package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login_button;
    EditText userNameEdt, passwordEdt;
    CreateDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_button = (Button)findViewById(R.id.idBtnLogin);

        userNameEdt = (EditText)findViewById(R.id.idEdtUsername);
        passwordEdt = (EditText)findViewById(R.id.idEdtPassword);

        db = new CreateDatabase(this);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userNameEdt.getText().toString();
                String pass = passwordEdt.getText().toString();

                if(user.equals("") || pass.equals("")){
                    Toast.makeText(LoginActivity.this, "Please enter all the username and password", Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean check = db.checkLogin(user, pass);
                    if(check){
                        Toast.makeText(LoginActivity.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}