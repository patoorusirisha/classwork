package com.example.registrationpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.registrationpage.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String gender,KnowNCources,userRating,userProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();                }
            }
        });

        binding.rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                binding.tvResult.setText("+rating is"+rating);
            }
        });
binding.sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        binding.tvResult.setText("your progrss is"+progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        binding.tvResult.setText("");
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
       binding.tvResult.setText("");
    }
});

    }

    public void showData(View view) {
        String name=binding.etUsername1.getText().toString();
        String Email=binding.etUserEmail.getText().toString();
        String password=binding.etUserPassword.getText().toString();
        String Address=binding.etUserAddress.getText().toString();
        String Mobile=binding.etUserMobileNumber.getText().toString();
        if (binding.male.isChecked()){
            gender="male";
        }else if (binding.female.isChecked()){
            gender="female";
        }


        Intent intentObj=new Intent(this,DetailsActivity.class);
        intentObj.putExtra("Myname1",name);
        intentObj.putExtra("MyEmail",Email);
        intentObj.putExtra("Mymobile",Mobile);
        intentObj.putExtra("Mypassword",password);
        intentObj.putExtra("MyAddress", Address);
        intentObj.putExtra("Mygender", gender);
        intentObj.putExtra("Myrating", userRating);
        intentObj.putExtra("MyProgress", userProgress);



        startActivity(intentObj);
    }
}
