package com.example.awesomefat.csc518_listexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;

public class AirportTree extends AppCompatActivity
{
    private TextView airportTV;
    private Button leftButton, rightButton;
    private BTreeNode leftChild, rightChild;
    private String airportCode;
    private LinkedList<String> theAirportStrings = new LinkedList<String>();
    private LinkedList<Airport> theFilteredAirports = new LinkedList<Airport>();
    private LinkedList<Airport> theAirports = new LinkedList<Airport>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_tree);

        //this.leftChild =
        //this.rightChild =
        //this.airportCode =

        this.airportTV = this.findViewById(R.id.airportTV);
        this.leftButton = this.findViewById(R.id.leftButton);
        this.rightButton = this.findViewById(R.id.rightButton);
    }

    private void hide()
    {
        if(this.leftChild == null);
        {
            this.leftButton.setVisibility(View.INVISIBLE);
        }
        if(this.rightChild == null);
        {
            this.rightButton.setVisibility(View.INVISIBLE);
        }
    }
    public void onLeftButtonClicked(View v)
    {
        Intent i = new Intent(this, LeftAirport.class);
        //i.putExtra("airportCode", ***.airportCode);
        this.startActivity(i);
    }

    public void onRightButtonClicked(View v)
    {
        Intent i = new Intent(this, RightAirport.class);
        //i.putExtra("airportCode", ***.airportCode);
        this.startActivity(i);
    }
}
