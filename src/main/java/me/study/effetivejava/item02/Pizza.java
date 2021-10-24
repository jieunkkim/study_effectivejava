package me.study.effetivejava.item02;

import java.util.EnumSet;
import java.util.Objects;

public abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION
    }

    final EnumSet<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {    // 재귀적인 type 매개변수 (Builder를 extends한 T를 리턴)
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addToppings(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings;
    }

}
