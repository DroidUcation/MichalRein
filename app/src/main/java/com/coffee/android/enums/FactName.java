package com.coffee.android.enums;

/**
 * Created by user on 04/05/2016.
 */
public enum FactName {
    COFFEE_TYPE("COFFEE TYPE"),
    COFFEE_IN_THE_GLOBAL_ECONOMY("COFFEE IN THE GLOBAL ECONOMY"),
    COFFEE_PRODUCTION_AND_LABOR("COFFEE PRODUCTION AND LABOR"),
    COFFEE_AND_THE_ENVIRONMENT("COFFEE AND THE ENVIRONMENT"), ;

    private final String id;

    FactName(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
