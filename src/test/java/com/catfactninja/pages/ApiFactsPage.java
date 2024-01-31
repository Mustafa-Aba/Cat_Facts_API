package com.catfactninja.pages;

import java.util.Random;

public class ApiFactsPage extends ApiBasePage {
    Random random = new Random();
    private int limit;
    private int max_length;

    public void setLimitParameter() {
        limit = random.nextInt(98) + 1;
    }

    public void setMaxLengthParameter() {
        max_length = random.nextInt(10) + 20;
    }

    public int getLimit() {
        return limit;
    }

    public int getMax_length() {
        return max_length;
    }
}



