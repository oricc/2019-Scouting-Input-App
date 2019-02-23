package com.example.ranlevy.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class End extends AppCompatActivity {
    boolean submitted = false;
    Button sButton;
    String matchNumber;

    String[] allScoutingKeys = {
            "team_number", "match_number", "submitter",
            "auto_start_level",
            "auto_rocket_cargo_low", "auto_rocket_cargo_medium", "auto_rocket_cargo_high",
            "auto_rocket_hatch_low", "auto_rocket_hatch_medium", "auto_rocket_hatch_high",
            "auto_ship_cargo", "auto_ship_hatch",
            "teleop_rocket_cargo_low", "teleop_rocket_cargo_medium", "teleop_rocket_cargo_high",
            "teleop_rocket_hatch_low", "teleop_rocket_hatch_medium", "teleop_rocket_hatch_high",
            "teleop_ship_cargo", "teleop_ship_hatch",
            "climb_level",
            "personal_feedback"

    };

    String TAG = "End activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        this.matchNumber = "Qual_" + getApplicationContext().getSharedPreferences("match_number", Context.MODE_PRIVATE).getString("match_number", "0000");


        this.sButton = (Button) findViewById(R.id.sButton);

//        save(sButton);
        uploadToFirestore();
    }


    public void uploadToFirestore() {
        // Access a Cloud Firestore instance from your Activity
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        Long teamNumber = extras.getLong("team_number");
        String teamName = extras.getString("team_name");
        Map<String, Object> scoutingReport = new HashMap<>();
        for (String key : allScoutingKeys) {
            scoutingReport.put(key, extras.get(key));
        }

        db.collection("Teams")
                .document(teamNumber + "")
                .update("number",teamNumber,"name",teamName);
        db.collection("Teams")
                .document(teamNumber + "")
                .collection("Games")
                .add(scoutingReport);

        // Create a new user with a first and last name
//        Map<String, Object> user = new HashMap<>();
//        user.put("first", "Ada");
//        user.put("last", "Lovelace");
//        user.put("born", 1815);

// Add a new document with a generated ID
//        db.collection("users")
//                .add(user)
//                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//                    @Override
//                    public void onSuccess(DocumentReference documentReference) {
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//                    }
//                });


    }

    public void NewGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
