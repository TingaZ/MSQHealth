package com.android.msqhealth.app;

import android.app.Application;

import com.android.msqhealth.model.Attributes;
import com.android.msqhealth.model.Price;
import com.android.msqhealth.model.Product;
import com.android.msqhealth.model.ProductIdentifier;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by sihlemabaleka on 5/5/17.
 */

public class AppController extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(ProductIdentifier.class);
        ParseObject.registerSubclass(Product.class);
        ParseObject.registerSubclass(Attributes.class);
        ParseObject.registerSubclass(Price.class);

        Parse.enableLocalDatastore(this);

        Parse.initialize(this);

    }
}
