package fi.thuy.recipecontents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import fi.thuy.recipeapp.R;

public class RecipeListAdapterStart extends RecyclerView.Adapter<RecipeListAdapterStart.MyViewClass> {
    private Context context;
    private ArrayList <Recipe> recipeList;
    private OnCardListener mOnCardListener;

    public RecipeListAdapterStart(Context context, ArrayList<Recipe> recipeList, OnCardListener onCardListener){
        this.context = context;
        this.recipeList = recipeList;
        this.mOnCardListener = onCardListener;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the item Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_for_start_activity, parent,false);
        //pass view to viewHolder of StartActivity class
        return new MyViewClass(view, mOnCardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.title.setText(recipeList.get(position).getRecipeName());
        holder.image.setImageResource(recipeList.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView title;
        ImageView image;

        RecipeListAdapterStart.OnCardListener onCardListener;

        public MyViewClass(View item, RecipeListAdapterStart.OnCardListener onCardListener){
            super(item);
            //get the reference of item view's
            title = (TextView) item.findViewById(R.id.textViewTitle);
            image = (ImageView) item.findViewById(R.id.imageView);

            this.onCardListener = onCardListener;

            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCardListener.onCardClick(getAbsoluteAdapterPosition());
        }
    }

    public interface OnCardListener{
        void onCardClick(int position);
    }
}
