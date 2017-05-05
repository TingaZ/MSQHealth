package com.android.msqhealth.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by sihlemabaleka on 5/5/17.
 */

@ParseClassName("Attributes")
public class Attributes extends ParseObject {

    public Price getPrice() {
        return (Price) getParseObject("product_pricing");
    }

    public String getStorageType() {
        return getString("storage");
    }

    public String getProductSize() {
        return getString("size");
    }

    public String getProductCode() {
        return getString("product_code");
    }

    public int getProductQuantity() {
        return getInt("quantity");
    }

    public String getImageUrl() {
        return getParseFile("product_image").getUrl();
    }
}
