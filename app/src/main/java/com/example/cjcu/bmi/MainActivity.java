package com.example.cjcu.bmi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed_weight;
    private EditText ed_height;
    private Button btn_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviews();
        btn_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("BMI的說明")
                        .setMessage("BMI=體重／身高")
                        .setPositiveButton("OK",null)
                        .show();

            }
        });



    }

    private void findviews() {
        ed_weight = findViewById(R.id.ed_weight);
        ed_height = findViewById(R.id.ed_height);

        btn_help = findViewById(R.id.btn_help);
    }

    public void bmi(View view) {

        float w = Float.parseFloat(ed_weight.getText().toString());
        float h = Float.parseFloat(ed_height.getText().toString());
        float bmi = w / (h * h);
        Log.d("BMI", String.valueOf(bmi));
        Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();

        new AlertDialog.Builder(this)
                .setMessage("BMI="+bmi)
                .setTitle("BMI 值")
                .setPositiveButton("OK",null)
                .setNegativeButton("CANCAL",null)
                .show();
    }
}
