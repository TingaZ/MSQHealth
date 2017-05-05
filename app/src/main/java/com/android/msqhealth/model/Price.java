package com.android.msqhealth.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by sihlemabaleka on 5/5/17.
 */


@ParseClassName("Price")
public class Price extends ParseObject {

    public int getRetailPrice() {
        return getInt("retail");
    }

    public int getDistributorPrice() {
        return getInt("distributor");
    }

    public int getMemberPricing() {
        return getInt("member");
    }
}
