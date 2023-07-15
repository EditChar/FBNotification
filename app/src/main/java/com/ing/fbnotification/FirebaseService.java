package com.ing.fbnotification;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;

public class FirebaseService extends FirebaseMessagingService {
    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);

        //ihtiyacınız olduğunda kaydetmek için gönderin
        Log.d(Utils.TAG,token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);

        //aldığımızda bildirimi göster
        String title = message.getNotification().getTitle();
        String content = message.getNotification().getBody();
        String data = new Gson().toJson(message.getData());

        //Bildirim gösterimi oluştur(utils showNotification)
        Utils.showNotification(this,title,content);
        //Verileri logda göster
        Log.d(Utils.TAG,data);

    }
}
