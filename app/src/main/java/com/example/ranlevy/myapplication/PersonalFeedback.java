package com.example.ranlevy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;
public class PersonalFeedback extends AppCompatActivity {

    long teamNumber, autoSwitchCount, autoScaleCount, autoLineCount, SwitchCount, ScaleCount, ExchangeCount, ClimbAloneCount, toString, autoexchangeCount, HelpedToClimb, Data, Theydidnotclimb, EnemySwitchCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_feedback);


        Intent intent = getIntent();
        this.teamNumber = intent.getLongExtra("teamNumber", 0);
        this.autoSwitchCount = intent.getLongExtra("autoSwitchCount", 0);
        this.autoScaleCount = intent.getLongExtra("autoScaleCount", 0);
        this.autoLineCount = intent.getLongExtra("autoLineCount", 0);
        this.SwitchCount = intent.getLongExtra("SwitchCount", 0);
        this.ScaleCount = intent.getLongExtra("ScaleCount", 0);
        this.ExchangeCount = intent.getLongExtra("ExchangeCount", 0);
        this.ClimbAloneCount = intent.getIntExtra("ClimbAloneCount", 0);
        this.autoexchangeCount = intent.getLongExtra("autoexchangeCount", 0);
        this.HelpedToClimb = intent.getIntExtra("HelpedToClimb", 0);
        this.Theydidnotclimb = intent.getIntExtra("Theydidnotclimb", 0);
        this.EnemySwitchCount = intent.getLongExtra("EnemySwitchCount", 0);


        TextView teamNumbera = findViewById(R.id.teamNumber);
        teamNumbera.setText("teamNumber "+teamNumber);
        TextView autoSwitchCounta = findViewById(R.id.autoSwitchCount);
        autoSwitchCounta.setText("autoSwitchCount "+autoSwitchCount);
        TextView autoScaleCounta = findViewById(R.id.autoScaleCount);
        autoScaleCounta.setText("autoScaleCount "+autoScaleCount);
//        TextView textView = findViewById(R.id.textView);
//        textView.setText("autoScaleCount "+autoScaleCount);
        TextView autoLineCounta = findViewById(R.id.autoLineCount);
        autoLineCounta.setText("autoLineCount "+autoLineCount);
        TextView SwitchCounta = findViewById(R.id.SwitchCount);
        SwitchCounta.setText("SwitchCount "+SwitchCount);
        TextView ScaleCounta = findViewById(R.id.ScaleCount);
        ScaleCounta.setText("ScaleCount "+ScaleCount);
        TextView ExchangeCounta = findViewById(R.id.ExchangeCount);
        ExchangeCounta.setText("ExchangeCount "+ExchangeCount);
        TextView autoexchangeCounta = findViewById(R.id.autoexchangeCount);
        autoexchangeCounta.setText("autoexchangeCount "+autoexchangeCount);
        TextView EnemySwitchCounta = findViewById(R.id.EnemySwitchCount);
        EnemySwitchCounta.setText("EnemySwitchCount "+EnemySwitchCount);

        TextView ClimbAloneCounta = findViewById(R.id.ClimbAloneCounta);
        TextView ClimbNotAloneCounta = findViewById(R.id.ClimbNotAloneCounta);
        TextView Theydidnotclimba = findViewById(R.id.Theydidnotclimba);


        if (ClimbAloneCount==1)
        {
            ClimbAloneCounta.setText("ClimbAloneCount yes");
        }
        else
        {
            ClimbAloneCounta.setText("ClimbAloneCount no");

        }

        if (HelpedToClimb==1)
        {
            ClimbNotAloneCounta.setText("HelpedToClimb yes");
        }
        else
        {
            ClimbNotAloneCounta.setText("HelpedToClimb no");

        }
        if (Theydidnotclimb==1)
        {
            Theydidnotclimba.setText("Theydidnotclimb yes");
        }
        else
        {
            Theydidnotclimba.setText("Theydidnotclimb no");


        }


//        Intent intent = getIntent();
//
//        TextView textView = findViewById(R.id.textView);
//        textView.setText((int) intent.getLongExtra("teamNumber",0));

    }
//}
//    public void save(View view) {
//        Log.d("TEAM", "Hi");
//
//        // Write a message to the database
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        Date currentTime = Calendar.getInstance().getTime();
//
//
//        DatabaseReference myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/autoSwitch");
//        myRef.setValue(this.autoSwitchCount);
//        myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/autoScale");
//        myRef.setValue(this.autoScaleCount);
//        myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/autoLine");
//        myRef.setValue(this.autoLineCount);
//        myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/Switch");
//        myRef.setValue(this.SwitchCount);
//        myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/Scale");
//        myRef.setValue(this.ScaleCount);
//        myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/Exchange");
//        myRef.setValue(this.ExchangeCount);
//        myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/Climb");
//        myRef.setValue(this.ClimbCount);
//        myRef = database.getReference("Scores/" + this.teamNumber + "/" + currentTime.toString() + "/autoexchange");
//        myRef.setValue(this.autoexchangeCount);
//
//

    public void End(View view) {

        Intent intent = new Intent(this, End.class);
        intent.putExtra("teamNumber", teamNumber);
        intent.putExtra("autoSwitchCount", autoSwitchCount);
        intent.putExtra("autoScaleCount", autoScaleCount);
        intent.putExtra("autoLineCount", autoLineCount);
        intent.putExtra("SwitchCount", SwitchCount);
        intent.putExtra("ScaleCount", ScaleCount);
        intent.putExtra("ExchangeCount", ExchangeCount);
        intent.putExtra("ClimbAloneCount", ClimbAloneCount);
        intent.putExtra("autoexchangeCount", autoexchangeCount);
        intent.putExtra("HelpedToClimb", HelpedToClimb);
        intent.putExtra("Theydidnotclimb", Theydidnotclimb);
        intent.putExtra("EnemySwitchCount", EnemySwitchCount);

        startActivity(intent);
    }

}
