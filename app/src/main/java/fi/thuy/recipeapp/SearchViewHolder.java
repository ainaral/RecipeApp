package fi.thuy.recipeapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class SearchViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView recipeName;
    public TextView mealType;

    public SearchViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        recipeName = itemView.findViewById(R.id.recipeName);
        mealType = itemView.findViewById(R.id.mealType);

    }
}