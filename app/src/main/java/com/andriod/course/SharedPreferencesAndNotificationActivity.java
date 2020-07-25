package com.andriod.course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharedPreferencesAndNotificationActivity extends AppCompatActivity {

    String CHANNEL_ID = "CHANNEL_ID";
    String fileName = "userDate";
    String key1 = "email";


    EditText email;
    Button save, display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_and_notification);

        email = findViewById(R.id.email);
        save = findViewById(R.id.save);
        display = findViewById(R.id.display);

        createNotificationChannel();


        final SharedPreferences sharedPreferences = getSharedPreferences(fileName, MODE_PRIVATE);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(key1, email.getText().toString());
                editor.apply();
            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SharedPreferencesAndNotificationActivity.this
                        , "" + sharedPreferences.getString(key1, "No Value"), Toast.LENGTH_SHORT).show();
                createNotification(sharedPreferences.getString(key1, "No Value"));
            }
        });


    }

    private void createNotification(String s) {
        Intent intent = new Intent(SharedPreferencesAndNotificationActivity.this, FullSignupActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(SharedPreferencesAndNotificationActivity.this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(SharedPreferencesAndNotificationActivity.this, CHANNEL_ID)
                .setSmallIcon(R.drawable.product1)
                .setContentTitle("textTitle")
                .setContentText("textContent")
                .setContentIntent(pendingIntent)
                .setOngoing(false)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("fdsssssssssssssssssssssssssssssdsfffffffffffffffffffff"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(SharedPreferencesAndNotificationActivity.this);
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
