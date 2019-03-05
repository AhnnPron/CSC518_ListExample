package com.example.awesomefat.csc518_listexample;

import android.widget.ArrayAdapter;

//singleton - a class filled with stuff acccccebile by everything
public class Core
{
    public static LinkedListOfCreditCards theCreditCardsLL = new LinkedListOfCreditCards();
    public static LinkedListOfLoyaltyPrograms theLoyaltyProgramsLL = new LinkedListOfLoyaltyPrograms();
    public static CreditCardArrayAdapterForLinkedLists ccCustomAdapter;
    public static LoyaltyProgramArrayAdapterForLinkedLists lpCustomAdapter;

    //create card and store in Firebase (maybe move this to CORE hint hint)
    CreditCard cc = new CreditCard("Chase Sapphire", "1/1/19", 3000, 50000);
    //creditCardRef.push().setValue(cc); //create a collection of creditCards; creates a unique entry for each

    LoyaltyProgram lp = new LoyaltyProgram("Freaking Awesome Rewards", "PotOGold", 1 );

    //encapsulated
    public static void addLoyaltyProgram(LoyaltyProgram lp)
    {
        //happens in a static context
        Core.theLoyaltyProgramsLL.addAtEnd(lp);
        Core.lpCustomAdapter.notifyDataSetChanged();
    }

    public static void addCreditCard(CreditCard cc)
    {
        Core.theCreditCardsLL.addEnd(cc);
        Core.ccCustomAdapter.notifyDataSetChanged();
    }
}
