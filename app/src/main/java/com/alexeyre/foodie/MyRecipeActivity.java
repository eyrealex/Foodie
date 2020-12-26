package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);
    }

    public void btnAddRecipe(View view) {
        startActivity(new Intent(MyRecipeActivity.this, CreateRecipeActivity.class));
    }
}