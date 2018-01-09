package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {
    private boolean rollWithSezam;
    private int burgers;
    private String sauce;
    private List<String> ingredients;

    public static class BigmacBuilder {
        private boolean rollWithSezam;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        public BigmacBuilder rollWithSezam(boolean rollWithSezam) {
            this.rollWithSezam = rollWithSezam;
            return this;
        }

        public BigmacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigmacBuilder sauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(String ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(rollWithSezam, burgers, sauce, ingredients);
        }
    }

    private Bigmac(boolean rollWithSezam, int burgers, String sauce, List<String> ingredients) {
        this.rollWithSezam = rollWithSezam;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public boolean isRollWithSezam() {
        return rollWithSezam;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "rollWithSezam=" + rollWithSezam +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
