package com.example.ranlevy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class NormalGame extends AppCompatActivity {

    int highCargo = 0;
    int mediumCargo = 0;
    int lowCargo = 0;
    int highHatch = 0;
    int mediumHatch = 0;
    int lowHatch = 0;
    int cargocargo = 0;
    int hatchcargo = 0;
    int cargoRocket = 0;
    int hatchRocket = 0;

    Button high;
    Button medium;
    Button low;
    Button cargoRocketB;
    Button hatchRocketB;
    Button cargoRocketDec;
    Button hatchRocketDec;
    Button cargocargoB;
    Button hatchcargoB;
    Button cargocargoDec;
    Button hatchcargoDec;
    Button climb;

    long autoHatchCount, teamNumber, startLevel, autoCargoCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);

        Intent intent = getIntent();
        this.teamNumber = intent.getLongExtra("teamNumber", 0);
        this.autoHatchCount = intent.getIntExtra("autoHatchCount", 0);
        this.startLevel = intent.getIntExtra("startLevel", 0);
        this.autoCargoCount = intent.getIntExtra("autoCargoCount", 0);
        this.high = (Button) findViewById(R.id.high);
        this.medium = (Button) findViewById(R.id.medium);
        this.low = (Button) findViewById(R.id.low);
        this.cargocargoDec = (Button) findViewById(R.id.cargocargoDec);
        this.cargoRocketB = (Button) findViewById(R.id.cargoRocket);
        this.hatchRocketB = (Button) findViewById(R.id.hatchRocket);
        this.cargoRocketDec = (Button) findViewById(R.id.cargoRocketDec);
        this.hatchRocketDec = (Button) findViewById(R.id.hatchRocketDec);
        this.cargocargoB = (Button) findViewById(R.id.cargocargo);
        this.hatchcargoB = (Button) findViewById(R.id.hatchcargo);
        this.hatchcargoDec = (Button) findViewById(R.id.hatchcargoDec);
        this.climb = (Button) findViewById(R.id.climb);
    }
//
//        high.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                cargoRocketB.setOnClickListener(new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View view) {
//                        highCargo++;
//                        cargoRocketB.setText("cargo  " + Integer.toString(highCargo));
//                    }
//        });
//
//    }
//    public void highCargo(View view) {
//        this.SwitchCount++;
//        this.switchIncButton.setText("switch  " + Integer.toString(this.SwitchCount));
//    }
//
//    public void EnemySwitchInc(View view) {
//        this.EnemySwitchCount++;
//        this.EnemySwitchButton.setText("Enemy Switch  " + Integer.toString(this.EnemySwitchCount));
//    }
//    public void EnemySwitchminus(View view) {
//        if (EnemySwitchCount>0)
//        {
//            this.EnemySwitchCount--;
//            this.EnemySwitchButton.setText("Enemy Switch  " + Integer.toString(this.EnemySwitchCount));
//        }
//    }
//    public void scaleInc(View view) {
//        this.ScaleCount++;
//        this.scaleincButton.setText("scale  " + Integer.toString(this.ScaleCount));
//
//    }
////
//    public void exchangeInc(View view) {
//        this.ExchangeCount++;
//        this.exchangeIncButton.setText("exchange  " + Integer.toString(this.ExchangeCount));
//
//    }
//    public void exchangeIncminus(View view) {
//        if (ExchangeCount>0)
//        {
//            this.ExchangeCount--;
//            this.exchangeIncButton.setText("exchange  " + Integer.toString(this.ExchangeCount));
//        }
//    }
////    public void Climbminus(View view) {
////        if (autoLineCount>0)
////        {
////            this.autoLineCount--;
////            this.autoLineIncButton.setText("auto Line  " + Integer.toString(this.autoLineCount));
////        }
////    }
//    public void scaleIncminus(View view) {
//        if (ScaleCount>0) {
//            this.ScaleCount--;
//            this.scaleincButton.setText("scale  " + Integer.toString(this.ScaleCount));
//        }
//    }
//    public void switchIncminus(View view) {
//        if (SwitchCount>0)
//        {
//            this.SwitchCount--;
//            this.switchIncButton.setText("switch  " + Integer.toString(this.SwitchCount));
//        }
//    }
    public void climb(View view) {

        Intent intent = new Intent(this, Climb.class);
        intent.putExtra("teamNumber", teamNumber);
//        intent.putExtra("autoSwitchCount", autoSwitchCount);
//        intent.putExtra("autoScaleCount", autoScaleCount);
//        intent.putExtra("autoLineCount", autoLineCount);
//        intent.putExtra("SwitchCount", SwitchCount);
//        intent.putExtra("ScaleCount", ScaleCount);
//        intent.putExtra("ExchangeCount", ExchangeCount);
//        intent.putExtra("autoexchangeCount", autoexchangeCount);
//        intent.putExtra("EnemySwitchCount", EnemySwitchCount);



        startActivity(intent);
    }


}
