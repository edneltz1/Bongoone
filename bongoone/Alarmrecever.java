package com.example.ednel.bongoone;

/**
 * Created by EdNel on 3/26/2018.
 */
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;
public class Alarmrecever extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager manager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent alarmIntent = new Intent(context, MainActivity.class);
        alarmIntent.setAction(intent.ACTION_MAIN);
        PendingIntent edson=PendingIntent.getBroadcast(context, 0, alarmIntent, 0);




        android.support.v4.app.NotificationCompat.Builder builder = new NotificationCompat.Builder(context.getApplicationContext())
                .setSmallIcon(R.drawable.radios)
                .setContentTitle("BONGO RADIOS")
                .setLargeIcon(((BitmapDrawable) context.getApplicationContext().getResources().getDrawable(R.drawable.radios)).getBitmap())
                .setAutoCancel(true)

                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentText("Liten Now Amaizing shows from your favorite stations")
                .setContentIntent(edson)
                ;



        manager.notify(9,builder.build());

    }
}



