package com.example.bike_showroom_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText umail,upws;
    TextView textView;
    Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        umail=findViewById(R.id.mailId);
        upws=findViewById(R.id.pws);
        login=findViewById(R.id.btn1);
        register=findViewById(R.id.rigisterId);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               checkCrededentials();
                Intent homepage=new Intent(getBaseContext(),HomeActivity.class);
                startActivity(homepage);
            }
        });

    }
    private void checkCrededentials() {

        String useremail1=umail.getText().toString();
        String userpws1=upws.getText().toString();
        String s=RegisterActivity.sp.getString("mail","");
        String p=RegisterActivity.sp.getString("password","");
        if ((useremail1.equals(s) )&& (userpws1.equals(p)))
            if (useremail1.isEmpty() || useremail1.length()<7){
                showError(umail,"your user email is not valid");
            }
            else if (userpws1.isEmpty() || userpws1.length()<7 ){
                showError(upws,"invalid password");
            }

            else if ((useremail1.equals(s) )&& (userpws1.equals(p))) {
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();

            }

    }

    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();
    }

    public void login(View view) {

    }

    public void register(View view) {
        Intent intent=new Intent(getBaseContext(),RegisterActivity.class);
        startActivity(intent);
    }
}
