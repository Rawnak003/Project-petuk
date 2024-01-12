package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Recipes extends AppCompatActivity {

    TextView txtView1;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,profile,recipes,favourite,share,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        drawerLayout = findViewById(R.id.sideNavigation);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.nav_home);
        profile = findViewById(R.id.nav_profile);
        recipes = findViewById(R.id.nav_recipe);
        favourite = findViewById(R.id.nav_fav);
        share = findViewById(R.id.nav_share);
        about = findViewById(R.id.nav_about);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();

                String nameUser = intent1.getStringExtra("name");
                String emailUser = intent1.getStringExtra("email");
                String phoneUser = intent1.getStringExtra("phone");
                String usernameUser = intent1.getStringExtra("username");

                Intent intent = new Intent(getApplicationContext(), CategoryName.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("phone", phoneUser);
                intent.putExtra("username", usernameUser);
                startActivity(intent);
                finish();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();

                String nameUser = intent1.getStringExtra("name");
                String emailUser = intent1.getStringExtra("email");
                String phoneUser = intent1.getStringExtra("phone");
                String usernameUser = intent1.getStringExtra("username");

                Intent intent2 = new Intent(getApplicationContext(),profile.class);
                intent2.putExtra("name", nameUser);
                intent2.putExtra("email", emailUser);
                intent2.putExtra("phone", phoneUser);
                intent2.putExtra("username", usernameUser);
                startActivity(intent2);
            }
        });
        recipes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        txtView1 = findViewById(R.id.dishName);
        Intent intent2 = getIntent();
        if(intent2.getExtras() != null){
            String Sname = intent2.getStringExtra("Rname");
            txtView1.setText(Sname);
        }
    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirect(Activity activity, Class sActivity){
        Intent intent = new Intent(activity,sActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}