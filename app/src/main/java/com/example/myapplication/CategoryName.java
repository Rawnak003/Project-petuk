package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class CategoryName extends AppCompatActivity {

    private GridView gridView1;
    String[] Category;
    int[] dish = {R.drawable.margherita,R.drawable.burger,R.drawable.coffee,R.drawable.soup,
            R.drawable.biriyani,R.drawable.kebab,R.drawable.pasta,R.drawable.noodle,R.drawable.salad,R.drawable.dessert};

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,profile,recipes,favourite,share,about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_name);

        drawerLayout = findViewById(R.id.sideNavigation);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.nav_home);
        profile = findViewById(R.id.nav_profile);
        recipes = findViewById(R.id.nav_recipe);
        favourite = findViewById(R.id.nav_fav);
        share = findViewById(R.id.nav_share);
        about = findViewById(R.id.nav_about);

        menu.setOnClickListener(v -> openDrawer(drawerLayout));
        home.setOnClickListener(v -> {
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
        });
        profile.setOnClickListener(v -> {
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

        });
        recipes.setOnClickListener(v -> recreate());
        favourite.setOnClickListener(v -> recreate());
        share.setOnClickListener(v -> recreate());
        about.setOnClickListener(v -> recreate());

        gridView1 = (GridView) findViewById(R.id.GridView1);

        Category = getResources().getStringArray(R.array.Category);
        CustomAdapter2 adapter2 = new CustomAdapter2(this,Category,dish);
        gridView1.setAdapter(adapter2);

        gridView1.setOnItemClickListener((adapterView, view, i, l) -> {
            String SelectedName = Category[i];
            Intent intent1 = getIntent();

            String nameUser = intent1.getStringExtra("name");
            String emailUser = intent1.getStringExtra("email");
            String phoneUser = intent1.getStringExtra("phone");
            String usernameUser = intent1.getStringExtra("userName");

            Intent in = new Intent(getApplicationContext(), Categorys.class);
            in.putExtra("Cname",SelectedName);
            in.putExtra("name", nameUser);
            in.putExtra("email", emailUser);
            in.putExtra("phone", phoneUser);
            in.putExtra("userName", usernameUser);

            startActivity(in);

        });
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