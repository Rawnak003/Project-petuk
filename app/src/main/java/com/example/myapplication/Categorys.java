package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class Categorys extends AppCompatActivity {
    private String[] Rname;
    TextView txtView;
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,profile,recipes,favourite,share,about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorys);
        txtView = findViewById(R.id.categoryId);
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
                String usernameUser = intent1.getStringExtra("userName");
                Intent intent = new Intent(getApplicationContext(), CategoryName.class);
                intent.putExtra("name", nameUser);
                intent.putExtra("email", emailUser);
                intent.putExtra("phone", phoneUser);
                intent.putExtra("userName", usernameUser);
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
                String usernameUser = intent1.getStringExtra("userName");
                Intent intent2 = new Intent(getApplicationContext(),profile.class);
                intent2.putExtra("name", nameUser);
                intent2.putExtra("email", emailUser);
                intent2.putExtra("phone", phoneUser);
                intent2.putExtra("userName", usernameUser);
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
        GridView gridView2 = findViewById(R.id.GridView2);
        int[] pic = new int[100];
        Intent intent2 = getIntent();
        if(intent2.getExtras() != null){
            String SelectedName = intent2.getStringExtra("Cname");
            txtView.setText(SelectedName);
            switch (Objects.requireNonNull(SelectedName)) {
                case "Biriyani":
                    Rname = getResources().getStringArray(R.array.Biriyani);
                    pic[0] = R.drawable.kacchi;
                    pic[1] = R.drawable.pakki;
                    pic[2] = R.drawable.beef;
                    pic[3] = R.drawable.mutton;
                    pic[4] = R.drawable.chicken;
                    pic[5] = R.drawable.jorda;
                    pic[6] = R.drawable.tehari;
                    pic[7] = R.drawable.morog;
                    break;
                case "Special":
                    Rname = getResources().getStringArray(R.array.Special);
                    pic[0] = R.drawable.friedrice;
                    pic[1] = R.drawable.rosogolla;
                    pic[2] = R.drawable.kacagolla;
                    pic[3] = R.drawable.kalai;
                    pic[4] = R.drawable.bogradoi;
                    pic[5] = R.drawable.khaja;
                    pic[6] = R.drawable.chui;
                    pic[7] = R.drawable.pera;
                    pic[8] = R.drawable.mezban;
                    break;
                case "Kebab":
                    Rname = getResources().getStringArray(R.array.Kebab);
                    pic[0] = R.drawable.reshmi;
                    pic[1] = R.drawable.boti;
                    pic[2] = R.drawable.shik;
                    pic[3] = R.drawable.shami;
                    pic[4] = R.drawable.jali;
                    pic[5] = R.drawable.tikka;
                    pic[6] = R.drawable.dam;
                    pic[7] = R.drawable.suti;
                    break;
                case "Pitha":
                    Rname = getResources().getStringArray(R.array.Pitha);
                    pic[0] = R.drawable.bhapa;
                    pic[1] = R.drawable.citoi;
                    pic[2] = R.drawable.dudhcitoi;
                    pic[3] = R.drawable.puli;
                    pic[4] = R.drawable.dudhpuli;
                    pic[5] = R.drawable.televaja;
                    pic[6] = R.drawable.patisapta;
                    pic[7] = R.drawable.pantua;
                    pic[8] = R.drawable.malpoa;
                    pic[9] = R.drawable.jamai;
                    break;
                case "Dessert":
                    Rname = getResources().getStringArray(R.array.Dessert);
                    pic[0] = R.drawable.rosmalai;
                    pic[1] = R.drawable.sandesh;
                    pic[2] = R.drawable.chom;
                    pic[3] = R.drawable.balish;
                    pic[4] = R.drawable.cake;
                    pic[5] = R.drawable.naru;
                    pic[6] = R.drawable.payesh;
                    pic[7] = R.drawable.semai;
                    pic[8] = R.drawable.laddu;
                    break;
                default:
                    Rname = getResources().getStringArray(R.array.Pizza);
                    pic[0] = R.drawable.margherita;
                    pic[1] = R.drawable.sousage;
                    pic[2] = R.drawable.bbq;
                    pic[3] = R.drawable.heavy;
                    pic[4] = R.drawable.cheese;
                    pic[5] = R.drawable.dual;
                    pic[6] = R.drawable.ita;
                    break;
            }
            CustomAdapter adapter = new CustomAdapter(this,Rname,pic);
            gridView2.setAdapter(adapter);
            gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String Sname = Rname[i];
                    Intent intent1 = getIntent();
                    String nameUser = intent1.getStringExtra("name");
                    String emailUser = intent1.getStringExtra("email");
                    String phoneUser = intent1.getStringExtra("phone");
                    String usernameUser = intent1.getStringExtra("userName");
                    Intent in = new Intent(getApplicationContext(), Recipes.class);
                    in.putExtra("Rname",Sname);
                    in.putExtra("name", nameUser);
                    in.putExtra("email", emailUser);
                    in.putExtra("phone", phoneUser);
                    in.putExtra("userName", usernameUser);
                    startActivity(in);
                }
            });
        }
    }
    public void open4(View view) {
        startActivity(new Intent(this, Recipes.class));
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