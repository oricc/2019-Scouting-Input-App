package com.example.ranlevy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class Climb extends AppCompatActivity {


    Button level0c;
    Button level1c;
    Button level2c;
    Button level3c;
    int climbLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_climb);

        Log.d("STAM", "Climb");


        this.level1c = (Button) findViewById(R.id.level1c);
        this.level2c = (Button) findViewById(R.id.level2c);
        this.level3c = (Button) findViewById(R.id.level3c);
        this.level0c = (Button) findViewById(R.id.level0c);

        final Button[] levelBtns = {level1c, level2c, level3c, level0c};
        final String[] originalLevelText = {"LEVEL 1", "LEVEL 2", "LEVEL 3", "LEVEL 0"};
        level1c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = 1;
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level1c.setText("climb: level 1");
            }
        });
        level2c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = 2;
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level2c.setText("climb: level 2");
            }
        });
        level3c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = 3;
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level3c.setText("climb: level 3");
            }
        });
        level0c.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                climbLevel = 0;
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level0c.setText("no climb :(");
            }
        });

    }


//        this.TheydidnotclimbIncButton = (Button) findViewById(R.id.TheydidnotclimbIncButton);
//        this.HelpedToClimbButton = (Button) findViewById(R.id.climbWithhelpButton);
//        this.climbAloneIncButton = (Button) findViewById(R.id.climbAloneIncButton);



    public void end(View view) {

        Intent intent = new Intent(this, PersonalFeedback.class);

        intent.putExtra("climb_level",climbLevel);
        intent.putExtras(getIntent());

//        EditText editText = (EditText) findViewById(R.id.exchangeIncButton);
//        String message = editText.getText().toString();
//        intent.putExtra(EXTRA_MESSAGE, message);


        startActivity(intent);
    }
}
