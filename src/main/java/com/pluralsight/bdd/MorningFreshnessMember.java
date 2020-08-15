package com.pluralsight.bdd;

public class MorningFreshnessMember {

    private String name;
    private SuperSmoothieSchema superSmoothieSchema;
    private int points;

    public MorningFreshnessMember(String name, SuperSmoothieSchema superSmoothieSchema) {
        this.name = name;
        this.superSmoothieSchema = superSmoothieSchema;
    }

    public void orders(Integer amount, String drink) {
        points += superSmoothieSchema.getPointsFor(drink) * amount;
    }

    public Integer getPoints() {
        return points;
    }
}
