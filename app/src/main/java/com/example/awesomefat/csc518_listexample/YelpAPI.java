package com.example.awesomefat.csc518_listexample;

import android.widget.ArrayAdapter;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class YelpAPI extends Thread
{
    private String city;
    private ArrayAdapter<String> theArrayAdapter;
    private LinkedList<String> theRestaurantsStrings;
    private YelpAPI myself;

    public YelpAPI (String city, ArrayAdapter<String> theArrayAdapter, LinkedList<String> theRestaurantsStrings)
    {
        this.city = city;
        this.theArrayAdapter = theArrayAdapter;
        this.theRestaurantsStrings =  theRestaurantsStrings;
        this.myself = this;
    }

    public void run()
    {
        try
        {
            URL airportURL = new URL("https://api.yelp.com/v3/businesses/search?location=" + this.city + "&categories=restaurants");
            HttpURLConnection conn = (HttpURLConnection)airportURL.openConnection();
            conn.setRequestProperty("Authorization", "Bearer _J4oFzYD9pM9tvWdATLSkaR-tkgG8JqupTEoARaujmbCghAIxX6lu0MPv68virY0RAvEfWtLIw2m5wH-Eujh9qI-HZ-ix8vFq9ajMta7Ne6kXUer5QPEHd0FnRO7NXHYx");
            Scanner input = new Scanner(conn.getInputStream());
            String data = "";

            while(input.hasNextLine())
            {
                data = data + input.nextLine();
            }
            input.close();
            System.out.println("*** DATA: " + data);
            JSONObject obj = new JSONObject(data);
            JSONArray businesses = obj.getJSONArray("businesses");

            for(int i = 0; i < businesses.length(); i++)
            {
                String name = businesses.getJSONObject(i).getString("name");
                String url = businesses.getJSONObject(i).getString("url");
                Integer rating = businesses.getJSONObject(i).getInt("rating");
                Integer reviewCount = businesses.getJSONObject(i).getInt("review_count");
                String address = businesses.getJSONObject(i).getString("location");
                String phone = businesses.getJSONObject(i).getString("phone");

                System.out.println("*** " + "Name: " + name +
                        " URL: " + url +
                        " Rating: " + rating +
                        " Number of Reviews: " + reviewCount +
                        " Address: " + address +
                        " Phone Number: " + phone);
            }
        }
        catch(Exception e)
        {
            System.out.println("*** " + e.toString());
        }
    }
}
