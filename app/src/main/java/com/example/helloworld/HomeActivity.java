package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class HomeActivity extends AppCompatActivity {

    // creating a variable for our text view..
    private TextView userNameTV;

    Button logout_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // initializing our variables
        userNameTV = findViewById(R.id.idTVUserName);

        // getting data from intent.
        String name = getIntent().getStringExtra("UserName");

        // setting data to our text view.
        userNameTV.setText(name);

        logout_button = (Button)findViewById(R.id.idBtnLogout);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

}
