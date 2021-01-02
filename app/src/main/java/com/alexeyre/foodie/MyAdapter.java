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

    private Context mContext;
    private List<RecipeModel> myRecipeList;
    private int lastPosition = -1;

    public MyAdapter(Context mContext, List<RecipeModel> myRecipeList) {
        this.mContext = mContext;
        this.myRecipeList = myRecipeList;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View mView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);

        return new RecipeViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int i) {

        Glide.with(mContext)
                .load(myRecipeList.get(i).getRecipeImage())
                .into(recipeViewHolder.imageView);

        recipeViewHolder.mTitle.setText(myRecipeList.get(i).getRecipeName());
        recipeViewHolder.mTime.setText(myRecipeList.get(i).getRecipeTime());

        recipeViewHolder.mCardView.setOnClickListener(v -> {

            Intent intent = new Intent(mContext, RecipeDetail.class);
            intent.putExtra("Image", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeImage());
            intent.putExtra("Description", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeDesc());
            intent.putExtra("RecipeName", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeName());
            intent.putExtra("price", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeTime());
            intent.putExtra("keyValue", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getKey());
            mContext.startActivity(intent);
        });

        setAnimation(recipeViewHolder.itemView, i);
    }

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

class RecipeViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView mTitle, mDesc, mTime;
    CardView mCardView;

    public RecipeViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.recipeIv);
        mTitle = itemView.findViewById(R.id.titleTv);
        mTime = itemView.findViewById(R.id.timeTv);
        mCardView = itemView.findViewById(R.id.cardviewCv);
    }
}
