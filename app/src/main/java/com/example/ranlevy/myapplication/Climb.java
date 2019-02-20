package com.example.ranlevy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class Climb extends AppCompatActivity {


    int ClimbAloneCount = 0;
    Button climbAloneIncButton;
    int HelpedToClimb= 0;
    Button HelpedToClimbButton;
    int Theydidnotclimb = 0;
    Button TheydidnotclimbIncButton;
    long teamNumber, autoSwitchCount, autoScaleCount, autoLineCount, SwitchCount, ScaleCount, ExchangeCount, toString, autoexchangeCount, Data, EnemySwitchCount;
    Button level0c;
    Button level1c;
    Button level2c;
    Button level3c;
    String climbLevel = "?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climb);
        Intent intent = getIntent();

        Log.d("STAM", "Climb");
        this.teamNumber = intent.getLongExtra("teamNumber", 0);
        this.autoSwitchCount = intent.getLongExtra("autoSwitchCount", 0);
        this.autoScaleCount = intent.getLongExtra("autoScaleCount", 0);
        this.autoLineCount = intent.getLongExtra("autoLineCount", 0);
        this.SwitchCount = intent.getIntExtra("SwitchCount", 0);
        this.ScaleCount = intent.getIntExtra("ScaleCount", 0);
        this.ExchangeCount = intent.getIntExtra("ExchangeCount", 0);
        this.autoexchangeCount = intent.getLongExtra("autoexchangeCount", 0);
        this.EnemySwitchCount = intent.getIntExtra("EnemySwitchCount", 0);


        this.level1c = (Button) findViewById(R.id.level1c);
        this.level2c = (Button) findViewById(R.id.level2c);
        this.level3c = (Button) findViewById(R.id.level3c);
        this.level0c = (Button) findViewById(R.id.level0c);

        final Button[] levelBtns = {level1c, level2c, level3c, level0c};
        final String[] originalLevelText = {"LEVEL 1", "LEVEL 2", "LEVEL 3", "LEVEL 0"};
        level1c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = "level 1";
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level1c.setText("climb: level 1");
            }
        });
        level2c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = "level 2";
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level2c.setText("climb: level 2");
            }
        });
        level3c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = "level 3";
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level3c.setText("climb: level 3");
            }
        });
        level0c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = "level 0";
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level0c.setText("no climb :(");
            }
        });

    }


//        this.TheydidnotclimbIncButton = (Button) findViewById(R.id.TheydidnotclimbIncButton);
//        this.HelpedToClimbButton = (Button) findViewById(R.id.climbWithhelpButton);
//        this.climbAloneIncButton = (Button) findViewById(R.id.climbAloneIncButton);


    public void climbAloneInc(View view) {
        if (HelpedToClimb<1)
        {
            if (Theydidnotclimb<1)
            {
                if (ClimbAloneCount<1)
                {
                    ClimbAloneCount++;
                    this.climbAloneIncButton.setText("Climbed Alone " + Integer.toString(this.ClimbAloneCount));
                }
            }
        }
    }
    public void climbWithhelp(View view) {
        if (ClimbAloneCount<1)
        {
            if (Theydidnotclimb<1)
            {
                if (HelpedToClimb<1)
                {
                    HelpedToClimb++;
                    this.HelpedToClimbButton.setText("Helped To Climb " + Integer.toString(this.HelpedToClimb));
                }

            }
        }
    }
    public void Theydidnotclimb(View view) {


        if (HelpedToClimb<1)
        {
            if (ClimbAloneCount<1)
            {
                if (Theydidnotclimb<1)
                {
                    Theydidnotclimb++;
                    this.TheydidnotclimbIncButton.setText("They did not climb " + Integer.toString(this.Theydidnotclimb));
                }
            }
        }
    }
    public void Theydidnotclimbminus(View view) {
        if (Theydidnotclimb>0)
        {
            this.Theydidnotclimb--;
            this.TheydidnotclimbIncButton.setText("They did not climb  " + Integer.toString(this.Theydidnotclimb));
        }
    }
    public void TClimbWithhelpminus(View view) {
        if (HelpedToClimb>0)
        {
            this.HelpedToClimb--;
            this.HelpedToClimbButton.setText("Helped To Climb  " + Integer.toString(this.HelpedToClimb));
        }
    }
    public void ClimAlonebCountminus(View view) {
        if (ClimbAloneCount>0)
        {
            this.ClimbAloneCount--;
            this.climbAloneIncButton.setText("Climbed Alone  " + Integer.toString(this.ClimbAloneCount));
        }
    }
    public void a(View view) {

        Intent intent = new Intent(this, PersonalFeedback.class);
        intent.putExtra("teamNumber", teamNumber);
        intent.putExtra("autoSwitchCount", autoSwitchCount);
        intent.putExtra("autoScaleCount", autoScaleCount);
        intent.putExtra("autoLineCount", autoLineCount);
        intent.putExtra("SwitchCount", SwitchCount);
        intent.putExtra("ScaleCount", ScaleCount);
        intent.putExtra("ExchangeCount", ExchangeCount);
        intent.putExtra("autoexchangeCount", autoexchangeCount);
        intent.putExtra("ClimbAloneCount", ClimbAloneCount);
        intent.putExtra("HelpedToClimb", HelpedToClimb);
        intent.putExtra("Theydidnotclimb", Theydidnotclimb);
        intent.putExtra("EnemySwitchCount", EnemySwitchCount);



//        EditText editText = (EditText) findViewById(R.id.exchangeIncButton);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);


        startActivity(intent);
    }
}
