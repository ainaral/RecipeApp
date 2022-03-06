package fi.thuy.recipecontents;

public class Recipe {
    private int id;
    private String recipeName;
    private String mealType;
    private String instructions;
    private String ingredients;
    private String tags;
    private int image;
    private String serving;
    private String time;
    private String calories;
    private String category;

    public Recipe( int id, String recipeName, String mealType, String instructions, String ingredients, String tags, int image,String serving,  String time,String calories, String category) {
        this.id = id;
        this.recipeName = recipeName;
        this.mealType = mealType;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.tags = tags;
        this.image = image;
        this.serving = serving;
        this.time = time;
        this.calories = calories;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getMealType() {
        return mealType;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getTags() {
        return tags;
    }

    public int getImage() {
        return image;
    }

    public String getServing() {
        return serving;
    }

    public String getTime() {
        return time;
    }

    public String getCalories() {
        return calories;
    }

    public String getCategory() {
        return category;
    }

}

