package com.example.ranlevy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class AutoGame extends AppCompatActivity {

    Long teamNumber;
    int autoHatchCount = 0;
    Button HATCHButton;
    int autoCargoCount = 0;
    Button CARGOButton;
    String startLevel = "?";
    Button level1a;
    Button level2a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_game);

        Intent intent = getIntent();
        this.teamNumber = intent.getLongExtra("teamNumber", 0);

        this.HATCHButton = (Button) findViewById(R.id.HATCHButton);
        this.CARGOButton = (Button) findViewById(R.id.CARGOButton);
        this.level1a = (Button) findViewById(R.id.level1a);
        this.level2a = (Button) findViewById(R.id.level2a);

        final Button[] levelBtns = {level1a, level2a};
        final String[] originalLevelText = {"LEVEL 1", "LEVEL 2"};
        level1a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startLevel = "level 1";
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level1a.setText("start: level 1");
            }
        });
        level2a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startLevel = "level 2";
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level2a.setText("start: level 2");
            }
        });

    }

    public void hatchInc(View view) {
        this.autoHatchCount++;
        this.HATCHButton.setText("HATCH  " + Integer.toString(this.autoHatchCount));
    }

    public void CARGOiNC(View view) {
        this.autoCargoCount++;
        this.CARGOButton.setText("CARGO  " + Integer.toString(this.autoCargoCount));

    }

    public void cargoIncminus(View view) {
        if (autoCargoCount > 0) {
            this.autoCargoCount--;
            this.CARGOButton.setText("CARGO  " + Integer.toString(this.autoCargoCount));
        }
    }

    public void hatchIncminus(View view) {
        if (autoHatchCount > 0) {
            this.autoHatchCount--;
            this.HATCHButton.setText("HATCH  " + Integer.toString(this.autoHatchCount));
        }
    }

    public void Normalgame(View view) {

        Intent intent = new Intent(this, NormalGame.class);
        intent.putExtra("autoHatchCount", autoHatchCount);
        Log.d("TEAM AUTO", Integer.toString(autoHatchCount));
        intent.putExtra("teamNumber", teamNumber);
        intent.putExtra("autoCargoCount", autoCargoCount);
        intent.putExtra("startLevel", startLevel);
        startActivity(intent);

    }
}

