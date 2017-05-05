package com.android.msqhealth;

import android.app.Activity;
import android.os.Bundle;

import com.android.msqhealth.fragments.ViewProductsFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container);

        getFragmentManager().beginTransaction().add(R.id.container, new ViewProductsFragment()).commit();


    }
}
