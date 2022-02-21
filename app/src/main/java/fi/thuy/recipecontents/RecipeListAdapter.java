package fi.thuy.recipecontents;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import fi.thuy.recipeapp.R;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.MyViewClass> {
    private Context context;
    private ArrayList <Recipe> recipeList;

    public RecipeListAdapter(Context context, ArrayList<Recipe> recipeList){
        this.context = context;
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent,false);
        return new MyViewClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {

        holder.title.setText(recipeList.get(position).getRecipeName());
        holder.mealType.setText(recipeList.get(position).getMealType());
        holder.image.setImageResource(buildImageArray(position, recipeList.get(position).getRecipeName()));
    }

    private int buildImageArray(int position, String title) {

        // this will give you **all** drawables, including those from e.g. the support libraries!
        Field[] drawables = R.drawable.class.getDeclaredFields();
        int[] image = new int[5];
        SparseIntArray temp = new SparseIntArray();

        for (Field f : drawables) {
            try {
                System.out.println("R.drawable." + f.getName());
                // check the drawable is "yours" by comparing the name to your name pattern
                // this is the point where some unwanted drawable may slip in,
                // so you should spend some effort on the naming/ matching of your pictures
                if (f.getName().startsWith(title)) {
                    System.out.println("R.drawable." + f.getName() + "==========================================");
                    int id = context.getResources().getIdentifier(f.getName(), "drawable", context.getPackageName());
                    temp.append(position, id);
                    image[position] = temp.valueAt(position);
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        return image[position];
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder{
         TextView title;
         TextView mealType;
         ImageView image;

        public MyViewClass(View item){
            super(item);
            title = (TextView) item.findViewById(R.id.textViewTitle);
            mealType = (TextView) item.findViewById(R.id.textMealType);
            image = (ImageView) item.findViewById(R.id.imageView);
        }
    }
}
