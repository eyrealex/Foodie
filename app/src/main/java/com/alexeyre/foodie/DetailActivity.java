package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView recipeTitle, recipeIngredients, recipeMethodTitle, recipe;
    ImageView recipeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recipeTitle = (TextView) findViewById(R.id.title);
        recipeIngredients = (TextView) findViewById(R.id.ingredients);
        recipeMethodTitle = (TextView) findViewById(R.id.detail_method);
        recipe = (TextView) findViewById(R.id.method);
        recipeImage = (ImageView) findViewById(R.id.detail_image);


        Intent intent = getIntent();
        String Title = intent.getExtras().getString("RecipeTitle");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String MethodTitle = intent.getExtras().getString("RecipeMethodTitle");
        String Recipe = intent.getExtras().getString("Recipe");
        int Image = intent.getExtras().getInt("Image");

        recipeTitle.setText(Title);
        recipeIngredients.setText(Ingredients);
        recipeMethodTitle.setText(MethodTitle);
        recipe.setText(Recipe);
        recipeImage.setImageResource(Image);

    }
}