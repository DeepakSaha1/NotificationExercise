package com.example.notificationexercise;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import static com.example.notificationexercise.NotificationAppHelper.CHANNEL_1_ID;
import static com.example.notificationexercise.NotificationAppHelper.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
    }

    public void sendOnChannel1(View v) {
        repeatChannel();

    }

    public void repeatChannel() {
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_audiotrack_black_24dp)
                .setContentTitle("Title First")
                .setContentText("This is  1st message...")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setSound(alarmSound)
                .setVibrate(new long[] {1000, 1000});

        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        intent.putExtra(Constants.INTENT_KEY_MESSAGE, "This is a notification message");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        //pending intent will be called once user click the notification
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

        // Set the intent that will fire when the user taps the notification

        builder.setContentIntent(pendingIntent);

        // Notice this code calls setAutoCancel(), which automatically
        // removes the notification when the user taps it.
        builder.setAutoCancel(true);

        notificationManager.notify(1, builder.build());
        // repeating notification after every 10sec
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sendOnChannel2();
    }


    public void sendOnChannel2() {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, CHANNEL_2_ID)
                        .setSmallIcon(R.drawable.ic_mic_off)
                        .setContentTitle("Title Second")
                        .setContentText("This is 2nd message")
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.putExtra(Constants.INTENT_KEY_MESSAGE, "This is a notification message");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, 0);

                // Set the intent that will fire when the user taps the notification
                builder.setContentIntent(pendingIntent);

                // Notice this code calls setAutoCancel(), which automatically
                // removes the notification when the user taps it.
                builder.setAutoCancel(true);

                notificationManager.notify(2, builder.build());

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repeatChannel();
    }
}
