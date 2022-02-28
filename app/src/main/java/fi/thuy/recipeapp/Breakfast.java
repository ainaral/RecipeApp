package fi.thuy.recipeapp;

import java.util.ArrayList;
import java.util.List;

public class Breakfast {


    private final List<Recipe> breakfastList;
    private static final Breakfast recipes = new Breakfast();

    private Breakfast(){
        breakfastList = new ArrayList<>();
        breakfastList.add(new Recipe(
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
    }

    public static Breakfast getInstance(){return recipes; }
    //public List<Recipe> getBreakfastList(){return BreakfastList;}
}
