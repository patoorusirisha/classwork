package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button t,c;
    TextView textView;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t=findViewById(R.id.toast);
        textView=findViewById(R.id.tv);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "Result is"+count, Toast.LENGTH_SHORT).show();
            }
        });

        c=findViewById(R.id.count);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               count++;
               textView.setText(""+count);
            }
        });
    }
}
