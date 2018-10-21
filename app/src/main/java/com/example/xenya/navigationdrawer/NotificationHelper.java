package com.example.xenya.navigationdrawer;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;

import androidx.core.app.NotificationCompat;

public class NotificationHelper {

    private static String CHANNEL_ID = "Alarm";

    public static void showNotification(Context context, PendingIntent pendingIntent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notificationCompat = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle("WAKE UP")
                .setContentText("Время бурить небеса!")
                .setSmallIcon(R.drawable.ave)
                .setContentIntent(pendingIntent)
                .build();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Alarm", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        notificationManager.notify(CHANNEL_ID, 0, notificationCompat);
    }
}
