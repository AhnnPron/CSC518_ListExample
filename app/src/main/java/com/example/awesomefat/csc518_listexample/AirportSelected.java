package com.example.awesomefat.csc518_listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class AirportSelected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_selected);
        this.filterET = this.findViewById(R.id. filterET);
    }
    public EditText filterET;

    public void run()
    {
        try
        {
            URL flightsURL = new URL("https://www.flightsfrom.com/" + filterET.getText().toString() + "/destinations");
            HttpURLConnection conn = (HttpURLConnection)flightsURL.openConnection(); //opens url given at airportURL
            Scanner input = new Scanner(conn.getInputStream()); //scans document
            String data = "";

            while(input.hasNext()) //while going through the CSV
            {
                data = data + input.nextLine();
            }
            System.out.println("***" + data);
            String[] parts = data.split("airport-content-destination-listitem");
            String beforeVal = "airport-destination-items\">";
            String afterVal = "</ul>";
            int beforeIndex, afterIndex;

            for(String part : parts)
            {
                beforeIndex = part.indexOf(beforeVal);
                if(beforeIndex != -1)
                {
                    beforeIndex += beforeVal.length();
                    afterIndex = part.indexOf(afterVal, beforeIndex);
                    System.out.println("***" + part.substring(beforeIndex, afterIndex));
                }
            }
            System.out.println("*** Done"); //just checking to see if it worked
        }
        catch(Exception e)
        {
            System.out.println("***" + e.toString());
        }
    }
}
