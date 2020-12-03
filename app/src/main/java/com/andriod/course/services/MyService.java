package com.andriod.course.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.andriod.course.R;

public class MyService extends Service {
    IBinder mLocalBinder = new LocalBinder();
    MediaPlayer mediaPlayer;
    int[] songs = {R.raw.ellie_goulding_burn
            , R.raw.adele_someone_like_you
            , R.raw.rihanna_diamonds};
    int postion = 0;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("onBind", "Done");
        mediaPlayer = MediaPlayer.create(this
                , songs[postion]);
        mediaPlayer.start();
        return mLocalBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("onCreate", "Done");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("onStartCommand", "Done");
        Log.e("startId", "" + startId);

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("onDestroy", "Done");
        mediaPlayer.stop();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("onUnbind", "Done");
        return super.onUnbind(intent);
    }

    public class LocalBinder extends Binder {
        public LocalBinder getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocalBinder.this;
        }

        public void pause() {
            mediaPlayer.pause();
        }

        public void start() {
            mediaPlayer.start();
        }

        public boolean isPlaying() {
            return mediaPlayer.isPlaying();
        }

        public void nextSong(Context context) {
            if (postion < (songs.length - 1)) {
                postion++;
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(context, songs[postion]);
                mediaPlayer.start();
            } else {
                Toast.makeText(context, "This is the last songe", Toast.LENGTH_SHORT).show();
            }
        }

        public void perSong(Context context) {
            if (postion != 0) {
                postion--;
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(context, songs[postion]);
                mediaPlayer.start();
            } else {
                Toast.makeText(context, "This is the first songe", Toast.LENGTH_SHORT).show();
            }
        }

        public int getDuration() {
            return mediaPlayer.getDuration();
        }

        public int getCurrentPosition() {
            return mediaPlayer.getCurrentPosition();
        }

        public void seekTo(int seekToNumber) {
            mediaPlayer.seekTo(seekToNumber);
        }


    }

}
