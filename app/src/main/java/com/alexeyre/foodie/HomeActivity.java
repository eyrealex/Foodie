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


public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

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


        //create chinese button activity
        findViewById(R.id.layoutChinese).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openChineseActivity();
            }
        });

        //create indian button activity
        findViewById(R.id.layoutIndian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openIndianActivity();
            }
        });

        //create italian button activity
        findViewById(R.id.layoutItalian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openItalianActivity();
            }
        });

        //create american button activity
        findViewById(R.id.layoutAmerican).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openAmericanActivity();
            }
        });

        //create mexican button activity
        findViewById(R.id.layoutMexican).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openMexicanActivity();
            }
        });

        //create english button activity
        findViewById(R.id.layoutEnglish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openEnglishActivity();
            }
        });

        //create dessert button activity
        findViewById(R.id.layoutDessert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openDessertActivity();
            }
        });

        //create drink button activity
        findViewById(R.id.layoutDrink).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity.this.openDrinkActivity();
            }
        });

    }

    public void openChineseActivity() {
        Intent intent = new Intent(this, ChineseActivity.class);
        startActivity(intent);
    }

    private void openIndianActivity() {
        Intent intent = new Intent(this, IndianActivity.class);
        startActivity(intent);
    }

    private void openItalianActivity() {
        Intent intent = new Intent(this, ItalianActivity.class);
        startActivity(intent);
    }

    private void openAmericanActivity() {
        Intent intent = new Intent(this, AmericanActivity.class);
        startActivity(intent);
    }

    private void openMexicanActivity() {
        Intent intent = new Intent(this, MexicanActivity.class);
        startActivity(intent);
    }

    private void openEnglishActivity() {
        Intent intent = new Intent(this, EnglishActivity.class);
        startActivity(intent);
    }


    private void openDessertActivity() {
        Intent intent = new Intent(this, DessertActivity.class);
        startActivity(intent);
    }

    private void openDrinkActivity() {
        Intent intent = new Intent(this, DrinkActivity.class);
        startActivity(intent);
    }


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
                break;
            case R.id.nav_favourite:
                //startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            case R.id.nav_settings:
                //startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
            case R.id.nav_about:
                startActivity(new Intent(HomeActivity.this, AboutActivity.class));
                break;
            case R.id.nav_share:
                // startActivity(new Intent(MainActivity.this, MapsActivity.class));
                break;
        }
        return true;
    }
}
