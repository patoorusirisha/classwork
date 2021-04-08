package com.example.retroficexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView date,country,deathcases,activecases,conformedcases,recovered;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new ProgressDialog(this);
        dialog.setTitle("DataFetching..");
        dialog.setMessage("please wait..");
        dialog.show();
        date=findViewById(R.id.dt);
        country=findViewById(R.id.coun);
        deathcases=findViewById(R.id.dc);
        activecases=findViewById(R.id.at);
        conformedcases=findViewById(R.id.cs);
        recovered=findViewById(R.id.r);
        ConnectivityManager cm= (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=cm.getActiveNetworkInfo();
        if (networkInfo==null){
           // Toast.makeText(this,"no internet",Toast.LENGTH_SHORT).show();
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("Alert..");
            builder.setMessage("pls check your internet connection");
            builder.setIcon(R.drawable.ic_error_black_24dp);
        }
        else {
            dialog.show();

            Toast.makeText(this,"Welcome",Toast.LENGTH_SHORT).show();

        EndpointInterface ei=RetrofitInstance.getRetrofit().create(EndpointInterface.class);
        Call<String> c=ei.getData();
        c.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                dialog.cancel();
                // Log.i("ding",response.body());
                //Toast.makeText(MainActivity.this,""+response.body(),Toast.LENGTH_SHORT).show();
                try {
                    JSONArray rootArray = new JSONArray(response.body());
                    JSONObject rootobj = rootArray.getJSONObject(rootArray.length() - 1);
                    String res_country = rootobj.getString("Country");
                    country.setText("country:" + res_country);
                    String res_Deaths = rootobj.getString("Deaths");
                    deathcases.setText("death:" + res_Deaths);
                    String res_date = rootobj.getString("Date");
                    date.setText("Date:" + properDateFormat(res_date));
                    String res_Activecases = rootobj.getString("Active");
                    activecases.setText("Active:" + res_Activecases);
                    String res_conformedcases = rootobj.getString("Confirmed");
                    conformedcases.setText("Confirmed:" + res_Activecases);

                    String res_recovered = rootobj.getString("Recovered");
                    recovered.setText("Recovered:" + res_recovered);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            private String properDateFormat(String res_date) {
                String inputPattern = "yy-mm-dd";
                String outputPattern = "dd-mm-yy";
                SimpleDateFormat inputDate = new SimpleDateFormat(inputPattern);
                SimpleDateFormat outputDate = new SimpleDateFormat(outputPattern);
                Date d = null;
                String str = null;
                try {
                    d = inputDate.parse(res_date);
                    str = outputDate.format(d);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return str;
            }


            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Failed to load",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
}