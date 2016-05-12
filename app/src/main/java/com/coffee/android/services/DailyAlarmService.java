package com.coffee.android.services;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.coffee.android.MainMenuActivity;
import com.coffee.android.R;

/**
 * Created by michal_re on 09/05/2016.
 */
public class DailyAlarmService extends Service {

    private static final int NOTIFICATION_ID = 1;
    private NotificationManager notificationManager;
    private PendingIntent pendingIntent;
    private AlarmManager alarmManager;

    @Override
    public void onCreate() {
        super.onCreate();

        Intent alarmIntent = new Intent(this, AlarmReceiver.class);
        alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 60 * 1000,// 24 * 60 *
                PendingIntent.getBroadcast(this, 0, alarmIntent, 0));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
