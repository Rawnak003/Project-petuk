package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup extends AppCompatActivity {

    EditText signupName, signupUsername, signupEmail, signupPassword,signupPhone;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signupName = findViewById(R.id.signup_name);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupPhone = findViewById(R.id.signup_phone);

        signupButton = findViewById(R.id.signup_button);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String name = signupName.getText().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();
                String phone = signupPhone.getText().toString();

                HelperClass helperClass = new HelperClass(name, email, username, password, phone);
                reference.child(username).setValue(helperClass);


                Toast.makeText(signup.this, "You have registered successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(signup.this, appLogin.class);
                startActivity(intent);
            }
        });

    }

    public void loginPage(View view) {
        startActivity(new Intent(this, appLogin.class));
    }

    public void update(View view) {
    }
}