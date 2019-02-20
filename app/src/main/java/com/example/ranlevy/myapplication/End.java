package com.example.ranlevy.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class End extends AppCompatActivity {
    int s = 0;
    Button sButton;

    long teamNumber;
    long autoSwitchCount;
    long autoScaleCount;
    long autoLineCount;
    long SwitchCount;
    long ScaleCount;
    long ExchangeCount;
    long ClimbAloneCount;
    long toString;
    long autoexchangeCount;
    long ClimbNotAloneCount;
    long HelpedToClimb;
    long Theydidnotclimb;
    long EnemySwitchCount;
    String matchNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        Intent intent = getIntent();
        this.teamNumber = intent.getLongExtra("teamNumber", 0);
        this.autoSwitchCount = intent.getLongExtra("autoSwitchCount", 0);
        this.autoScaleCount = intent.getLongExtra("autoScaleCount", 0);
        this.autoLineCount = intent.getLongExtra("autoLineCount", 0);
        this.SwitchCount = intent.getLongExtra("SwitchCount", 0);
        this.ScaleCount = intent.getLongExtra("ScaleCount", 0);
        this.ExchangeCount = intent.getLongExtra("ExchangeCount", 0);
        this.ClimbAloneCount = intent.getLongExtra("ClimbAloneCount", 0);
        this.autoexchangeCount = intent.getLongExtra("autoexchangeCount", 0);
        this.HelpedToClimb = intent.getIntExtra("HelpedToClimb", 0);
        this.Theydidnotclimb = intent.getIntExtra("Theydidnotclimb", 0);
        this.EnemySwitchCount = intent.getLongExtra("EnemySwitchCount", 0);
        this.matchNumber = "Qual_"+getApplicationContext().getSharedPreferences("match_number", Context.MODE_PRIVATE).getString("match_number","0000");


        this.sButton = (Button) findViewById(R.id.sButton);
    }

    public void save(View view) {

        if (s < 1) {
            // Write a message to the database
            FirebaseDatabase database = FirebaseDatabase.getInstance();



            DatabaseReference myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/autoSwitch");
            myRef.setValue(this.autoSwitchCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/autoScale");
            myRef.setValue(this.autoScaleCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/autoLine");
            myRef.setValue(this.autoLineCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/Switch");
            myRef.setValue(this.SwitchCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/Scale");
            myRef.setValue(this.ScaleCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/Exchange");
            myRef.setValue(this.ExchangeCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/ClimbAlone");
            myRef.setValue(this.ClimbAloneCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/autoexchange");
            myRef.setValue(this.autoexchangeCount);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/HelpedToClimb");
            myRef.setValue(this.HelpedToClimb);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/Theydidnotclimb");
            myRef.setValue(this.Theydidnotclimb);
            myRef = database.getReference("Scores/" + this.teamNumber + "/" + this.matchNumber + "/EnemySwitchCount");
            myRef.setValue(this.EnemySwitchCount);


            this.sButton.setText("הוגש");

        }
    }

    public void NewGame(View view) {
        Intent intent = new Intent(this, TeamSelectActivity.class);
        startActivity(intent);
    }
}
