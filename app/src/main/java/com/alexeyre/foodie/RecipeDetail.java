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

    TextView RecipeName, RecipeDesc, RecipeTime;
    ImageView RecipeImage;
    String key = "";
    String imageUrl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        RecipeName = (TextView) findViewById(R.id.recipe_name_text);
        RecipeDesc = (TextView) findViewById(R.id.desc_text);
        RecipeTime = (TextView) findViewById(R.id.time_text);
        RecipeImage = (ImageView) findViewById(R.id.recipe_image);

        Bundle mBundle = getIntent().getExtras();

        if (mBundle != null) {

            RecipeDesc.setText(mBundle.getString("Description"));
            key = mBundle.getString("keyValue");
            imageUrl = mBundle.getString("Image");
            RecipeName.setText(mBundle.getString("Recipe Name"));
            RecipeTime.setText(mBundle.getString("Time"));
            // foodImage.setImageResource(mBundle.getInt("Image"));

            Glide.with(this)
                    .load(mBundle.getString("Image"))
                    .into(RecipeImage);


        }
    }

    public void btnUpdateRecipe(View view) {
        startActivity(new Intent(getApplicationContext(), RecipeUpdateActivity.class)
                .putExtra("recipeNameKey", RecipeName.getText().toString())
                .putExtra("descriptionKey", RecipeDesc.getText().toString())
                .putExtra("timeKey", RecipeTime.getText().toString())
                .putExtra("oldimageUrl", imageUrl)
                .putExtra("key", key)
        );


    }

    public void btnDeleteRecipe(View view) {
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Recipe");
        FirebaseStorage storage = FirebaseStorage.getInstance();

        StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);

        storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                reference.child(key).removeValue();
                Toast.makeText(RecipeDetail.this, "Recipe Deleted", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), CreateRecipeActivity.class));
                finish();

            }
        });
    }
}