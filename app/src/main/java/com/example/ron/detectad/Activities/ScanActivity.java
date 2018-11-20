package com.example.ron.detectad.Activities;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rapidapi.rapidconnect.Argument;
import com.rapidapi.rapidconnect.RapidApiConnect;


import org.json.*;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.example.ron.detectad.R;

public class ScanActivity extends AppCompatActivity {
    private TextView textView;
    private TextView resultText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);


    }

    public void scan_url_clicked(View view) {
    }

    public void scanurl(View view) {
        textView = (TextView)findViewById(R.id.url_text);
        String url =  textView.getText().toString();
        resultText = (TextView)findViewById(R.id.resultTxt);
        resultText.setText("");

        virusTotal(url);
    }


/*
----------------------------------------------------------------------------------------------------------------
                VIRUS TOTAL 2.0 API - SCAN URL FUNCTION

    * Using Virus Total 2.0 API in order to scan URL.
    * The API must get VirusTotal API key and url for the scan.
    * The function received a String variable which hold the URL that the user want to scan.
    * All scan data received back to the Android project to scanInformation variables.
    * It's better to use this API with try and catch because there is a risk that the data won't be reachable.
    * The alarm triggered when the user hit the button for scanning URL from the main screen.

----------------------------------------------------------------------------------------------------------------
*/


    public void virusTotal(String url){



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RapidApiConnect connect = new RapidApiConnect("default-application_5b1ac35ee4b09cbc0579f18b", "ef17a3c6-1d06-4c6c-8614-3c335fbe286f");

        Map<String, Argument> body = new HashMap<String, Argument>();

        //FOR EXAMPLE: hutsonrental.com  ---MALICIOUS URL

        body.put("domain", new Argument("data", url));
        body.put("apikey", new Argument("data", "dc6bff6a36b48d9b7c17b661014d64980b11dc38e5aa9a2e12650b7cbe95dc75"));


        //this is must for debug
        try {
            int a = 1;
            int b = 3;
            Map<String, Object> response = connect.call("VirusTotal", "getDomainReport", body);
            if(response.get("success") != null) {

                String temp = "";
                for (Map.Entry<String, Object> entry : response.entrySet()) {


                    System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
                    temp = entry.getValue().toString();
                }

                resultText = (TextView)findViewById(R.id.resultTxt);



                //Check if one of the parameters are suit this case
                String str = "malicious";
                String str2 = "malware";
                String str3 = "phishing";
                if(temp.toLowerCase().contains(str.toLowerCase())||temp.toLowerCase().contains(str2.toLowerCase())||temp.toLowerCase().contains(str3.toLowerCase()))
                {
                    resultText.setTextColor(0xffff0000);
                    resultText.setText("Malicious URL");
                }else
                {
                    resultText.setTextColor(0xFF00FF00);
                    resultText.setText("Safe URL :)");
                }





                //System.out.println(temp);


            } else{


            }
        } catch(Exception e){


        }




    }


}
