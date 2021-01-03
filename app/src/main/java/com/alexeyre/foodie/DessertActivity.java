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

public class DessertActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);


        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Brownies", "1 cup butter, melted  , " +
                "2 cups white sugar , " +
                "1/2 cup cocoa powder , " +
                "1 teaspoon vanilla extract , " +
                "4 eggs  , " +
                "1 and 1/2 cups all-purpose flour , " +
                "1/2 teaspoon salt , " +
                "1/2 cup walnut halves , " +
                "1/2 teaspoon baking powder , ", "Method", "1. Preheat the oven to 350 degrees F (175 degrees C). Grease a 9x13-inch pan. " + "\n" +
                "2.Combine the melted butter, sugar, cocoa powder, vanilla, eggs, flour, baking powder, and salt. Spread the batter into the prepared pan. Decorate with walnut halves, if desired." + "\n" +
                "3. Bake in preheated oven for 20 to 30 minutes or until a toothpick inserted in the center comes out with crumbs, not wet. Cool on wire rack." + "\n", "35 mins", R.drawable.brownie));

        myRecipeList.add(new RecipeModelClone("White chocolate cheesecake", "300g digestive biscuits , " +
                "150g unsalted butter melted and extra to grease , " +
                "400g white chocolate broken into pieces , " +
                "300g full-fat cream cheese (Philadelphia) , " +
                "250g mascarpone , " +
                "300ml double cream , " +
                "200g strawberries or raspberries, to serve", "Method", "1. Crush the biscuits in a food processor until completely ground. Add butter and whizz again until you have the desired crumbly consistency." + "\n" +
                "2. Grease and line the base of a 23cm deep, loose-bottomed cake tin. Add the biscuit mixture to the cake tin and pat it flat. Leave to set in the fridge for approximately 30 mins." + "\n" +
                "3. Begin melting the chocolate in a heatproof glass bowl over a small pan of hot water on a low heat. Stir occasionally to prevent sticking. Remove from the heat and leave to cool for 10 mins until barely warm but still liquid." + "\n" +
                "4. Meanwhile whisk the cream cheese and mascarpone together. Add double cream and keep whisking until the mixture is just holding its own shape. Finally, add the melted chocolate and whisk until just combined." + "\n" +
                "5. Spoon the mixture over the cooled and set biscuit base, then smooth the top. Return to the fridge to cool for at least 6 hrs until the topping is set. Finally, decorate with fruit." + "\n", "40 mins", R.drawable.cheesecake));


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(DessertActivity.this, HomeActivity.class));
        finish();
    }


}