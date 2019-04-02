package com.example.awesomefat.csc518_listexample;

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
        setContentView(R.layout.activity_edit_loyalty_program);

        this.loyaltyProgramNameET = (EditText)this.findViewById(R.id.loyaltyNameET);
        this.loyaltyProgramBankET = (EditText)this.findViewById(R.id.loyaltyBankNameET);
        this.loyaltyProgramPointsBalanceET = (EditText)this.findViewById(R.id.loyaltyCurrPointsET);

        this.loyaltyProgramNameET.setText(Core.currentSelectedLoyaltyProgram.name);
        this.loyaltyProgramBankET.setText(Core.currentSelectedLoyaltyProgram.bank + "");
        this.loyaltyProgramPointsBalanceET.setText(Core.currentSelectedLoyaltyProgram.point_balance + "");

    }

    public void onDeleteButtonPressed(View v)
    {
        Core.currentSelectedLoyaltyProgram.delete();
        this.finish();
    }

    public void onUpdateButtonPressed(View v)
    {

        String loyaltyProgramName = this.loyaltyProgramNameET.getText().toString();
        String loyaltyProgramBank = this.loyaltyProgramBankET.getText().toString();
        int loyaltyProgramPointsBalance = Integer.parseInt(this.loyaltyProgramPointsBalanceET.getText().toString());

        Core.currentSelectedLoyaltyProgram.name = loyaltyProgramName;
        Core.currentSelectedLoyaltyProgram.bank = loyaltyProgramBank;
        Core.currentSelectedLoyaltyProgram.point_balance = loyaltyProgramPointsBalance;
        Core.currentSelectedLoyaltyProgram.save();
        this.finish();
    }
}
