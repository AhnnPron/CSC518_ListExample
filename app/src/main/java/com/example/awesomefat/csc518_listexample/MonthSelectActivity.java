package com.example.awesomefat.csc518_listexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MonthSelectActivity extends AppCompatActivity
{

    private String airportCode;
    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_select);

        this.airportCode = this.getIntent().getStringExtra("airportCode");
        this.cityName = this.getIntent().getStringExtra("cityName");
    }

    public void monthButtonPressed(View v)
    {
        Button b = (Button)v;
        String buttonText = b.getText().toString();

//building arrays for Months by number, name, and days within the month
        String[] monthNumbers = "01,02,03,04,05,06,07,08,09,10,11,12".split(",");
        String[] monthLastDays = "31,28,31,30,31,30,31,31,30,31,30,31".split(",");
        String monthNum = "";
        String monthLastDay = "";

        String[] months = "Jan,Feb,March,April,May,June,July,August,Sept,Oct,Nov,Dec".split(",");
        //Search through Months until we find a match on button text
        //when buttonText = months -->spit out the month
        for(int i = 0; i < months.length; i++)
        {
            if(months[i].equals(buttonText))
            {
                monthNum = monthNumbers[i]; //put the corresponding number for that month into the empty string (now it's a variable)
                monthLastDay = monthLastDays[i]; //put the corresponding last day for that month into the empty string (now it's a variable)
                break;
            }
        }
        Intent i = new Intent(this, AirportMonthDetailActivity.class);
        //within this Intent, do the following as well:
        i.putExtra("monthNum", monthNum); //("" + value)
        i.putExtra("monthLastDay", monthLastDay);
        i.putExtra("airportCode", this.airportCode);
        i.putExtra("cityName", this.cityName);
        this.startActivity(i);
    }
}
