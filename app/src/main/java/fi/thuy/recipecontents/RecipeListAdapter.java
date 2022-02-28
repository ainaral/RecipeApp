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

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyViewClass> {
    private Context context;
    private ArrayList <Recipe> recipeList;
    private OnCardListener mOnCardListener;

     public RecipeListAdapter(Context context, ArrayList<Recipe> recipeList, OnCardListener onCardListener){
        this.context = context;
        this.recipeList = recipeList;
        this.mOnCardListener = onCardListener;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflate the item Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_detail, parent,false);
        //pass view to viewholder of ThirdActivity class
        return new MyViewClass(view, mOnCardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.title.setText(recipeList.get(position).getRecipeName());
        holder.image.setImageResource(recipeList.get(position).getImage());
        holder.serving.setText(recipeList.get(position).getServing());
        holder.time.setText(recipeList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder implements  View.OnClickListener{
         TextView title;
         ImageView image;
         TextView serving ;
         TextView time;
         TextView calories;
         OnCardListener onCardListener;

        public MyViewClass(View item, OnCardListener onCardListener){
            super(item);

            // get the reference of item view's
            title = (TextView) item.findViewById(R.id.textViewTitle);
            image = (ImageView) item.findViewById(R.id.imageView);
            serving = (TextView) item.findViewById(R.id.tvServing);
            time = (TextView) item.findViewById(R.id.tvTime);
            calories = (TextView) item.findViewById(R.id.tvCalories);
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
