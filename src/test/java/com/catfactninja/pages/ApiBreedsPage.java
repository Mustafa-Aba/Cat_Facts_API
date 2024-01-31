package com.catfactninja.pages;

import java.util.Random;

public class ApiBreedsPage extends ApiBasePage {
    private int limit;

    public void setLimitParameter() {
        Random random = new Random();
        limit = random.nextInt(98) + 1;
    }

    public int getLimit() {
        return limit;
    }
}



