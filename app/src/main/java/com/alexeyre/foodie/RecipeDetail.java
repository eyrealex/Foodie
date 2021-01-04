package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RecipeDetail extends AppCompatActivity {

    //variables
    TextView RecipeName, RecipeIngredients, RecipeMethod;
    ImageView RecipeImage;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        //hooks
        RecipeName = (TextView) findViewById(R.id.name);
        RecipeIngredients = (TextView) findViewById(R.id.ingredients);
        RecipeMethod = (TextView) findViewById(R.id.method);
        RecipeImage = (ImageView) findViewById(R.id.recipe_image);

        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null) { //if the bundle is not empty

            //set the user inputs to a key
            imageUrl = mBundle.getString("Image");
            RecipeName.setText(mBundle.getString("RecipeName"));
            RecipeIngredients.setText(mBundle.getString("RecipeIngredients"));
            RecipeMethod.setText(mBundle.getString("RecipeMethod"));
            key = mBundle.getString("keyValue");

            //load with animation
            Glide.with(this)
                    .load(mBundle.getString("Image"))
                    .into(RecipeImage);


        }
    }

    //method to update a recipe
    public void btnUpdateRecipe(View view) {
        startActivity(new Intent(getApplicationContext(), RecipeUpdateActivity.class) //get all the extras using a key to update in the database

                .putExtra("Recipe Name", RecipeName.getText().toString())
                .putExtra("Ingredients", RecipeIngredients.getText().toString())
                .putExtra("Method", RecipeMethod.getText().toString())
                .putExtra("oldimageUrl", imageUrl));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);


    }

    //method to delete a recipe
    public void btnDeleteRecipe(View view) {
        //get the path for the recipe in the database to delete
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Recipe");
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);

        //if the recipe has been deleted successfully
        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                reference.child(key).removeValue(); //remove the key value
                Toast.makeText(RecipeDetail.this, "Recipe Deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), CreateRecipeActivity.class));
                finish();

            }
        });
    }
}