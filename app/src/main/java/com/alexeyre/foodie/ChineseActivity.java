package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapters.MyAdapter;
import Helpers.RecipeModel;

public class ChineseActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModel> myRecipeList;
    RecipeModel mRecipeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChineseActivity.this, HomeActivity.class));
                finish();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ChineseActivity.this, 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myRecipeList = new ArrayList<>();

        mRecipeModel = new RecipeModel("Kung Pao Noodles", "Spicy kung pao noodles are a cinch to whip up in just 20 minutes with the best sweet and spicy kung pao sauce. Easily add chicken, shrimp, or beef to amp this side up to a full meal.", "20 mins", R.drawable.noodles);
        myRecipeList.add(mRecipeModel);
        mRecipeModel = new RecipeModel("Boiled Dumplings", "Chinese dumplings (jiaozi) are a rather popular dish during the Chinese New Year season but are also a fun and delicious appetizer, dinner food, and snack to enjoy any time of year.", "45 mins", R.drawable.dumplings);
        myRecipeList.add(mRecipeModel);

        MyAdapter myAdapter = new MyAdapter(ChineseActivity.this, myRecipeList);
        mRecyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ChineseActivity.this, HomeActivity.class));
        finish();
    }


}