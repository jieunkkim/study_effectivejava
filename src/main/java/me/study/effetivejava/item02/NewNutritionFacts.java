package me.study.effetivejava.item02;


import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder
public class NewNutritionFacts {

    @Builder.Default private int servingSize = 10;
    private int sodium;
    private int carbohydrate;
    private int servings;
    @Singular private List<String> names;

    public int getServingSize(){
        return servingSize;
    }

    public static void main(String[] args) {
        NewNutritionFacts newNutritionFacts = NewNutritionFacts.builder()
                .servings(10)
                .servingSize(1)
                .name("jieun")
                .name("jieun22")
                .clearNames()
                .build();
        System.out.println(newNutritionFacts.getServingSize());

        newNutritionFacts = NewNutritionFacts.builder()
                .servings(10)
                .build();
        System.out.println(newNutritionFacts.getServingSize());
    }
}
