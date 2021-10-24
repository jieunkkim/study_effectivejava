package me.study.effetivejava.item02;

public class Calzone extends Pizza {
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder>{
        private boolean sauseInside = false;

        public Builder sauceInsde(){
            sauseInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauseInside;
    }
}
