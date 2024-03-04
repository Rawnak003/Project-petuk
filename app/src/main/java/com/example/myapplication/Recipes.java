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
    TextView txtView1,ingredient,procedure;
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
        ingredient = findViewById(R.id.IngredientTextId);
        procedure = findViewById(R.id.procedureTextId);
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
        txtView1 = findViewById(R.id.dishName);
        Intent intent2 = getIntent();
        if(intent2.getExtras() != null){
            String Sname = intent2.getStringExtra("Rname");
            txtView1.setText(Sname);
            if(Sname.equals("Kacchi Biriyani")){
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Pakki Biriyani")){
                ingredient.setText(R.string.pakkiIng);
                procedure.setText(R.string.pakkiPro);
            }else if(Sname.equals("Beef/Kalyani Biriyani")){
                ingredient.setText(R.string.beefIng);
                procedure.setText(R.string.beefPro);
            }else if(Sname.equals("Mutton Biriyani")){
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Chicken Biriyani")){
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Jorda Biriyani")){
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Beef Tehari")){
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Morog Polao")){
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Fried Rice")){
                ingredient.setText(R.string.friedRiceIng);
                procedure.setText(R.string.friedRicePro);
            }else if(Sname.equals("Roshogolla")){
                ingredient.setText(R.string.rosogollaIng);
                procedure.setText(R.string.rosogollaPro);
            }else if(Sname.equals("Kachagolla")){
                ingredient.setText(R.string.kachagollaIng);
                procedure.setText(R.string.kachagollaPro);
            }else if(Sname.equals("Kalai Ruti")){
                ingredient.setText(R.string.kalaiIng);
                procedure.setText(R.string.kalaiPro);
            }else if(Sname.equals("Bogurar Doi")){
                ingredient.setText(R.string.doiIng);
                procedure.setText(R.string.doiPro);
            }else if(Sname.equals("Tiler Khawja")){
                ingredient.setText(R.string.tilerIng);
                procedure.setText(R.string.tilerPro);
            }else if(Sname.equals("Beef-chui")){
                ingredient.setText(R.string.chuiIng);
                procedure.setText(R.string.chuiPro);
            }else if(Sname.equals("Pero Sandesh")){
                ingredient.setText(R.string.peraIng);
                procedure.setText(R.string.peraPro);
            }else if(Sname.equals("Mezban")){
                ingredient.setText(R.string.mezbanIng);
                procedure.setText(R.string.mezbanPro);
            }else if(Sname.equals("Bhapa Pitha")){
                ingredient.setText(R.string.BhapaIng);
                procedure.setText(R.string.BhapaPro);
            }else if(Sname.equals("Citoi Pitha")){
                ingredient.setText(R.string.citoiIn);
                procedure.setText(R.string.citoiPro);
            }else if(Sname.equals("Dudh-citoi Pitha")){
                ingredient.setText(R.string.dudhCitoiIn);
                procedure.setText(R.string.dudhCitoiPro);
            }else if(Sname.equals("Puli Pitha")){
                ingredient.setText(R.string.puliIn);
                procedure.setText(R.string.puliPro);
            }else if(Sname.equals("Dudh-puli Pitha")){
                ingredient.setText(R.string.puliIn);
                procedure.setText(R.string.puliPro);
            }else if(Sname.equals("Telebhaja Pitha")){
                ingredient.setText(R.string.puliIn);
                procedure.setText(R.string.puliPro);
            }else if(Sname.equals("Patishapta")) {
                ingredient.setText(R.string.patisaptaIn);
                procedure.setText(R.string.patisaptaPro);
            }else if(Sname.equals("Pantua")) {
                ingredient.setText(R.string.patisaptaIn);
                procedure.setText(R.string.patisaptaPro);
            }else if(Sname.equals("Malpoa")) {
                ingredient.setText(R.string.patisaptaIn);
                procedure.setText(R.string.patisaptaPro);
            }else if(Sname.equals("Jamai Pitha")) {
                ingredient.setText(R.string.patisaptaIn);
                procedure.setText(R.string.patisaptaPro);
            }else if(Sname.equals("Reshmi Kebab")) {
                ingredient.setText(R.string.reshmiIn);
                procedure.setText(R.string.reshmiPro);
            }else if(Sname.equals("Boti Kebab")) {
                ingredient.setText(R.string.botiIn);
                procedure.setText(R.string.botiPro);
            }else if(Sname.equals("Shik Kebab")) {
                ingredient.setText(R.string.botiIn);
                procedure.setText(R.string.botiPro);
            }else if(Sname.equals("Shami Kebab")) {
                ingredient.setText(R.string.shamiIn);
                procedure.setText(R.string.shamiPro);
            }else if(Sname.equals("Jali Kebab")) {
                ingredient.setText(R.string.shamiIn);
                procedure.setText(R.string.shamiPro);
            }else if(Sname.equals("Tikka Kebab")) {
                ingredient.setText(R.string.reshmiIn);
                procedure.setText(R.string.reshmiPro);
            }else if(Sname.equals("Dam Kebab")) {
                ingredient.setText(R.string.reshmiIn);
                procedure.setText(R.string.reshmiPro);
            }else if(Sname.equals("Shuti Kebab")) {
                ingredient.setText(R.string.shamiIn);
                procedure.setText(R.string.shamiPro);
            }else if(Sname.equals("Roshomalai")) {
                ingredient.setText(R.string.rasmalaiIn);
                procedure.setText(R.string.rasmalaiPro);
            }else if(Sname.equals("Shandesh")) {
                ingredient.setText(R.string.peraIng);
                procedure.setText(R.string.peraPro);
            }else if(Sname.equals("Chom chom")) {
                ingredient.setText(R.string.chomIn);
                procedure.setText(R.string.chomPro);
            }else if(Sname.equals("Balish Misti")) {
                ingredient.setText(R.string.balishIn);
                procedure.setText(R.string.balishPro);
            }else if(Sname.equals("Cake")) {
                ingredient.setText(R.string.cakeIn);
                procedure.setText(R.string.cakePro);
            }else if(Sname.equals("Naru")) {
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Payesh")) {
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Semai")) {
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Laddu")) {
                ingredient.setText(R.string.kacchiList);
                procedure.setText(R.string.kacchiPro);
            }else if(Sname.equals("Margherita Pizza")) {
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }else if(Sname.equals("Sausage Blast Pizza")) {
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }else if(Sname.equals("Exotic BBQ Pizza")) {
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }else if(Sname.equals("Heavy Meat Pizza")) {
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }else if(Sname.equals("Cheese Shower Pizza")) {
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }else if(Sname.equals("Dual Cake Pizza")) {
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }else if(Sname.equals("Italian Pizza")) {
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }else{
                ingredient.setText(R.string.listPizza);
                procedure.setText(R.string.proPizza);
            }
        }
    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout) {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);}
    }
    public static void redirect(Activity activity, Class sActivity){
        Intent intent = new Intent(activity,sActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);}
    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);}
}