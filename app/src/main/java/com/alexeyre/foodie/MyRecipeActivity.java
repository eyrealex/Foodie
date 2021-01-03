package com.alexeyre.foodie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyRecipeActivity extends AppCompatActivity {

    List<RecipeModel> myRecipeList;
    RecipeModel mRecipeModel;
    MyAdapter myAdapter;
    RecyclerView mRecyclerView;
    EditText text_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);

        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MyRecipeActivity.this, 1);
        mRecyclerView.setLayoutManager(gridLayoutManager);

        myRecipeList = new ArrayList<>();
        myAdapter = new MyAdapter(MyRecipeActivity.this, myRecipeList);
        mRecyclerView.setAdapter(myAdapter);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Recipe");

        ValueEventListener eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                myRecipeList.clear();

                for (DataSnapshot itemSnapshot : dataSnapshot.getChildren()) {
                    RecipeModel recipeModel = itemSnapshot.getValue(RecipeModel.class);
                    recipeModel.setKey(itemSnapshot.getKey());
                    myRecipeList.add(recipeModel);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void btnAddRecipe(View view) {
        startActivity(new Intent(MyRecipeActivity.this, CreateRecipeActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MyRecipeActivity.this, HomeActivity.class));
        finish();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}