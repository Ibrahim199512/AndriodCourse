package com.andriod.course.firebase_utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.andriod.course.R;
import com.andriod.course.activities.FullSignupActivity;
import com.andriod.course.activities.RealTimeDatabaseActivity;
import com.andriod.course.activities.SharedPreferencesAndNotificationActivity;
import com.andriod.course.activities.UploadFileAndImagesActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    String CHANNEL_ID = "CHANNEL_ID";

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d("onNewToken", token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("onMessageReceived", "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d("TAG", "Message data payload: " + remoteMessage.getData());
            Map<String, String> params = remoteMessage.getData();
            JSONObject object = new JSONObject(params);
            Log.e("JSON OBJECT", object.toString());
            try {
                if (object.has("type")) {
                    String type = object.getString("type");
                    Log.d("type", type + "");
                    createNotificationChannel();
                    createNotification("Done", Integer.parseInt(type));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }

    private void createNotification(String s, int type) {
        Intent intent = new Intent(this, FullSignupActivity.class);
        Intent intent1 = new Intent(this, UploadFileAndImagesActivity.class);
        Intent intent2 = new Intent(this, RealTimeDatabaseActivity.class);
        PendingIntent pendingIntent = null;
        if (type == 0) {
            pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        }else if(type==1){
            pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);
        }else {
            pendingIntent = PendingIntent.getActivity(this, 0, intent2, 0);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.product1)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setContentIntent(pendingIntent)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("fdsssssssssssssssssssssssssssssdsfffffffffffffffffffff"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Uri sound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_NOTIFICATION).build();
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "CHANNEL_NAME", importance);
            channel.setDescription("CHANNEL_DESCRIPTION");
            channel.setSound(sound, audioAttributes);
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
