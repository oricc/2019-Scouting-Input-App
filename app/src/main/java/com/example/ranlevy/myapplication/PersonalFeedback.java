package com.example.ranlevy.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;
import java.util.Date;

public class PersonalFeedback extends AppCompatActivity {


    EditText opinion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_feedback);

        opinion = findViewById(R.id.et_personal_feedback);
    }

    public void End(View view) {

        Intent intent = new Intent(this, End.class);
        intent.putExtra("personal_feedback",opinion.getText().toString());
        intent.putExtras(getIntent());
        startActivity(intent);
    }

}
