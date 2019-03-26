package com.example.awesomefat.csc518_listexample;

import android.content.Intent;
import android.net.Network;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class NetworkThread extends Thread
{
    private String airportCode;
    public NetworkThread()
    {
        this.airportCode = airportCode;

    }
    public void run()
    {
        try
        {
            URL airportURL = new URL("http://ourairports.com/data/airports.csv");
            //URL flightsURL = new URL("https://www.flightsfrom.com/" + "MKE" + "/destinations");
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection(); //opens url given at airportURL
            Scanner input = new Scanner(conn.getInputStream()); //scans document
            String data = "";

            while(input.hasNext()) //while going through the CSV
            {
                data = data + input.nextLine();
            }
            System.out.println("***" + data);
            String[] parts = data.split("airport-content-destination-list-name");
            String beforeVal = "destination-search-item\">";
            String afterVal = "</span>";
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
