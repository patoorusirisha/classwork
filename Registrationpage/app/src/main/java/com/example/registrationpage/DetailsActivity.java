package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.registrationpage.databinding.ActivityDetailsBinding;
import com.example.registrationpage.databinding.ActivityMainBinding;

public class DetailsActivity extends AppCompatActivity {
    ActivityDetailsBinding detailsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsBinding= DataBindingUtil.setContentView(this,R.layout.activity_details);
        detailsBinding.tvDetails.setVisibility(View.VISIBLE);

        Intent i=getIntent();
        String n=i.getStringExtra("Myname1");
        String e=i.getStringExtra("MyEmail");
        String p=i.getStringExtra("Mypassword");
        String m=i.getStringExtra("Mymobile");
        String g=i.getStringExtra("Mygender");
        String a=i.getStringExtra("MyAddress");
        String r=i.getStringExtra("Myrating");
        detailsBinding.tvDetails.append(
                "name1:"+n+"\n"+
                "Email:"+e+"\n"+
                "Password:"+p+"\n"+
                "mobile:"+m+"\n"+
                "gender:"+g+"\n"+
                "Address:"+a+"\n"+
                "rating:"+r+"
        );

    }
}
