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
import android.widget.ListView;
import android.widget.TextView;

public class Categorys extends AppCompatActivity {

    private GridView gridView2;
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

        gridView2 = findViewById(R.id.GridView2);

        Rname = getResources().getStringArray(R.array.Pizza);
        int pic[] = {R.drawable.margherita,R.drawable.sousage,
                R.drawable.bbq,R.drawable.heavy,R.drawable.cheese,
                R.drawable.dual,R.drawable.ita};

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

        Intent intent2 = getIntent();
        if(intent2.getExtras() != null){
            String SelectedName = intent2.getStringExtra("Cname");
            txtView.setText(SelectedName);
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