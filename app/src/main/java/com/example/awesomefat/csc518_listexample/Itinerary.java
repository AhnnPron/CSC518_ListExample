package com.example.awesomefat.csc518_listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class Itinerary extends AppCompatActivity {

    private ListView itineraryLV;
    private ArrayAdapter<String> aa;
    private LinkedList<String> theItinerary = new LinkedList<String>();
    private Itinerary myself;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinerary);

        this.myself = this;
        this.itineraryLV = this.findViewById(R.id.itineraryLV);
        aa = new ArrayAdapter<String>(this, R.layout.another_row, this.theItinerary);
        itineraryLV.setAdapter(aa);
    }

}
