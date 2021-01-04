package com.alexeyre.foodie;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;

public class CreateRecipeActivity extends AppCompatActivity {

    //declare variables
    ImageView rImage;
    Uri uri;
    EditText rName, rIngredients, rMethod, rTime;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        //hooks
        rImage = (ImageView) findViewById(R.id.recipeImage);
        rName = (EditText) findViewById(R.id.recipeName);
        rIngredients = (EditText) findViewById(R.id.recipeIngredients);
        rMethod = (EditText) findViewById(R.id.recipeMethod);
        rTime = (EditText) findViewById(R.id.recipeTime);


    }

    //method to select and image
    public void btnSelectImage(View view) {
        Intent imageSelect = new Intent(Intent.ACTION_PICK);
        imageSelect.setType("image/*"); //used for selecting jpegs, pngs etc
        startActivityForResult(imageSelect, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //if the image has successfully been selected, get the image and set it

            uri = data.getData();
            rImage.setImageURI(uri);

        } else
            Toast.makeText(this, "Please choose an Image", Toast.LENGTH_SHORT).show(); //otherwise return error message

    }

    //method to upload image to database
    public void uploadImage() {

        //set the path for storing image
        StorageReference storageReference = FirebaseStorage.getInstance()
                .getReference().child("RecipeImage").child(uri.getLastPathSegment());

        //method to ensure image uploads to database successfully
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete())
                    ; //while task successfully upload image upload the image to database
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                uploadRecipe(); //also upload the recipe to database
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
            }
        });


    }

    //method to create the recipe, runs the upload image method which also runs the upload recipe method
    public void btnCreateRecipe(View view) {
        uploadImage();
    }

    //upload recipe method
    public void uploadRecipe() {

        //get the user inputs to store on the database
        RecipeModel recipeModel = new RecipeModel(
                rName.getText().toString(),
                rIngredients.getText().toString(),
                rMethod.getText().toString(),
                rTime.getText().toString(),
                imageUrl
        );

        //create a path in the database to store a recipe inside a time of upload child
        String myCurrentDateTime = DateFormat.getDateTimeInstance()
                .format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Recipe")
                .child(myCurrentDateTime).setValue(recipeModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) { //if recipe has been uploaded successfully, return a message and return to my recipes page

                    Toast.makeText(CreateRecipeActivity.this, "Recipe Uploaded", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(CreateRecipeActivity.this, MyRecipeActivity.class));
                    finish();
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CreateRecipeActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(CreateRecipeActivity.this, MyRecipeActivity.class));
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

}