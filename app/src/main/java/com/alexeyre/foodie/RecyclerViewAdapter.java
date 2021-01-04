package com.alexeyre.foodie;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    //variables
    private Context mContext;
    private List<RecipeModelClone> mCloneList;

    public RecyclerViewAdapter(Context mContext, List<RecipeModelClone> mCloneList) {
        this.mContext = mContext;
        this.mCloneList = mCloneList;
    }

    //create a template for the recycler
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.recycler_item, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder, final int i) {

        //set the template fields using the model variables
        myHolder.mTitle.setText(mCloneList.get(i).getTitle());
        myHolder.mTime.setText(mCloneList.get(i).getTime());
        myHolder.imageView.setImageResource(mCloneList.get(i).getImage());
        myHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);

                //get the extras from the model class and display them when the template for a recipe has been clicked
                intent.putExtra("RecipeTitle", mCloneList.get(i).getTitle());
                intent.putExtra("RecipeIngredients", mCloneList.get(i).getIngredients());
                intent.putExtra("RecipeMethodTitle", mCloneList.get(i).getMethodTitle());
                intent.putExtra("Recipe", mCloneList.get(i).getRecipe());
                intent.putExtra("Image", mCloneList.get(i).getImage());
                intent.putExtra("Video", mCloneList.get(i).getVideo());

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCloneList.size();
    }

    //class for the recipe template
    public class MyHolder extends RecyclerView.ViewHolder {

        //template variables
        ImageView imageView;
        TextView mTitle, mDesc, mTime;
        CardView mCardView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            //template hooks
            imageView = itemView.findViewById(R.id.recipeIv);
            mTitle = itemView.findViewById(R.id.titleTv);
            mTime = itemView.findViewById(R.id.timeTv);
            mCardView = itemView.findViewById(R.id.cardviewCv);
        }
    }
}
