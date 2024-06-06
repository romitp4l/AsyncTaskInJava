package com.example.asynctaskinjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.asynctaskinjava.R;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "async";

    String[] items = new String[]{
            "alpha",
            "beta",
            "gamma",
            "lemda",
            "ohm",
            "xi",
            "pta nahi",
            "kuch bhi",
            " kuch to "

    };

    ConstraintLayout constraintLayout;
    ListView lvitems;
    Button button;
    Button btnToNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        constraintLayout = findViewById(R.id.constrainstLayout);
        button = findViewById(R.id.button);
        lvitems = findViewById(R.id.lvitems);
        btnToNextActivity= findViewById(R.id.btnToSecondActivity);


        btnToNextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , AsyncActivity.class);
                startActivity(i);
            }
        });


        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                items
        );

        lvitems.setAdapter(itemAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constraintLayout.setBackgroundColor(com.google.android.material.R.color.material_dynamic_primary100);
            }
        });


    }

    void wait1sec() {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + 10000) ;
    }

    void waitNsec(int n) {

        for (int i = 0; i < n; i++) {
            wait1sec();

        }

    }
}