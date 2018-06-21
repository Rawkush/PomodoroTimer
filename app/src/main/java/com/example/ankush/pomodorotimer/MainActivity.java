package com.example.ankush.pomodorotimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar timerSeekbar;
    TextView timerTextView;
    Button button;
    boolean counterIsActive=false;
    CountDownTimer countDownTimer;

    public void controlTimer(View view){

        if(counterIsActive==false) {
            counterIsActive = true;
            timerSeekbar.setEnabled(false);
            button.setText("pause");

          countDownTimer=  new CountDownTimer(timerSeekbar.getProgress() * 1000 + 100, 1000) {  // first param is timer till which to count
                // second param is in what intervals should it count
                @Override
                public void onTick(long millisUntilFinished) {

                    // after every second

                    updateTime((int) (millisUntilFinished / 1000));


                }

                @Override
                public void onFinish() {
                    // when conter is finished(after 10 sec)

                    //playsound
                    resettimer();
                    MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mplayer.start();

                }
            }.start();

        }else{                               // Stoping the timer not pausing
           resettimer();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekbar=(SeekBar) findViewById(R.id.seekBar);
        timerTextView= (TextView)findViewById(R.id.timertextView);
        button=(Button)findViewById(R.id.button);


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

    public void resettimer(){
        button.setText("Start");
        counterIsActive=false;
        countDownTimer.cancel();

        timerSeekbar.setEnabled(true);
    }


}
