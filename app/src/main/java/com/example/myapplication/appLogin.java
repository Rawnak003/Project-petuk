package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class appLogin extends AppCompatActivity {

    EditText loginUsername, loginPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applogin);

        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> {
            if (!validateUsername() | !validatePassword()) {
            } else {
                checkUser();
            }
        });
    }
    public Boolean validateUsername() {
        String val = loginUsername.getText().toString();
        if (val.isEmpty()) {
            loginUsername.setError("Username cannot be empty");
            return false;
        } else {
            loginUsername.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = loginPassword.getText().toString();
        if (val.isEmpty()) {
            loginPassword.setError("Password cannot be empty");
            return false;
        } else {
            loginPassword.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild(userUsername)) {
                    loginUsername.setError(null);

                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);

                    if (Objects.equals(passwordFromDB, userPassword)) {
                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                        String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);

                        Intent intent = new Intent(appLogin.this, CategoryName.class);

                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("phone", phoneFromDB);
                        intent.putExtra("username", usernameFromDB);
                        startActivity(intent);
                        Toast.makeText(appLogin.this,"Login successful",Toast.LENGTH_SHORT).show();
                        finish();

                    } else {
                        loginPassword.setError("Invalid Password");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void registerPage(View view) {
        startActivity(new Intent(this, signup.class));
    }
}