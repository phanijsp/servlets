package com.example.servlets;

import android.annotation.SuppressLint;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class plus_activity extends AppCompatActivity {
FloatingActionButton    submit;
EditText    et;
LottieAnimationView lav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus_activity);
        Window g=getWindow();
        g.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,WindowManager.LayoutParams.TYPE_STATUS_BAR);
        submit  =   (FloatingActionButton)  findViewById(R.id.submit);
        et  =   (EditText)  findViewById(R.id.editText);
        lav=    (LottieAnimationView)   findViewById(R.id.lottie);


        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                String g=et.getText().toString();
               new servletinserthelper(submit,lav,g,et,plus_activity.this).execute();
               et.setVisibility(View.INVISIBLE);
               submit.setVisibility(View.INVISIBLE);
               lav.setVisibility(View.VISIBLE);


            }
        });

    }
}
