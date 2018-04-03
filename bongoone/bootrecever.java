package com.example.ednel.bongoone;

/**
 * Created by EdNel on 3/26/2018.
 */
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class bootrecever extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            /* Setting the alarm here */
            Intent alarmIntent = new Intent(context, Alarmrecever.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
//nimest alarm baada ya masaa 24
            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            int interval = 1000*60*8400;
            manager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);

           // Toast.makeText(context, "Alarm Set", Toast.LENGTH_SHORT).show();

            android.support.v4.app.NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext())
                    .setSmallIcon(R.drawable.radios)
                    .setContentTitle("BONGO RADIOS")
                    .setLargeIcon(((BitmapDrawable) context.getApplicationContext().getResources().getDrawable(R.drawable.radios)).getBitmap())
                    .setAutoCancel(true)
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .setContentText("Liten Now Amaizing shows")
                    ;
            NotificationManager manager1=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

            manager1.notify(9,builder.build());


        }

    }
    }