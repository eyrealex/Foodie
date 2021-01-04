package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class DetailActivity extends AppCompatActivity {

    //variables
    TextView recipeTitle, recipeIngredients, recipeMethodTitle, recipe;
    ImageView recipeImage;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //variables to implement video feature
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(videoPath);


        //hooks
        recipeTitle = (TextView) findViewById(R.id.title);
        recipeIngredients = (TextView) findViewById(R.id.ingredients);
        recipeMethodTitle = (TextView) findViewById(R.id.detail_method);
        recipe = (TextView) findViewById(R.id.method);
        recipeImage = (ImageView) findViewById(R.id.detail_image);
        videoView = (VideoView) findViewById(R.id.video_view);


        //use keys to create recipe details
        Intent intent = getIntent();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        String Title = intent.getExtras().getString("RecipeTitle");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String MethodTitle = intent.getExtras().getString("RecipeMethodTitle");
        String Recipe = intent.getExtras().getString("Recipe");
        int Image = intent.getExtras().getInt("Image");
        int Video = intent.getExtras().getInt("Video");

        //set the following fields using the keys
        recipeTitle.setText(Title);
        recipeIngredients.setText(Ingredients);
        recipeMethodTitle.setText(MethodTitle);
        recipe.setText(Recipe);
        recipeImage.setImageResource(Image);
        videoView.setVideoURI(uri);

        //media controller variables
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


    }
}