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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class EditPassword extends AppCompatActivity {

    String username;
    Button saveButton;
    EditText editUserName,editPass;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        editPass = findViewById(R.id.edit_pass);
        editUserName = findViewById(R.id.edit_userName);
        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUser();
            }
        });



    }

    private void getUser() {
        username = editUserName.getText().toString().trim();
        reference = FirebaseDatabase.getInstance().getReference("users");
        Query User = reference.orderByChild("userName").equalTo(username);
        User.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String p = snapshot.child(username).child("password").getValue(String.class);
                    update(p);
                }else{
                    editUserName.setError("User doesn't exist");
                    editUserName.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void update(String p) {

        if(isPasswordChanged(p)){
            Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
            Intent intent4 = new Intent(getApplicationContext(), appLogin.class);
            startActivity(intent4);
        }
        else{
            Toast.makeText(this, "No Changes", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isPasswordChanged(String pa) {
        if(!pa.equals(editPass.getText().toString())){
            reference.child(username).child("password").setValue(editPass.getText().toString());
            return true;
        }else{
            return false;
        }
    }

}