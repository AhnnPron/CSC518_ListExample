package com.example.awesomefat.csc518_listexample;

import com.example.awesomefat.csc518_listexample.Core;
import com.google.firebase.database.DatabaseReference;

import java.io.Serializable;

//Serializing an object means turning an object into a textual form (probably JSON)
//Java has a Serializable interface which tells java you have to set up your object in order to be serialized
public class CreditCard implements Serializable
{
    //Making it Serializable requires two things: public and no argument constructor
    //make fields public in order to serialize
    public String name;
    public String start_date;
    public int min_spend;
    public int point_bonus;
    private String key;
    private DatabaseReference ref;

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
    public void save()
    {
        //save to the database the current state
        this.ref.setValue(this);
    }

    public void delete() //deletes from the database
    {
        this.ref.removeValue();
    }
    public void setKey(String key)
    {
        this.key = key;
        this.ref = Core.creditCardRef.child(this.key);
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
