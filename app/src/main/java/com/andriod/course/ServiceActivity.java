package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class ServiceActivity extends AppCompatActivity {
    Context context = this;
    MyService.LocalBinder localBinder;
    SeekBar seekbar;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        seekbar = findViewById(R.id.seekbar);
        time = findViewById(R.id.time);

        final ServiceConnection mServerConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder binder) {
                Log.e("Test", "onServiceConnected");
                localBinder = ((MyService.LocalBinder) binder).getService();
                seekbar.setMax(localBinder.getDuration());

                final Handler mHandler = new Handler();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        seekbar.setProgress(localBinder.getCurrentPosition());
                        //            Log.e("Test Test", "" + localBinder.getCurrentPosition());
                        //              Log.e("Passed", "" + TimeUnit.MILLISECONDS.toSeconds(localBinder.getCurrentPosition()));
                        time.setText(TimeUnit.MILLISECONDS.toSeconds(localBinder.getCurrentPosition()) + " s");
                        mHandler.postDelayed(this, 1000);
                    }
                });

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.d("Test", "onServiceDisconnected");
            }
        };


        findViewById(R.id.start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startService(new Intent(context, MyService.class));
                bindService(new Intent(context, MyService.class)
                        , mServerConn
                        , BIND_AUTO_CREATE);
            }
        });
        findViewById(R.id.stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                stopService(new Intent(context, MyService.class));
                unbindService(mServerConn);
            }
        });

        findViewById(R.id.stop_song).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (localBinder.isPlaying()) {
                    localBinder.pause();
                } else {
                    localBinder.start();
                }
            }
        });


        findViewById(R.id.next_song).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localBinder.nextSong(ServiceActivity.this);
                seekbar.setMax(localBinder.getDuration());
            }
        });
        findViewById(R.id.per_song).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                localBinder.perSong(ServiceActivity.this);
                seekbar.setMax(localBinder.getDuration());
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                localBinder.seekTo(seekBar.getProgress());
            }
        });
    }

}
