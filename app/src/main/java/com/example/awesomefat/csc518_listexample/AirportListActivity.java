package com.example.awesomefat.csc518_listexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.LinkedList;

public class AirportListActivity extends AppCompatActivity
{
    private ListView airportLV;
    private LinkedList<String> theAirportStrings = new LinkedList<String>();
    private LinkedList<Airport> theAirports = new LinkedList<Airport>();
    private ArrayAdapter<String> aa;

    public EditText filterET;

    private AirportListActivity currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_list);

        this.currentActivity = this;

        this.filterET = this.findViewById(R.id. filterET);
        this.airportLV = this.findViewById(R.id.airportLV);

        aa = new ArrayAdapter<String>(this, R.layout.another_row, this.theAirportStrings);
        this.airportLV.setAdapter(aa);

        this.airportLV.setClickable(true);
        this.airportLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                Intent i = new Intent(currentActivity, AirportSelected.class);
                currentActivity.startActivity(i);
            }
        });
        DatabaseReference ref = Core.database.getReference("world_airports");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                Airport temp;
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    temp = ds.getValue(Airport.class);
                    theAirports.add(temp);
                    theAirportStrings.add(temp.toString());
                }
                aa.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }

    public void onFilterButtonPressed(View v)
    {
        String filterString = this.filterET.getText().toString();
        this.theAirportStrings.clear(); //empty linked list
        for(Airport a : this.theAirports)
        {
            if(a.filterApplies(filterString))
            {
                this.theAirportStrings.add(a.toString());
            }
        }
        this.aa.notifyDataSetChanged();
    }
}

