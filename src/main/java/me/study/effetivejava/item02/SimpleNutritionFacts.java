package me.study.effetivejava.item02;

public class SimpleNutritionFacts {

    private int servingSize;
    private int servings;
    private int sodium;
    private int carbohydrate;
    private int calories;

    public static class Builder {
        // 필수 매개변수
        private final int servingSize;
        private final int servings;

        // 선택 매개변수 - 기본값으로 초기화한다.
        private int sodium = 0;
        private int carbohydrate = 0;
        private int calories = 0;

        // 생정자
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val; return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val; return this;
        }

        public Builder sodium(int val) {
            sodium = val; return this;
        }

        public SimpleNutritionFacts build(){
            return new SimpleNutritionFacts(this);
        }
    }

    private SimpleNutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }
}
