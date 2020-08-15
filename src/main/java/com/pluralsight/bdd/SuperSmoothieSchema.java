package com.pluralsight.bdd;

import java.util.HashMap;
import java.util.Map;

public class SuperSmoothieSchema {

    private Map<String, Integer> pointsPerCategory = new HashMap<>();
    private DrinkCatalog drinkCatalog;

    public SuperSmoothieSchema(DrinkCatalog drinkCatalog) {
        this.drinkCatalog = drinkCatalog;
    }

    public void setPointsPerCategory(String category, Integer points) {
        pointsPerCategory.put(category, points);
    }

    public int getPointsFor(String drink) {
        return pointsPerCategory.get(categoryOf(drink));
    }

    private String categoryOf(String drink) {
        return drinkCatalog.getCategoryOf(drink);
    }
}
