package com.example.notificationexercise;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificationAppHelper extends Application {
    public static final String CHANNEL_1_ID = "channel1";
    public static final String CHANNEL_2_ID = "channel2";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();
    }

    /**
     * Creates a notification channel.
     *
     * @param id The id of the channel. Must be unique per package.
     * @param name The user visible name of the channel.
     * @param importance The importance of the channel.
     */

    private void createNotificationChannels() {
        //Notification channels class is not avail below Oreo ver or API 26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1 with Vibration and Sound");
            channel1.setVibrationPattern(new long[]{1000, 1000});

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_2_ID,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel2.setDescription("This is Channel 2 with Silence");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
            manager.createNotificationChannel(channel2);
        }
    }
}
