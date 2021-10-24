package me.study.effetivejava.item02;

public class PizzaClient {
    public static void main(String[] args) {
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
                .addToppings(Pizza.Topping.HAM)
                .addToppings(Pizza.Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addToppings(Pizza.Topping.MUSHROOM)
                .sauceInsde()
                .build();
    }
}
