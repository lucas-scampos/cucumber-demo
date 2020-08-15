package com.pluralsight.bdd.loyalty_cards;

import com.pluralsight.bdd.DrinkCatalog;
import com.pluralsight.bdd.MorningFreshnessMember;
import com.pluralsight.bdd.SuperSmoothieSchema;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SuperSmoothieProgramStepDefinitions {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    private SuperSmoothieSchema superSmoothieSchema = new SuperSmoothieSchema(drinkCatalog);
    private MorningFreshnessMember lucas;

    @Given("the following drink categories")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
        drinkCategories.stream().forEach(drinkCategory -> {
            String drink = drinkCategory.get("Drink");
            String category = drinkCategory.get("Category");
            Integer points = Integer.parseInt(drinkCategory.get("Points"));

            drinkCatalog.addDrink(drink, category);
            superSmoothieSchema.setPointsPerCategory(category, points);
        });
    }

    @Given("^(.*) is a morning Freshness Member$")
    public void lucas_is_a_morning_Freshness_Member(String name) {
        lucas = new MorningFreshnessMember(name, superSmoothieSchema);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void lucas_purchases_Banana_drinks(String name, Integer amount, String drink) {
        lucas.orders(amount, drink);
    }

    @Then("he should earn {int} points")
    public void he_should_earn_Points_points(Integer expectedPoints) {
        assertThat(lucas.getPoints()).isEqualTo(expectedPoints);
    }
}
