package com.example.ranlevy.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText matchNumber;
    EditText subName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        matchNumber = (EditText)findViewById(R.id.etMatchNumber);
        matchNumber.requestFocus();
        subName = (EditText)findViewById(R.id.etSubName);
        subName.requestFocus();
    }

    public void selectTeam(View view) {
        String num = matchNumber.getText().toString();
        String sub = subName.getText().toString();
        if((num == null || num.equals(""))||(sub == null || sub.equals("")))
            Toast.makeText(this,"You must enter both name and match number",Toast.LENGTH_SHORT);
        else {
            Intent intent = new Intent(this, TeamSelectActivity.class);
            intent.putExtra("match_number", num);
            intent.putExtra("submitter", sub);

            SharedPreferences prefs = getApplicationContext().getSharedPreferences("match_number", Context.MODE_PRIVATE);
            prefs.edit().putString("match_number",num).commit();
            startActivity(intent);
        }

    }
}
