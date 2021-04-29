package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
EditText uname,email,phone,rollno;
RadioButton m,f;
CheckBox telugu,english,hindi;
Spinner department;
String gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        uname=findViewById(R.id.n);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.pn);
        rollno=findViewById(R.id.rm);
        m=findViewById(R.id.Male);
        f=findViewById(R.id.female);
        english=findViewById(R.id.e);
        telugu=findViewById(R.id.t);
        hindi=findViewById(R.id.h);
        department=findViewById(R.id.dep);


    }

    public void Save(View view) {
        String  name = uname.getText().toString();
        String  mail = email.getText().toString();
        String phoneno = phone.getText().toString();
        String roll = rollno.getText().toString();

        if (m.isChecked())
        {
            gender=m.getText().toString();
            if (f.isChecked())
            {
                gender=f.getText().toString();
            }
        }
        StringBuilder sb=new StringBuilder();
        if (telugu.isChecked()){
            sb.append(telugu.getText().toString()+",");
        }
        if (english.isChecked()){
            sb.append(english.getText().toString()+",");
        }
        if (hindi.isChecked()){
            sb.append(hindi.getText().toString());
        }
        String department1=department.getSelectedItem().toString();
       // Toast.makeText(this,name+"\n"+mail+"\n"+phoneno+"\n"+rollno+"/n"+gender+"\n"+department1+"\n"+sb.toString(),Toast.LENGTH_SHORT).show();
    Student student=new Student();
    student.setName(name);
    student.setMailId(mail);
    student.setPhonenumber(phoneno);
    student.setRollnumer(roll);
    student.setDepartment(department1);
    student.setGender(gender);
    student.setLanguage(sb.toString());
    Toast.makeText(this,"Data saved successfully",Toast.LENGTH_SHORT).show();
    finish();

    }


}
