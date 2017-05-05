package com.android.msqhealth.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by sihlemabaleka on 5/5/17.
 */

@ParseClassName("Product_Identifier")
public class ProductIdentifier extends ParseObject {

    public String getName() {
        return getString("name");
    }

    public String getDescription() {
        return getString("description");
    }

}
