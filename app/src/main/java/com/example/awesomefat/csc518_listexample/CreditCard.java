package com.example.awesomefat.csc518_listexample;

import java.io.Serializable;

//Serializing an object means turning an object into a textual form (probably JSON)
//Java has a Serializable interface which tells java you have to set up your object in order to be serialized
public class CreditCard implements Serializable
{
    //make fields public in order to serialize
    public String name;
    public String start_date;
    public int min_spend;
    public int point_bonus;

    public CreditCard(String name, String start_date, int min_spend, int point_bonus)
    {
        this.name = name;
        this.start_date = start_date;
        this.min_spend = min_spend;
        this.point_bonus = point_bonus;
    }

    //no argument constructor required for de-serialization
    public CreditCard()
    {
        //we don't need this right now
    }

    public String getName()
    {
        return name;
    }

    public String getStart_date() {
        return start_date;
    }

    public int getMin_spend() {
        return min_spend;
    }

    public int getPoint_bonus() {
        return point_bonus;
    }

    public String toString()
    {
        return "Name: " + this.name +
                " (" + this.start_date + ") - Min Spend: "
                + this.min_spend + " - Bonus: " + this.point_bonus;
    }

    public void display()
    {
        System.out.println("*****Name: " + this.name +
                " (" + this.start_date + ") - Min Spend: "
        + this.min_spend + " - Bonus: " + this.point_bonus);
    }

}
