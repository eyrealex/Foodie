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

public class EnglishActivity extends AppCompatActivity {

    //declare variables
    Toolbar toolbar;
    RecyclerView mRecyclerView;
    List<RecipeModelClone> myRecipeList;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);


        //add a recipe to my array list
        myRecipeList = new ArrayList<>();
        myRecipeList.add(new RecipeModelClone("Roast Beef", "1 tbsp black peppercorn , " +
                "1 tbsp English mustard powder , " +
                "1 tbsp dried thyme , " +
                "1 tsp celery seeds , " +
                "1 tbsp olive oil , " +
                "about 2kg/4lb 8oz topside joint of beef , " +
                "gravy , ", "Method", "1. Crush the peppercorns, mustard powder, thyme and celery seeds together with some salt, using a pestle and mortar. Stir in the oil, then rub it all over the beef. (If you have time, cover and chill the joint overnight to marinate. Bring the beef out of the fridge 1 hr before roasting.) " + "\n" +
                "2. Heat oven to 190C/170C fan/gas 5 and sit the joint in a snug-ish roasting tin. Roast for 12 mins per 450g/1lb (about 55 mins for a 2kg/4lb 8oz joint) for medium-rare, or 15 mins per 450g/1lb (about 1 hr 10 mins) for medium-well." + "\n" +
                "3. Remove from the oven, lift onto a platter, cover with foil and rest for 30 mins. If you’re making the Yorkies, increase oven to 220C/200C fan/gas 7." + "\n" +
                "4. For the gravy, pour any juices from the roasting tin into a jug. Let the juices separate, then spoon 2 tbsp of the fat back into the tin – if there is no fat, use 2 tbsp butter instead. Discard any other fat. Sit the roasting tin on the hob and stir in the flour, stock cubes, onion chutney or marmalade and Marmite. Cook for 1 min, stirring well to scrape up any beefy bits stuck to the tin, then gradually stir in 750ml hot water from the kettle. Bubble to thicken to a nice consistency, then gently keep warm until ready to serve with the beef, carved into slices." + "\n", "1 hour 30 mins", R.drawable.beef, R.raw.video));

        myRecipeList.add(new RecipeModelClone("Scampi and tartare sauce", "15-20 langoustine or Dublin Bay prawn tails , " +
                "vegetable or sunflower oil , for frying , " +
                "140g plain flour , " +
                "85g cornflour , " +
                "150ml beer , " +
                "100ml sparkling water , " +
                "lemon wedges and chips , to serve , " +
                "tartare sauce", "Method", "1. To prepare the langoustines, pull off the head and pincers. Lay the tail flat on a chopping board and use a sharp pair of scissors to cut a line straight down the back of the shell. Carefully peel the langoustine, score down the back, then remove the grit sac." + "\n" +
                "2. Get the oil heating in a large saucepan or wok – you will need enough to come 2-3in up the side of the pan. For the tartare sauce, mix all ingredients in a bowl and season." + "\n" +
                "3. Place the flours in a bowl with a good pinch of salt and pepper. Add the beer and sparkling water, and whisk to a smooth batter." + "\n" +
                "4. To test if the oil is hot enough, put a drop of batter into the pan – it should crisp and brown within 30 secs. Dip each langoustine or prawn tail into the batter, then carefully drop it into the oil. Drizzle a little extra batter over each one while they are cooking – this will give you a really crispy coating. Cook them in batches, making sure you don’t overcrowd the pan. When golden and floating to the surface, scoop out and drain well on kitchen paper. Sprinkle the scampi with salt and serve with the tartare sauce, lemon wedges and chips." + "\n", "20 mins", R.drawable.scampi, R.raw.video));


        //get the recycler view and display array list of recipes
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(this, myRecipeList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(recyclerViewAdapter);

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(EnglishActivity.this, HomeActivity.class));
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}