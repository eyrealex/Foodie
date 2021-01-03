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

    ImageView rImage;
    Uri uri;
    EditText rName, rIngredients, rMethod, rTime;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);

        rImage = (ImageView) findViewById(R.id.recipeImage);
        rName = (EditText) findViewById(R.id.recipeName);
        rIngredients = (EditText) findViewById(R.id.recipeIngredients);
        rMethod = (EditText) findViewById(R.id.recipeMethod);
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


        RecipeModel recipeModel = new RecipeModel(
                rName.getText().toString(),
                rIngredients.getText().toString(),
                rMethod.getText().toString(),
                rTime.getText().toString(),
                imageUrl
        );

        String myCurrentDateTime = DateFormat.getDateTimeInstance()
                .format(Calendar.getInstance().getTime());

        FirebaseDatabase.getInstance().getReference("Recipe")
                .child(myCurrentDateTime).setValue(recipeModel).addOnCompleteListener(new OnCompleteListener<Void>() {
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
    @Override
    public void onBackPressed() {
        startActivity(new Intent(CreateRecipeActivity.this, MyRecipeActivity.class));
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

}