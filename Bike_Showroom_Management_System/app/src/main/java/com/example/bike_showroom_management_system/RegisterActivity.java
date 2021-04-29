package com.example.bike_showroom_management_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText name,email,password,pn;
    Button btn2;
    static SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sp=getSharedPreferences("auth",MODE_PRIVATE);
        setContentView(R.layout.activity_register);
        name=findViewById(R.id.u_name);
        email=findViewById(R.id.u_mailId);
        password=findViewById(R.id.u_pws);
        pn=findViewById(R.id.u_phoneno);
        btn2=findViewById(R.id.btn1);
        checkCrededentials();
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkCrededentials();
                Intent reg=new Intent(getBaseContext(),MainActivity.class);
                startActivity(reg);
            }
        });
    }

    private void checkCrededentials() {
        String username=name.getText().toString();
        String useremail=email.getText().toString();
        String userpws=password.getText().toString();
        String uphone=pn.getText().toString();

       /* if (username.isEmpty() || username.length()<7){
            showError(name,"your user name is not valid");
        }
        else if (useremail.isEmpty()|| !useremail.contains("@")){
            showError(email,"Email is not valid");
        }
        else if (userpws.isEmpty() || userpws.length()<7 ){
            showError(password,"invalid password");
        }
        else if (uphone.isEmpty() || uphone.contains("Number")){
            showError(pn,"invalid mobile number");
        }
        else{
            editor=sp.edit();
            editor.putString("mail",useremail);
            editor.putString("password",userpws);
            editor.commit();
            Toast.*//*makeText(this,"you'r registration is success",Toast.LENGTH_SHORT).show();
        }*/

    }
    private void showError(EditText input, String s) {
        input.setError(s);
        input.requestFocus();

    }



}


