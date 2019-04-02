package com.example.awesomefat.csc518_listexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class AirportDetail2 extends AppCompatActivity
{
    private ListView destinationsLV;
    private AirportDetail2 myself;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_detail2);
        TextView airportTV = this.findViewById(R.id.textView2);
        this.destinationsLV = this.findViewById(R.id.airportDetail2LV);
        this.myself = this;

        LinkedList<String> ll = new LinkedList<String>();
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.destinationsLV.setAdapter(aa);

        String airportCode = Core.airportCode;

        //strip the " from both ends of the airport code
        //airportCode = airportCode.replaceAll("\"","");


        airportTV.setText(airportCode);
        NetworkThread nt = new NetworkThread(airportCode, aa, ll);
        nt.setPriority(Thread.MAX_PRIORITY);
        nt.start();

        this.destinationsLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(myself, AirportDetail2.class);
                String selectedFlight = (String)myself.destinationsLV.getItemAtPosition(position);
                Core.airportCode = selectedFlight.substring(selectedFlight.length() - 3);
                finish();
                startActivity(getIntent());
            }
        });
    }
}