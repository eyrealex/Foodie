package com.alexeyre.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    //variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //tool bar
        setSupportActionBar(toolbar);

        //nav drawer
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        //get all buttons for different activities
        findViewById(R.id.layoutChinese).setOnClickListener(this);
        findViewById(R.id.layoutIndian).setOnClickListener(this);
        findViewById(R.id.layoutItalian).setOnClickListener(this);
        findViewById(R.id.layoutAmerican).setOnClickListener(this);
        findViewById(R.id.layoutMexican).setOnClickListener(this);
        findViewById(R.id.layoutEnglish).setOnClickListener(this);
        findViewById(R.id.layoutDessert).setOnClickListener(this);
        findViewById(R.id.layoutDrink).setOnClickListener(this);

    }//end on create method

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layoutChinese:
                startActivity(new Intent(HomeActivity.this, ChineseActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.layoutIndian:
                startActivity(new Intent(HomeActivity.this, IndianActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.layoutItalian:
                startActivity(new Intent(HomeActivity.this, ItalianActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.layoutAmerican:
                startActivity(new Intent(HomeActivity.this, AmericanActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.layoutMexican:
                startActivity(new Intent(HomeActivity.this, MexicanActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.layoutEnglish:
                startActivity(new Intent(HomeActivity.this, EnglishActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.layoutDessert:
                startActivity(new Intent(HomeActivity.this, DessertActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.layoutDrink:
                startActivity(new Intent(HomeActivity.this, DrinkActivity.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

        }//end switch

    }//end onclick method

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            moveTaskToBack(true);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_recipes:
                startActivity(new Intent(HomeActivity.this, MyRecipeActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            case R.id.nav_about:
                startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }
        return true;
    }


}//end home activity
