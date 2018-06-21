package com.example.ankush.pomodorotimer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Handler handler= new Handler(); // it allows delaying
        Runnable run=new Runnable() {  //chunk of code that handler handles is called runnable
            @Override
            public void run() {
                // code to be run every second or afteer a period of time

                handler.postDelayed(this,1000);

            }
        };

        handler.post(run); // ruun
    }


}
