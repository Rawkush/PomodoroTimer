package com.example.ankush.pomodorotimer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // using alternative method

            new CountDownTimer(10000,1000){  // first param is timer till which to count
                                                    // second param is in what intervals should it count

                @Override
                public void onTick(long millisUntilFinished) {

                    // after every second

                }

                @Override
                public void onFinish() {
                    // when conter is finished(after 10 sec)
                }
            };
       /*
        final Handler handler= new Handler(); // it allows delaying
        Runnable run=new Runnable() {  //chunk of code that handler handles is called runnable
            @Override
            public void run() {
                // code to be run every second or afteer a period of time

                handler.postDelayed(this,1000);

            }
        };

        handler.post(run); // ruun
    */
    }


}
