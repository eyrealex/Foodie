package com.alexeyre.foodie;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class RecipeUpdateActivity extends AppCompatActivity {

    String RecipeName, RecipeIngredients, RecipeMethod, RecipeTime;
    ImageView RecipeImage;
    EditText name_text, ingredients_text, method_text, time_text;
    String imageUrl;
    String key, oldImageUrl;
    DatabaseReference databaseReference;
    StorageReference storageReference;
    Uri uri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_update);

        RecipeImage = (ImageView) findViewById(R.id.recipeImage);
        name_text = (EditText) findViewById(R.id.recipeName);
        ingredients_text = (EditText) findViewById(R.id.recipe_ingredients);
        method_text = (EditText) findViewById(R.id.recipe_method);
        time_text = (EditText) findViewById(R.id.recipe_time);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {

            Glide.with(RecipeUpdateActivity.this)
                    .load(bundle.getString("oldimageUrl"))
                    .into(RecipeImage);
            name_text.setText(bundle.getString("recipeNameKey"));
            ingredients_text.setText(bundle.getString("ingredientsKey"));
            method_text.setText(bundle.getString("methodKey"));
            time_text.setText(bundle.getString("timeKey"));
            key = bundle.getString("key");
            oldImageUrl = bundle.getString("oldimageUrl");
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("Recipe").child("key");
    }

    public void btnSelectImage(View view) {
        Intent photoPicker = new Intent(Intent.ACTION_PICK);
        photoPicker.setType("image/*");
        startActivityForResult(photoPicker, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            uri = data.getData();
            RecipeImage.setImageURI(uri);

        } else Toast.makeText(this, "You haven't picked image", Toast.LENGTH_SHORT).show();
    }

    public void btnUpdateRecipe(View view) {

        RecipeName = name_text.getText().toString().trim();
        RecipeIngredients = ingredients_text.getText().toString().trim();
        RecipeMethod = method_text.getText().toString();
        RecipeTime = time_text.getText().toString();


        storageReference = FirebaseStorage.getInstance()
                .getReference().child("RecipeImage").child(uri.getLastPathSegment());
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete()) ;
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                uploadRecipe();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });


    }

    private void uploadRecipe() {
        RecipeModel recipeModel = new RecipeModel(
                RecipeName,
                RecipeIngredients,
                RecipeMethod,
                RecipeTime,
                imageUrl
        );


        databaseReference.setValue(recipeModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                StorageReference storageReferenceNew = FirebaseStorage.getInstance().getReferenceFromUrl(oldImageUrl);
                storageReferenceNew.delete();
                Toast.makeText(RecipeUpdateActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
