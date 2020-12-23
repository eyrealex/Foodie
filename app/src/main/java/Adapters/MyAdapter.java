package Adapters;

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

import com.alexeyre.foodie.ChineseRecipe1Activity;
import com.alexeyre.foodie.R;

import java.util.List;

import Helpers.RecipeModel;

public class MyAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    private Context mContext;
    private List<RecipeModel> myRecipeList;

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
        recipeViewHolder.imageView.setImageResource(myRecipeList.get(i).getRecipeImage());
        recipeViewHolder.mTitle.setText(myRecipeList.get(i).getRecipeName());
        recipeViewHolder.mDesc.setText(myRecipeList.get(i).getRecipeDesc());
        recipeViewHolder.mTime.setText(myRecipeList.get(i).getRecipeTime());

        recipeViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ChineseRecipe1Activity.class);
                intent.putExtra("Image", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeImage());
                intent.putExtra("Description", myRecipeList.get(recipeViewHolder.getAdapterPosition()).getRecipeDesc());
                mContext.startActivity(intent);
            }
        });
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
        mDesc = itemView.findViewById(R.id.descTv);
        mTime = itemView.findViewById(R.id.timeTv);
        mCardView = itemView.findViewById(R.id.cardviewCv);
    }
}
