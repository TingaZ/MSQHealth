package com.android.msqhealth.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by sihlemabaleka on 5/5/17.
 */

@ParseClassName("Products")
public class Product extends ParseObject {

    Attributes attributes;
    ProductIdentifier identifier;


    public Attributes getAttributes() {
        return (Attributes) getParseObject("attributes");
    }

    public ProductIdentifier getIdentifier() {
        return (ProductIdentifier) getParseObject("identifier");
    }
}
