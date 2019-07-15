package io.huggy.demo;

import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import io.huggy.chatsdk.HuggyNotification;

import java.util.Map;

public class DemoMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Map<String, String> payload = remoteMessage.getData();

        Intent resultIntent = new Intent(this, DemoChatActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);

        HuggyNotification.getInstance(this)
                .handleTapNotification(stackBuilder)
                .notifyAppInForeground()
                .notify(payload,
                        R.drawable.ic_stat_name,
                        payload.get("sender_name") + " disse:" ,
                        payload.get("text"));
    }
}
