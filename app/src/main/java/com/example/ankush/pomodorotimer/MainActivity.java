package com.example.ankush.pomodorotimer;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekbar;
    TextView timerTextView;

    public void controlTimer(View view){

        new CountDownTimer(timerSeekbar.getProgress()*1000,1000){  // first param is timer till which to count
            // second param is in what intervals should it count
            @Override
            public void onTick(long millisUntilFinished) {

                // after every second

                updateTime((int) (millisUntilFinished/1000));


            }
            @Override
            public void onFinish() {
                // when conter is finished(after 10 sec)
            }
        }.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekbar=(SeekBar) findViewById(R.id.seekBar);
        timerTextView= (TextView)findViewById(R.id.timertextView);

        timerSeekbar.setMax(600);    // max time duration is 10 minutes i.e 600 seconds
        timerSeekbar.setProgress(30); // intially setting timer at 30 sec
        timerSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            updateTime(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });





       // using alternative method

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


    public void updateTime(int secondsLeft){

        int minutes =(int) secondsLeft/ 60;
        int seconds= secondsLeft-minutes*60;
        timerTextView.setText(Integer.toString(minutes)+":"+Integer.toString(seconds));
    }

}
