package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText editText;
Button btn;
TextView txt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the values from button text edittext using id

        txt=findViewById(R.id.txt);
        editText=findViewById(R.id.editText);
        btn=findViewById(R.id.btn);

        //initializing the function of the button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=editText.getText().toString();

                //explicit intent
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);

                // passing the username to secondActivity
                intent.putExtra("name",userName);

                //calling the next activity

                startActivity(intent);

            }
        });
    }

}