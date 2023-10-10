package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
Button sharebtn;
TextView txt2,txt3;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    // getting values from id
        txt2=findViewById(R.id.txt2);
        txt3=findViewById(R.id.txt3);
        sharebtn=findViewById(R.id.sharebtn);

        //receiving the data from the main activity
        Intent intent=getIntent();
        String userName=intent.getStringExtra("name");

        //calling the random number function
        int random_num=generateRandomNumber();

        //setting the random number to textview 3
        txt3.setText(""+random_num);

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               shareData(userName,random_num);
            }
        });


    }

   //function to generate the random numbers
    public int generateRandomNumber(){
        Random random=new Random();
        int upper_limit=1000;
        int randomNumberGenerated=random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    //function to share data
    public void shareData(String username,int randomNUM){
        //implicit intent
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT,username +" got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,username +" lucky number is:" + randomNUM);

        startActivity(Intent.createChooser(i,"choose a platform"));


    }

}