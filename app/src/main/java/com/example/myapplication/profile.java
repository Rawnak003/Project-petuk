package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class profile extends AppCompatActivity {

    TextView profileName, profileEmail, showName, profilePhone;
    ImageView back;
    Button editProfileButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.pro_name_txt);
        profileEmail = findViewById(R.id.pro_email_txt);
        profilePhone = findViewById(R.id.pro_contact_txt);
        showName = findViewById(R.id.showName);
        showAllUserData();

        back= findViewById(R.id.backButton);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void showAllUserData(){
        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String phoneUser = intent.getStringExtra("phone");
        String usernameUser = intent.getStringExtra("username");

        profileName.setText(nameUser);
        profileEmail.setText(emailUser);
        profilePhone.setText(phoneUser);
        showName.setText(nameUser);
        
    }



    public void loginPage(View view) {
        Toast.makeText(profile.this,"logged out",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, appLogin.class);
        startActivity(intent);
        finish();
    }

}