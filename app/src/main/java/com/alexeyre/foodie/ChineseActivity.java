package com.alexeyre.foodie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ChineseActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChineseActivity.this, HomeActivity.class));
                finish();
            }
        });

        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Kung Pao Noodles", "12 ounces spaghetti, fettuccine, or linguine noodles, " +
                "1/2 cup soy sauce, " +
                "1 tablespoon sesame oil, " +
                "4 tablespoons rice vinegar, " +
                "2 tablespoons sugar, " +
                "1-2 tablespoons chili paste, " +
                "1/3 cup cold water, " +
                "1 tablespoon corn starch, " +
                "1/4 cup peanuts, " +
                "2 green onion, thinly sliced", "Method", "1. Cook noodles according to package's instructions. Drain and set aside." + "\n" +
                "2. In a large skillet whisk together soy sauce, sesame oil, rice vinegar, sugar, and chili paste and bring to a boil." + "\n" +
                "3. In a small bowl whisk together cold water and corn starch. Stir into skillet and bring back to a boil, then reduce to medium low heat." + "\n" +
                "4. Stir noodles, peanuts, and green onions into the sauce. Serve immediately." + "\n",  " 20 mins", R.drawable.noodles));

        myRecipeList.add(new RecipeModelClone("Sticky Chinese Lemon Chicken", "1-2 pounds chicken tenderloin, " +
                "2 eggs, " +
                "2 tablespoons soy sauce, " +
                "1/4 cup white cooking wine or chicken broth, " +
                "1/3 cup corn starch, " +
                "1/2 cup vegetable oil or canola oil, ", "Method", "1. Chop chicken into 1 inch pieces. Whisk together eggs, soy sauce, and cooking wine or broth. Add chicken and stir to combine. Cover and chill for 30 minutes." + "\n" +
                "2. Transfer chicken pieces to a large ziplock bag and discard marinade. Add corn starch to bag, seal, and shake to coat chicken completely in the corn starch." + "\n" +
                "3. Add oil to a large pan or skillet and bring to medium-high heat. Transfer chicken to pan, trying to arrange pieces so they aren't piled on top of each other. Cook for 3-4 minutes, then turn the chicken pieces and cook another 3-4 minutes until golden brown." + "\n" +
                "4. Use a slotted spoon to transfer chicken to a paper-towel lined plate. Discard any excess oil in the pan and use a paper towel to wipe it out." + "\n" +
                "5. Add broth, soy sauce, lemon juice, garlic, sugar, honey, and salt to pan and whisk to combine. Bring to a boil over medium-high heat." + "\n" +
                "6. In a small bowl whisk together broth (or water) and corn starch until dissolved. Add to boiling sauce, then reduce heat to medium-low and stir until thickened." + "\n" +
                "7. Transfer chicken to pan and stir 2-3 minutes until hot throughout. Garnish with sesame seeds and sliced green onions and serve over cooked rice." + "\n",  " 30 mins", R.drawable.dumplings));


        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ChineseActivity.this, HomeActivity.class));
        finish();
    }


}