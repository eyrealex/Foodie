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

public class IndianActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndianActivity.this, HomeActivity.class));
                finish();
            }
        });

        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Railway lamb curry", "8 garlic cloves crushed, " +
                "thumb-sized ginger finely grated, " +
                "2 tsp turmeric, " +
                "800g leg of lamb on the bone, cut into bite-sized pieces, " +
                "3 tbsp vegetable oil, " +
                "10-12 curry leaves, " +
                "1 onion , finely chopped, " +
                "450ml lamb stock, " +
                "2 tsp tamarind paste, " +
                "rice or roti, " +
                "1 tbsp coriander seeds, " +
                "2 tsp fennel seeds, " +
                "1 tsp cumin seeds, " +
                "6-7 dried Kashmiri chillies, " +
                "1 medium potato , peeled and cut into chunks, " +
                "250ml coconut milk", "Method", "1. Mix the garlic, ginger, turmeric and lamb together in a large mixing bowl, then leave the lamb to marinate in the fridge for 1 hr or preferably overnight." + "\n" +
                "2. Toast the spice mix ingredients in a dry frying pan for 12 mins over a low heat, stirring occasionally, until they release their aroma. Leave to cool, then grind to a fine powder using a spice grinder or pestle and mortar. Set aside." + "\n" +
                "3. Heat the oil over a medium heat in a heavy-based, large saucepan. Add the curry leaves and onions, and fry for 15-17 mins, stirring well. As the onions begin to change colour, add the lamb and fry for 10 mins. Add the spice powder and turn the heat up slightly. Stir continuously for 5 mins. Pour in the stock and season to taste. Bring to the boil, then turn down to a simmer. Put the lid on and cook for 40 mins. Stir halfway through cooking." + "\n" +
                "4. Tip in the potato and continue cooking for 15 mins. Add the coconut milk along with the tamarind paste and simmer for 10 mins with the lid off to reduce. Serve warm with rice or roti. " + "\n", "2 hours, 20 mins", R.drawable.lamb_curry));

        myRecipeList.add(new RecipeModelClone("Butter chicken curry", "6 tablespoons butter, divided, " +
                "2 lbs boneless/skinless chicken thighs, cut into 1” chunks, " +
                "1 yellow onion, diced, " +
                "3 garlic cloves, minced, " +
                "1 Tbsp garam masala, " +
                "1 tsp chili powder, " +
                "1 tsp ground cumin, " +
                "1 and 1/2 cups tomato sauce, " +
                "lime & cilantro, for garnish, " +
                "2 cups cream, " +
                "naan & rice for serving, " +
                "1/2 tsp cayenne pepper, " +
                "1 Tbsp fresh grated ginger, ", "Method", "1. Using 2 Tbsp of butter in a large skillet over medium-high heat, brown the pieces of the chicken so each side is browned. They do not need to be fully cooked all the way through. Work in batches, and set aside when you’re done." + "\n" +
                "2. Melt another 2 Tbsp of butter in the pan over medium heat. Add the onion, and cook until beginning to soften — about three minutes. Add the garlic, garam masala, ginger, chili powder, cumin, and cayenne. Stir to combine, and cook for about 45 seconds before adding the tomato sauce." + "\n" +
                "3. Bring the mixture to a simmer and let cook for five minutes before adding the cream. Bring the mixture back to a simmer, add the browned chicken, and let simmer for 10-15 minutes. Keep the heat low here — not a rolling boil." + "\n" +
                "4. Stir in the remaining 2 Tbsp of butter, and season with salt and pepper, to taste." + "\n" +
                "5. Serve garnished with lime and cilantro, alongside rice and naan." + "\n", " 30 mins", R.drawable.butter_chicken));


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(IndianActivity.this, HomeActivity.class));
        finish();
    }


}