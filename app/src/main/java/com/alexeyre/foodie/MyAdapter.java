package com.alexeyre.foodie;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ViewTarget;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    //variables
    private Context mContext;
    private List<RecipeModel> myRecipeList;
    private int lastPosition = -1;

    public MyAdapter(Context mContext, List<RecipeModel> myRecipeList) {
        this.mContext = mContext;
        this.myRecipeList = myRecipeList;
    }

    //create a template for the recycler
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);

        return new RecipeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {

        //load in the recipe template from the database with animation, using the image, title and time
        Glide.with(mContext)
                .load(myRecipeList.get(i).getRecipeImage())
                .into(recipeViewHolder.imageView);

        recipeViewHolder.mTitle.setText(myRecipeList.get(i).getRecipeName());
        recipeViewHolder.mTime.setText(myRecipeList.get(i).getRecipeTime());

        recipeViewHolder.mCardView.setOnClickListener(v -> {

            //get the extras from the model class and display them when the template for a recipe has been clicked
            Intent intent = new Intent(mContext, RecipeDetail.class);
            intent.putExtra("Image", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeImage());
            intent.putExtra("RecipeName", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeName());
            intent.putExtra("RecipeIngredients", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeIngredients());
            intent.putExtra("RecipeMethod", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeMethod());
            intent.putExtra("RecipeTime", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeTime());
            intent.putExtra("keyValue", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getKey());
            mContext.startActivity(intent);
        });

        setAnimation(recipeViewHolder.itemView, i);
    }

    //method to add animation for loading in multiple templates
    private void setAnimation(View viewToAnimate, int position) {
        if (position > lastPosition) {

            ScaleAnimation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                    Animation.RELATIVE_TO_SELF, 0.5f,
                    Animation.RELATIVE_TO_SELF, 0.5f);
            animation.setDuration(1500);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;


        }
    }

    @Override
    public int getItemCount() {
        return myRecipeList.size();
    }
}

//class for the recipe template
class RecipeViewHolder extends RecyclerView.ViewHolder {

    //template variables
    ImageView imageView;
    TextView mTitle, mTime;
    CardView mCardView;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        //template hooks
        imageView = itemView.findViewById(R.id.recipeIv);
        mTitle = itemView.findViewById(R.id.titleTv);
        mTime = itemView.findViewById(R.id.timeTv);
        mCardView = itemView.findViewById(R.id.cardviewCv);
    }
}
