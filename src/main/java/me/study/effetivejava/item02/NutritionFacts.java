package me.study.effetivejava.item02;

public class NutritionFacts {

    private int servingSize;
    private int sodium;
    private int carbohydrate;
    private int servings;
    private int calories;

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public NutritionFacts(int serviingSize, int sodium, int carbohydrate, int servings, int calories) {
        this.servingSize = serviingSize;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
        this.servings = servings;
        this.calories = calories;
    }

    public NutritionFacts() {
    }

    public static void main(String[] args) {
        // 생성자로 값 넣기
        // 단점 : 매개변수로 들어가는 값이 무슨 필드인지 알기 어렵다
        NutritionFacts nutritionFacts = new NutritionFacts(1, 6, 10, 20, 100);

        // 자바빈 (Setter 로 값 넣기)
        // 단점 : 최종 인스턴스가 셋팅되기까지 여러번 호출을 거쳐야 한다 (자바빈이 setSodium까지만 셋팅된 상태로 사용될 수 있다 -> 불안정하다)
        // 단점 : setter, getter 가 존재하면 불변 클래스로 만들지 못한다. (쓰레드간 공유 가능한 상태가 되므로, 멀티 쓰레드 환경애선 안정성을 보장하기 위해 Locking 과 같은 추가 작업이 필요하다)
        NutritionFacts cocaCola = new NutritionFacts();
        cocaCola.setServingSize(1);
        cocaCola.setSodium(6);
        cocaCola.setCarbohydrate(10);
        cocaCola.setServings(20);
        cocaCola.setCalories(100);

        // 빌더
        // 필수 매개변수를 주면서 호출해 Builder 객체를 얻고, 이후 옵셔널한 값은 setter와 유사하게 셋팅한 뒤 build()로 최종 인스턴스를 생성
    }
}
