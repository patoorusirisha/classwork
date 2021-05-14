package com.example.myap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    EditText e1, e2;
    Button b;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
        b = findViewById(R.id.Result);
        tv = findViewById(R.id.tv_ans);
        sp = findViewById(R.id.spin);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String as = sp.getSelectedItem().toString();
                tv.setText(as);
            }


        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}

