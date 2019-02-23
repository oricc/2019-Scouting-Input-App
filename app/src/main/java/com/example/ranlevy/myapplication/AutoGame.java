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


    int startLevel = 0;
    Button level1a;
    Button level2a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_game);

        this.level1a = (Button) findViewById(R.id.level1a);
        this.level2a = (Button) findViewById(R.id.level2a);

        final Button[] levelBtns = {level1a, level2a};
        final String[] originalLevelText = {"LEVEL 1", "LEVEL 2"};
        level1a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startLevel = 1;
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level1a.setText("start: level 1");
            }
        });
        level2a.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startLevel = 2;
                for (int i = 0; i < levelBtns.length; i++)
                    levelBtns[i].setText(originalLevelText[i]);
                level2a.setText("start: level 2");
            }
        });

    }



    public void Normalgame(View view) {

        Intent intent = new Intent(this, NormalGame.class);

        intent.putExtra("auto_start_level", startLevel);

        intent.putExtras(getIntent());
        startActivity(intent);

    }
}

