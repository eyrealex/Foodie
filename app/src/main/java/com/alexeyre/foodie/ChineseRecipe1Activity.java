package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ChineseRecipe1Activity extends AppCompatActivity {

    TextView recipeDesc;
    ImageView recipeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_recipe1);

        recipeDesc = (TextView)findViewById(R.id.descriptionTv);
        recipeImage = (ImageView)findViewById(R.id.recipeIv);

        Bundle mBundle = getIntent().getExtras();

        if(mBundle != null){

            recipeImage.setImageResource(mBundle.getInt("Image"));
            recipeDesc.setText(mBundle.getString("Description"));

        }
    }
}