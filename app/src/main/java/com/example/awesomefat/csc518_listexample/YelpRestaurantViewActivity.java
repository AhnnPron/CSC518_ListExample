package com.example.awesomefat.csc518_listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class YelpRestaurantViewActivity extends AppCompatActivity
{
    private TextView locationTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yelp_restaurant_view);

        this.locationTV = this.findViewById(R.id.locationTV);
        String location = Core.currTree.payload.city;
    }
}
