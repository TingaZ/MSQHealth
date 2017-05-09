package com.android.msqhealth.fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.msqhealth.R;
import com.android.msqhealth.model.Product;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class ViewProductsFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ViewProductsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            final RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            ParseQuery<Product> query = ParseQuery.getQuery(Product.class);
            query.include("identifier");
            query.include("attributes");
            query.fromLocalDatastore();
            query.findInBackground(new FindCallback<Product>() {
                @Override
                public void done(List<Product> objects, ParseException e) {
                    if (e == null) {
                        if (objects.size() > 0) {
                            for (Product product : objects) {
                                recyclerView.setAdapter(new MyProductViewAdapter(objects, getActivity()));
                            }
                        } else {
                            Toast.makeText(getActivity(), "No Objects Found", Toast.LENGTH_LONG).show();
                            ParseQuery<Product> query = ParseQuery.getQuery(Product.class);
                            query.include("identifier");
                            query.include("attributes");
                            query.findInBackground(new FindCallback<Product>() {
                                @Override
                                public void done(List<Product> objects, ParseException e) {
                                    ParseObject.pinAllInBackground(objects);
                                    if (e == null) {
                                        if (objects.size() > 0) {
                                            for (Product product : objects) {
                                                recyclerView.setAdapter(new MyProductViewAdapter(objects, getActivity()));
                                            }
                                        } else {
                                            Toast.makeText(getActivity(), "No Objects Found", Toast.LENGTH_LONG).show();
                                        }
                                    } else {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    } else {
                        ParseQuery<Product> query = ParseQuery.getQuery(Product.class);
                        query.include("identifier");
                        query.include("attributes");
                        query.findInBackground(new FindCallback<Product>() {
                            @Override
                            public void done(List<Product> objects, ParseException e) {
                                ParseObject.pinAllInBackground(objects);
                                if (e == null) {
                                    if (objects.size() > 0) {
                                        for (Product product : objects) {
                                            recyclerView.setAdapter(new MyProductViewAdapter(objects, getActivity()));
                                        }
                                    } else {
                                        Toast.makeText(getActivity(), "No Objects Found", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });

        }
        return view;
    }

}
