package com.example.xenya.navigationdrawer;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmBroadcastReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentToActivity = new Intent(context, WakedUpActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, ButtonNavFragment.REQUEST_CODE, intentToActivity, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationHelper.showNotification(context, pendingIntent);
    }
}
