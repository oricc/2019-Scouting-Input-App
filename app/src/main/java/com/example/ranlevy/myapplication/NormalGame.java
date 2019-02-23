package com.example.ranlevy.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class NormalGame extends AppCompatActivity {


    Button btnCargoshipHatch;
    Button btnCargoshipCargo;
    Button btnCargoshipHatchDec;
    Button btnCargoShipCargoDec;
    Button climb;

    int[] cargoScored, hatchScored;
    int shipCargo = 0, shipHatch = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_game);

        Intent intent = getIntent();
        boolean isAuto = intent.getBooleanExtra("is_auto",false);
        if(isAuto)
            setTitle("Auto period");

        this.btnCargoshipHatch = (Button) findViewById(R.id.normal_game_cargoship_hatch);
        this.btnCargoshipHatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shipHatch < 8)
                    shipHatch++;
                ((Button) view).setText("HATCH " + shipHatch);
            }
        });
        this.btnCargoshipCargo = (Button) findViewById(R.id.normal_game_cargoship_cargo);
        this.btnCargoshipCargo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shipCargo < 8)
                    shipCargo++;
                ((Button) view).setText("CARGO " + shipCargo);
            }
        });
        this.btnCargoShipCargoDec = (Button) findViewById(R.id.normal_game_cargoship_cargo_dec);
        this.btnCargoShipCargoDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shipCargo > 0)
                    shipCargo--;
                btnCargoshipCargo.setText("CARGO " + shipCargo);
            }
        });
        this.btnCargoshipHatchDec = (Button) findViewById(R.id.normal_game_cargoship_hatch_dec);
        this.btnCargoshipHatchDec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shipHatch > 0)
                    shipHatch--;
                btnCargoshipHatch.setText("HATCH " + shipHatch);
            }
        });
        this.climb = (Button) findViewById(R.id.climb);
        climb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                climb();
            }
        });


        this.cargoScored = new int[3];
        this.hatchScored = new int[3];
    }

    public void updateCounter(View v) {
        Button btn = (Button) v;
        String name = getId(v);
        Log.d("Normal game btn clicked", name);
        String[] parts = name.split("_");
        String gamePiece = parts[2]; // cargo/hatch
        String height = parts[3]; // low/medium/high
        String op = parts[4]; // inc/dec

        int current = Integer.parseInt(btn.getText().toString());

        int newValue = updateArray((gamePiece.equals("cargo") ? cargoScored : hatchScored), getHeightIdx(height), (op.equals("inc") ? 1 : -1));
        if (op.equals("inc"))
            btn.setText("" + newValue);
        else {
            String incName = name.replace("dec", "inc");
            Log.d("Normal game btn clicked", incName);
            Button incBtn = findViewById(getResources().getIdentifier(incName, "id", getPackageName()));
            Log.d("Normal game btn clicked", incBtn.toString());
            incBtn.setText("" + newValue);
//            ((Button) findViewById(getResources().getIdentifier(incName, "id", "app.dj")))
//                    .setText("" + newValue);
        }
    }

    private int getHeightIdx(String hName) {
        if (hName.equals("low")) return 0;
        if (hName.equals("medium")) return 1;
        if (hName.equals("high")) return 2;
        return -1;
    }

    private int updateArray(int[] arr, int height, int addition) {
        if (height < 0)
            return -1;

        arr[height] += addition;
        if (arr[height] < 0) arr[height] = 0;
        if (arr[height] > 4) arr[height] = 4;
        return arr[height];
    }

    @SuppressLint("ResourceType")
    private String getId(View view) {
        if (view.getId() == 0xffffffff) return "no-id";
        else return view.getResources().getResourceEntryName(view.getId());
    }

    public void climb() {

        Intent prevIntent = getIntent();
        boolean isAuto = prevIntent.getBooleanExtra("is_auto",false);
        Log.d("Normal game",isAuto+"");
        Intent intent = null;
        if(!isAuto) {
            intent = new Intent(this, Climb.class);
            intent.putExtras(prevIntent);
            // Add rocket points
            intent.putExtra("teleop_rocket_cargo_low", cargoScored[0]);
            intent.putExtra("teleop_rocket_cargo_medium", cargoScored[1]);
            intent.putExtra("teleop_rocket_cargo_high", cargoScored[2]);

            intent.putExtra("teleop_rocket_hatch_low", hatchScored[0]);
            intent.putExtra("teleop_rocket_hatch_medium", hatchScored[1]);
            intent.putExtra("teleop_rocket_hatch_high", hatchScored[2]);

            // Ship points
            intent.putExtra("teleop_ship_cargo", shipCargo);
            intent.putExtra("teleop_ship_hatch", shipHatch);
        }else{
            intent = new Intent(this,NormalGame.class);
            intent.putExtras(prevIntent);
            intent.putExtra("is_auto",false);
            // Add rocket points
            intent.putExtra("auto_rocket_cargo_low", cargoScored[0]);
            intent.putExtra("auto_rocket_cargo_medium", cargoScored[1]);
            intent.putExtra("auto_rocket_cargo_high", cargoScored[2]);

            intent.putExtra("auto_rocket_hatch_low", hatchScored[0]);
            intent.putExtra("auto_rocket_hatch_medium", hatchScored[1]);
            intent.putExtra("auto_rocket_hatch_high", hatchScored[2]);

            // Ship points
            intent.putExtra("auto_ship_cargo", shipCargo);
            intent.putExtra("auto_ship_hatch", shipHatch);
        }


        startActivity(intent);
    }

}
