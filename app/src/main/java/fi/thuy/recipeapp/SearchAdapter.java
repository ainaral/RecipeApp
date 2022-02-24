package fi.thuy.recipeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private ArrayList<fi.thuy.recipecontents.Recipe> searchList;

    public SearchAdapter(ArrayList<fi.thuy.recipecontents.Recipe> searchList) {
        this.searchList = searchList;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_item,
                parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        fi.thuy.recipecontents.Recipe currentItem = searchList.get(position);

        holder.imageView.setImageResource(currentItem.getImage());
        holder.recipeName.setText(currentItem.getRecipeName());
        holder.mealType.setText(currentItem.getMealType());
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public void filterList(ArrayList<fi.thuy.recipecontents.Recipe> filteredList) {
        searchList = filteredList;
        notifyDataSetChanged();
    }
}