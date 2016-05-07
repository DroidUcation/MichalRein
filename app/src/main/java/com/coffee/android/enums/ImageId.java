package com.coffee.android.enums;

import com.coffee.android.R;

/**
 * Created by user on 04/05/2016.
 */
public enum ImageId {
    COFFEE_TYPE(R.drawable.coffee_type),
    COFFEE_IN_THE_GLOBAL_ECONOMY(R.drawable.coffee_in_the_global_economy),
    COFFEE_PRODUCTION_AND_LABOR(R.drawable.coffee_production_and_labor),
    COFFEE_AND_THE_ENVIRONMENT(R.drawable.coffe_and_the_environment),;

    private final int id;

    ImageId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
