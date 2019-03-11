package com.example.awesomefat.csc518_listexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditLoyaltyProgramActivity extends AppCompatActivity
{

    private EditText loyaltyProgramNameET, loyaltyProgramBankET, loyaltyProgramPointsBalanceET;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loyalty_program);

        this.loyaltyProgramNameET = (EditText)this.findViewById(R.id.loyaltyProgramNameET);
        this.loyaltyProgramBankET = (EditText)this.findViewById(R.id.loyaltyProgramBankET);
        this.loyaltyProgramBankET = (EditText)this.findViewById(R.id.loyaltyProgramPointBalanceET);

        this.loyaltyProgramNameET.setText(Core.currentSelectedProgram.name);
        this.loyaltyProgramBankET.setText(Core.currentSelectedProgram.bank + "");
        this.loyaltyProgramPointsBalanceET.setText(Core.currentSelectedProgram.point_balance + "");

    }

    public void onDeleteButtonPressed(View v)
    {
        Core.currentSelectedProgram.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {
        String loyaltyProgramName = this.loyaltyProgramNameET.getText().toString();
        String loyaltyProgramBank = this.loyaltyProgramBankET.getText().toString();
        int loyaltyProgramPointsBalance = Integer.parseInt(this.loyaltyProgramPointsBalanceET.getText().toString());

        Intent i = new Intent(this, AddLoyaltyProgramActivity.class);
        this.startActivity(i);

        LoyaltyProgram lp = new LoyaltyProgram(loyaltyProgramName, loyaltyProgramBank, loyaltyProgramPointsBalance);
        Core.addLoyaltyProgramLocally(lp);

        this.finish();
    }
}
