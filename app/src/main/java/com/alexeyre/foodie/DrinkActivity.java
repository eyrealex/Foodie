package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DrinkActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);


        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Sex on the beach cocktail", "ice , " +
                "50ml vodka , " +
                "25ml peach schnapps , " +
                "2 oranges, juiced and 2 slices to garnish , " +
                "50ml cranberry juice , " +
                "glacé cherries to garnish ", "Method", "1. Fill two tall glasses with ice cubes. Pour the vodka, peach schnapps and fruit juices into a large jug and stir. " + "\n" +
                "2. Divide the mixture between the two glasses and stir gently to combine. Garnish with the cocktail cherries and orange slices." + "\n", "5 mins", R.drawable.sex_on_the_beach, R.raw.video));

        myRecipeList.add(new RecipeModelClone("Piña colada", "120ml pineapple juice , " +
                "60ml white rum , " +
                "60ml coconut cream , " +
                "wedge of pineapple, to garnish , " +
                "250g mascarpone ", "Method", "1. Pulse all the ingredients along with a handful of ice in a blender until smooth. Pour into a tall glass and garnish as you like." + "\n", "5 mins", R.drawable.pina_colada, R.raw.video));


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(DrinkActivity.this, HomeActivity.class));
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}