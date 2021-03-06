package com.example.awesomefat.csc518_listexample;

import android.os.Handler;
import android.os.Looper;
import android.widget.ArrayAdapter;

import com.google.firebase.database.DatabaseReference;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class NetworkThread extends Thread
{
    private String airportCode;
    private ArrayAdapter<String> theArrayAdapter;
    private LinkedList<String> theDestinationStrings;
    private NetworkThread myself;

    public NetworkThread(String airportCode, ArrayAdapter<String> theArrayAdapter, LinkedList<String> theDestinationStrings)
    {
        this.airportCode = airportCode;
        this.theArrayAdapter = theArrayAdapter;
        this.theDestinationStrings = theDestinationStrings;
        this.myself = this;
    }

    public void run()
    {
        try
        {
            URL airportURL = new URL("https://www.flightsfrom.com/" + this.airportCode + "/destinations");

            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("*** HAVE DATA!!!!!");
            //System.out.println("***" + data);
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
                    //System.out.println("***" + part.substring(beforeIndex, afterIndex));
                    this.theDestinationStrings.add(part.substring(beforeIndex, afterIndex));
                }
            }
            System.out.println("*** Done");

            new Handler(Looper.getMainLooper()).post(new Runnable () {
                @Override
                public void run () {
                    myself.theArrayAdapter.notifyDataSetChanged();
                }
            });


        }
        catch(Exception e)
        {
            System.out.println("***" + e.toString());
        }
    }
}