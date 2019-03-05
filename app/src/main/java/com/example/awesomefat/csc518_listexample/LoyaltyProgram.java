package com.example.awesomefat.csc518_listexample;

import java.io.Serializable;

public class LoyaltyProgram implements Serializable
{
    public String name;
    public String bank;
    public int point_balance;

    public LoyaltyProgram(String name, String bank)
    {
        this.name = name;
        this.bank = bank;
        this.point_balance = 0;
    }

    public LoyaltyProgram(String name, String bank, int point_balance)
    {
        this(name, bank);
        this.point_balance = point_balance;
    }

    //no argument constructor required for de-serialization
    public LoyaltyProgram()
    {

    }

    public String toString()
    {
        return this.name + " - " + this.bank + " - " + this.point_balance;
    }

    public void display()
    {
        System.out.println(this.name + " - " + this.bank + " - " + this.point_balance);
    }

    public String getName() {
        return name;
    }

    public String getBank() {
        return bank;
    }

    public int getPoint_balance() {
        return point_balance;
    }
}
