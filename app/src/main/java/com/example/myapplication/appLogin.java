package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class appLogin extends AppCompatActivity {
    TextView forPass;
    EditText loginUsername, loginPassword;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applogin);
        forPass = findViewById(R.id.forget_password);
        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(view -> {
            if (!validateUsername() | !validatePassword()) {
                return;
            } else {
                checkUser();
            }
        });
        forPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EditPassword.class));
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
        final String userUsername = loginUsername.getText().toString().trim();
        String userPassword = loginPassword.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query User = reference.orderByChild("userName").equalTo(userUsername);
        User.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if(passwordFromDB.equals(userPassword)){
                        loginPassword.setError(null);
                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("userName").getValue(String.class);
                        String phoneFromDB = snapshot.child(userUsername).child("phone").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        Intent intent = new Intent(getApplicationContext(), CategoryName.class);
                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("userName",usernameFromDB);
                        intent.putExtra("phone",phoneFromDB);
                        intent.putExtra("email",emailFromDB);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Logged In",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        loginPassword.setError("Wrong password");
                        loginPassword.requestFocus();
                    }
                }else{
                    loginUsername.setError("User doesn't exist");
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