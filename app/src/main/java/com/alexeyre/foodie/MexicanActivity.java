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

public class MexicanActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexican);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);


        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Chicken and bean enchiladas", "1 tbsp rapeseed oil , " +
                "2 red onion sliced , " +
                "2 red peppers deseeded and sliced , " +
                "2 garlic cloves crushed , " +
                "2 tsp chipotle paste (add extra if you prefer more heat) , " +
                "2 skinless chicken breasts, cut into thin strips , " +
                "400g can black beans or kidney beans , " +
                "small bunch coriander chopped , " +
                "500ml passata , " +
                "50g mature cheddar grated , " +
                "green salad , to serve , " +
                "6 medium tortillas", "Method", "1. Heat oven to 200C/180C fan/gas 6. Heat the oil in a large frying pan and add the onions, peppers and half the garlic. Cook for 15 mins, stirring now and then until the veg has softened. Stir in the chipotle paste, then fry for 1 min more. Add the chicken strips, turning them over in the mixture so they cook through, about 5-10 mins. " + "\n" +
                "2. Stir in the beans, coriander and 150ml of the passata, then take the pan off the heat. Mix the rest of the passata with the remaining crushed garlic and the ketchup." + "\n" +
                "3. Divide the mixture between the tortillas, then fold the sides in and roll them up. Pour half the passata sauce into a 22cm square baking dish, then place the enchiladas on top, side by side. Dot over the remaining sauce and sprinkle over the grated cheese, then bake for 25-30 mins until golden brown." + "\n", "55 mins", R.drawable.enchiladas));

        myRecipeList.add(new RecipeModelClone("Chicken Fajitas", "2 large chicken breasts, finely sliced , " +
                "1 red onion finely sliced , " +
                "1 red pepper sliced , " +
                "1 heaped tbsp smoked paprika , " +
                "1 tbsp ground coriander , " +
                "pinch of ground cumin , " +
                "2 medium garlic cloves crushed , " +
                "4 tbsp olive oil , " +
                "6 medium tortillas , " +
                "bag mixed salad , " +
                "230g tub fresh salsa , " +
                "4-5 drops Tabasco , " +
                "1 lime juiced , ", "Method", "1. Heat oven to 200C/180C fan/gas 6 and wrap 6 medium tortillas in foil." + "\n" +
                "2. Mix 1 heaped tbsp smoked paprika, 1 tbsp ground coriander, a pinch of ground cumin, 2 crushed garlic cloves, 4 tbsp olive oil, the juice of 1 lime and 4-5 drops Tabasco together in a bowl with a big pinch each of salt and pepper." + "\n" +
                "3. Stir 2 finely sliced chicken breasts, 1 finely sliced red onion, 1 sliced red pepper and 1 finely sliced red chilli, if using, into the marinade." + "\n" +
                "4. Heat a griddle pan until smoking hot and add the chicken and marinade to the pan." + "\n" +
                "5. Keep everything moving over a high heat for about 5 mins using tongs until you get a nice charred effect. If your griddle pan is small you may need to do this in two batches." + "\n" +
                "6. To check the chicken is cooked, find the thickest part and tear in half – if any part is still raw cook until done." + "\n" +
                "7. Put the tortillas in the oven to heat up and serve with the cooked chicken, a bag of mixed salad and one 230g tub of fresh salsa." + "\n", "10 mins", R.drawable.fajitas));


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MexicanActivity.this, HomeActivity.class));
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}