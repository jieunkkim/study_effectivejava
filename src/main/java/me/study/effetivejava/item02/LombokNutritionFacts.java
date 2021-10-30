package me.study.effetivejava.item02;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LombokNutritionFacts {
    @Builder.Default private int servingSize = 10;
    private int servings;
    private int sodium;
    private int carbohydrate;
    private int calories;

    public static void main(String[] args) {
        LombokNutritionFacts nutritionFacts = LombokNutritionFacts.builder().servings(5).build();
        System.out.println(nutritionFacts.getServingSize());
        System.out.println(nutritionFacts.getServings());
    }

}
