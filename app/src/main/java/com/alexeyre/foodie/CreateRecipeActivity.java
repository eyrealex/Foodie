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
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

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

import Helpers.FoodModel;
import Helpers.RecipeModel;

public class CreateRecipeActivity extends AppCompatActivity {

    ImageView rImage;
    Uri uri;
    EditText rName, rDesc, rTime;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        rImage = (ImageView) findViewById(R.id.recipeImage);
        rName = (EditText) findViewById(R.id.recipeName);
        rDesc = (EditText) findViewById(R.id.recipeDesc);
        rTime = (EditText) findViewById(R.id.recipeTime);




    }

    public void btnSelectImage(View view) {
        Intent imageSelect = new Intent(Intent.ACTION_PICK);
        imageSelect.setType("image/*");
        startActivityForResult(imageSelect, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            uri = data.getData();
            rImage.setImageURI(uri);

        } else Toast.makeText(this, "Please choose an Image", Toast.LENGTH_SHORT).show();

    }

    public void uploadImage() {

        StorageReference storageReference = FirebaseStorage.getInstance()
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

    public void btnCreateRecipe(View view) {
        uploadImage();
    }

    public void uploadRecipe() {


        FoodModel foodModel = new FoodModel(
                rName.getText().toString(),
                rDesc.getText().toString(),
                rTime.getText().toString(),
                imageUrl
        );

        String myCurrentDateTime = DateFormat.getDateTimeInstance()
                .format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Recipe")
                .child(myCurrentDateTime).setValue(foodModel).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {

                    Toast.makeText(CreateRecipeActivity.this, "Recipe Uploaded", Toast.LENGTH_SHORT).show();

                    finish();

                }


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CreateRecipeActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}