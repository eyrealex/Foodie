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

public class AmericanActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_american);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);

        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Sloppy Joes", "1 tbsp vegetable oil , " +
                "2 small red peppers or yellow peppers, finely chopped , " +
                "2 garlic cloves crushed , " +
                "400g minced beef , " +
                "2 x 400ml cans chopped tomatoes , " +
                "2 tbsp chipotle or smoky barbecue sauce , " +
                "4 cheese slices , " +
                "6 burger buns , " +
                "crispy onions to serve , " +
                "iceberg lettuce to serve", "Method", "1. Heat the oil in a deep frying pan, then fry the onion, pepper and garlic for 8-10 mins until softened. Add the mince, breaking it up with a wooden spoon as you go, and stir until it browns all over. Tip in the tomatoes and chipotle, or barbecue sauce, and add a little seasoning. Simmer for 10-15 mins until the sauce has thickened. " + "\n" +
                "2. Put the cheese slices on top of the mince and cover with a lid for 2 mins to let it melt into the sauce. Pile into the buns with the crispy onions, and lettuce on the side for scooping up the extra sauce." + "\n", "30 mins", R.drawable.sloppy_joes));

        myRecipeList.add(new RecipeModelClone("BBQ Pulled Pork Sandwich", "2 and 1/2kg boneless pork shoulder skin removed , " +
                "3 tbsp olive oil , " +
                "2 tsp Spanish paprika (pimentón) , " +
                "2 tsp mustard powder , " +
                "brioche buns , " +
                "tangy bbq sauce , " +
                "cabbage slaw , " +
                "1 tsp garlic salt , " +
                "1 tsp onion salt , ", "Method", "1. Heat oven to 150C/130C fan/gas 2. Rub the pork with 2 tbsp of the olive oil. Heat a large non-stick pan until very hot and sear the pork on all sides until golden brown." + "\n" +
                "2. Place the meat on a wire rack in a roasting tin. Mix the paprika, mustard powder, garlic and onion salt, and some black pepper with the liquid smoke, if using. Brush all over the meat." + "\n" +
                "3. Add 1 cup of water to the roasting tin, cover very tightly with foil and cook for 5 hrs or until almost falling apart." + "\n" +
                "4. Drain the juices from the meat into a measuring jug. Shred the pork using 2 forks, discarding the fat." + "\n" +
                "5. Skim off the fat from the juices. Mix 125ml of the juices with 4 tbsp BBQ sauce (see recipe in 'goes well with') and pour over the meat. Keep warm until serving, or reheat." + "\n" +
                "6. To assemble, pile the meat into the halved brioche buns, spoon over the BBQ sauce, top with coleslaw and pickles, and sandwich together." + "\n", "5 hours 10 mins", R.drawable.pulled_pork));


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AmericanActivity.this, HomeActivity.class));
        finish();
    }


}