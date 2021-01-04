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

public class ItalianActivity extends AppCompatActivity {

    //declare variables
    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);


        //add a recipe to my array list
        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Spagetti Bolognese", "2 cloves of garlic , " +
                "1 onion , " +
                "2 sprigs of fresh rosemary , " +
                "6 rashers dry-cured higher-welfare , " +
                "smoked streaky bacon , " +
                "olive oil , " +
                "500 g minced beef, " +
                "200 ml red wine , " +
                "1 x 280 g jar of sun-dried tomatoes , " +
                "2 x 400 g tins of plum tomatoes , " +
                "500 g dried spaghetti , " +
                "Parmesan cheese , " +
                "extra virgin olive oil", "Method", "1. Preheat the oven to 180ºC/350ºF/gas 4. " + "\n" +
                "2. Peel and finely chop the garlic and onions, pick and finely chop the rosemary, then finely slice the bacon." + "\n" +
                "3. Heat a splash of oil in a casserole pan on a medium heat, add the bacon, rosemary, garlic and onion and cook for 5 minutes, or until softened, stirring occasionally." + "\n" +
                "4. Add the minced beef, breaking it apart with the back of a spoon, then cook for 2 to 3 minutes, or until starting to brown, then pour in the wine. Leave to bubble and cook away." + "\n" +
                "5. Meanwhile, drain and tip the sun-dried tomatoes into a food processor, blitz to a paste, then add to the pan with the tomatoes. Stir well, break the plum tomatoes apart a little." + "\n" +
                "6. Cover with a lid then place in the oven for 1 hour, removing the lid and giving it a stir after 30 minutes – if it looks a little dry at this stage, add a splash of water to help it along." + "\n" +
                "7. About 10 minutes before the time is up, cook the spaghetti in boiling salted water according to the packet instructions. " + "\n" +
                "8. Once the spaghetti is cooked, drain, reserving a mugful of cooking water, then return to the pan with a few spoons of Bolognese, a good grating of Parmesan and a drizzle of extra virgin olive oil. " + "\n" +
                "9. Toss to coat the spaghetti, loosening with a splash of cooking water, if needed. " + "\n" +
                "10. Divide the spaghetti between plates or bowls, add a good spoonful of Bolognese to each, then serve with a fine grating of Parmesan." + "\n", "1 hour, 15 mins", R.drawable.spagetti, R.raw.video));

        myRecipeList.add(new RecipeModelClone("Margherita Pizza", "300g strong bread flour , " +
                "1 tsp instant yeast (from a sachet or a tub) , " +
                "1 tsp salt , " +
                "1 tbsp olive oil, plus extra for drizzling , " +
                "100ml passata, " +
                "handful fresh basil or 1 tsp dried , " +
                "1 garlic clove, crushed , " +
                "125g ball mozzarella, sliced , " +
                "handful grated or shaved parmesan (or vegetarian alternative) , " +
                "handful of cherry tomatoes, halved , " +
                "handful of basil leaves (optional) ", "Method", "1. Make the base: Put the flour into a large bowl, then stir in the yeast and salt. Make a well, pour in 200ml warm water and the olive oil and bring together with a wooden spoon until you have a soft, fairly wet dough. Turn onto a lightly floured surface and knead for 5 mins until smooth. Cover with a tea towel and set aside. You can leave the dough to rise if you like, but it’s not essential for a thin crust." + "\n" +
                "2. Make the sauce: Mix the passata, basil and crushed garlic together, then season to taste. Leave to stand at room temperature while you get on with shaping the base." + "\n" +
                "3. Roll out the dough: if you’ve let the dough rise, give it a quick knead, then split into two balls. On a floured surface, roll out the dough into large rounds, about 25cm across, using a rolling pin. The dough needs to be very thin as it will rise in the oven. Lift the rounds onto two floured baking sheets." + "\n" +
                "4. Top and bake: heat the oven to 240C/220C fan/gas 8. Put another baking sheet or an upturned baking tray in the oven on the top shelf. Smooth sauce over bases with the back of a spoon. Scatter with cheese and tomatoes, drizzle with olive oil and season. Put one pizza, still on its baking sheet, on top of the preheated sheet or tray. Bake for 8-10 mins until crisp. Serve with a little more olive oil, and basil leaves if using. Repeat step for remaining pizza." + "\n", "30 mins", R.drawable.pizza, R.raw.video));


        //get the recycler view and display array list of recipes
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ItalianActivity.this, HomeActivity.class));
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}