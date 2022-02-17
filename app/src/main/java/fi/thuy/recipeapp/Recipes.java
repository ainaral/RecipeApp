package fi.thuy.recipeapp;

import java.util.ArrayList;
import java.util.List;

public class Recipes {

    private final List<Recipe> recipeList;
    private static final Recipes recipes = new Recipes();

    private Recipes(){
        recipeList = new ArrayList<>();
        recipeList.add(new Recipe(
                "Avocado smash with egg\n ",
                "2 eggs\n" +
                "2 slices of multigrain bread\n" +
                "½ ripe avocado, stoned, peeled, mashed.\n ",
                "Step 1: Cook the eggs in a small saucepan of boiling water " +
                        "for 8 mins for set yolks or until cooked to your liking. " +
                        "Refresh under cold water. Peel each egg and halve lengthways.\n\n" +
                        "Step 2: Place the toast on serving plates. Spread with avocado. " +
                        "Arrange the egg on top of the avocado. Sprinkle with chives. " +
                        "Season with pepper to serve. "));
        recipeList.add(new Recipe(
                "Smashed chickpea bruschetta ",
                "125g can chickpeas, rinsed, drained\n" +
                        "1 tsp fresh lemon juice\n" +
                        "1 tsp tahini\n" +
                        "50g cherry tomatoes, quartered\n" +
                        "1 tbsp chopped fresh continental parsley\n" +
                        "1/2 tsp extra virgin olive oil\n" +
                        "1 slice wholegrain bread, toasted\n" +
                        "Lemon wedge, to serve\n ",
                "Step 1: Place chickpeas in a small bowl with the lemon juice " +
                        "and tahini. Mash with a fork, leaving some texture. Season.\n" +
                        "Step 2: Combine tomatoes, parsley and oil. " +
                        "Spread chickpea mixture over toast. Top with tomato salad. " +
                        "Serve with a lemon wedge. "));
        recipeList.add(new Recipe(
                "Tropical smoothie bowl ",
                "1 small ripe mango , stoned, peeled and cut into chunks\n" +
                        "200g pineapple , peeled, cored and cut into chunks\n" +
                        "2 ripe bananas\n" +
                        "2 tbsp coconut yogurt (not coconut-flavoured yogurt)\n" +
                        "150ml coconut drinking milk\n" +
                        "2 passion fruits , halved, seeds scooped out\n" +
                        "handful blueberries\n" +
                        "2 tbsp coconut flakes\n" +
                        "a few mint leaves\n ",
                "Step 1: Put the mango, pineapple, bananas, yogurt and " +
                        "coconut milk in a blender, and blitz until smooth and thick. " +
                        "Pour into two bowls and decorate with the passion fruit, " +
                        "blueberries, coconut flakes and mint leaves. " +
                        "Will keep in the fridge for 1 day. Add the toppings just before serving. "));
        recipeList.add(new Recipe(
                "Chicken Piccata ",
                "¼ cup all-purpose flour\n" +
                        "½ teaspoon salt\n" +
                        "½ teaspoon pepper\n" +
                        "4 boneless skinless chicken breast halves (4 ounces each)\n" +
                        "¼ cup butter, cubed\n" +
                        "¼ cup white wine or chicken broth\n" +
                        "1 tablespoon lemon juice\n" +
                        "Minced fresh parsley, optional\n ",
                "Step 1: In a shallow bowl, mix flour, salt and pepper. " +
                        "Pound chicken breasts with a meat mallet to 1/2-in. thickness. " +
                        "Step 2: Dip chicken in flour mixture to coat both sides; shake off excess.\n" +
                        "In a large skillet, heat butter over medium heat. Brown chicken on both sides. " +
                        "Add wine; bring to a boil. Reduce heat; simmer, uncovered, " +
                        "until chicken is no longer pink, 12-15 minutes. Drizzle with lemon juice. " +
                        "If desired, sprinkle with parsley.\n "));
        recipeList.add(new Recipe(
                "Li’l Cheddar Meat Loaves ",
                "1 large egg\n" +
                        "¾ cup whole milk\n" +
                        "1 cup shredded cheddar cheese\n" +
                        "½ cup quick-cooking oats\n" +
                        "½ cup chopped onion\n" +
                        "½ teaspoon salt\n" +
                        "1 pound ground beef\n" +
                        "⅔ cup ketchup\n" +
                        "½ cup packed brown sugar\n" +
                        "1 teaspoon prepared mustard\n ",
                "Step 1: In a large bowl, whisk egg and milk. Stir in the cheese, " +
                        "oats, onion and salt. Crumble beef over mixture and mix well. " +
                        "Shape into 8 loaves; place in a greased 13x9-in. baking dish. " +
                        "In a small bowl, combine the ketchup, brown sugar and mustard; spoon over loaves.\n" +
                        "Step 2: Bake, uncovered, at 350° for 25-30 minutes or until no pink remains " +
                        "and a thermometer reads 160°.\n "));
        recipeList.add(new Recipe(
                "Chicken Pasta ",
                "1 tablespoon olive oil\n" +
                        "1 brown onion, chopped\n" +
                        "2 garlic cloves, crushed\n" +
                        "1 x 800g can Italian diced tomatoes\n" +
                        "1 tablespoon tomato paste\n" +
                        "1/3 cup chopped fresh continental parsley\n" +
                        "1/2 teaspoon caster sugar\n" +
                        "Salt & freshly ground black pepper\n" +
                        "400gr penne rigate\n ",
                "Step 1: Heat the oil in a large frying pan over medium heat. " +
                        "Add the onion and cook, uncovered, stirring often, for 3 minutes or until it softens slightly. " +
                        "Add the garlic and cook, stirring, for 1 minute or until aromatic. \n" +
                        "Step 2: Stir in the tomatoes and tomato paste. Increase heat to high and bring to the boil. " +
                        "Reduce heat to medium and simmer, uncovered, stirring often, " +
                        "for 6-7 minutes or until the sauce reduces and thickens slightly.\n" +
                        "Step 3: Stir in the parsley and sugar. Taste and season with salt and pepper." +
                        "Step 4: Meanwhile, cook the pasta in a large saucepan of salted boiling water " +
                        "following packet directions or until al dente. Drain and return to the pan.\n" +
                        "Add the sauce to the pasta and toss to combine. Serve immediately.\n"));
        recipeList.add(new Recipe(
                "Saag Paneer ",
                "2 large eggs\n" +
                        "1 tbsp vegetable oil\n" +
                        "1 red onion , finely sliced\n" +
                        "115g paneer , cut into 2-3cm, cubes\n" +
                        "2 tbsp medium curry powder\n" +
                        "250 g frozen spinach\n" +
                        "200g cooked coconut rice pouch\n" +
                        "½ red chilli , finely sliced (optional)\n ",
                " "));
        recipeList.add(new Recipe(
                " ",
                " ",
                " "));
    }

    public static Recipes getInstance(){return recipes; }
    public List<Recipe> getRecipeList(){return recipeList;}

}


