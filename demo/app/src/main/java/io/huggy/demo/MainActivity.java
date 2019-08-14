package io.huggy.demo;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.huggy.chatsdk.HuggyChat;
import io.huggy.chatsdk.HuggyNotification;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private Button openChat;
    private Button subscribe;
    private ImageView logo;
    private TextView huggyLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Huggy Chat SDK ");

        huggyLink = findViewById(R.id.textHuggyChat);
        huggyLink.setText(Html.fromHtml("<u>Huggy Chat SDK</u>"));
        huggyLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.huggy.io/"));
            startActivity(browserIntent);
        });

        openChat = findViewById(R.id.open_chat);
        this.openChat.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DemoChatActivity.class);
            startActivity(intent);
        });

        subscribe = findViewById(R.id.subscribe);
        this.subscribe.setOnClickListener(v -> {
            HuggyChat chat = HuggyChat.getInstance();
            chat.unsubscribeFromTopic();
        });

        AssetManager assetManager = getAssets();
        InputStream is = null;
        try {
            is = assetManager.open("logo.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.logo = findViewById(R.id.logo);
        logo.setImageBitmap(BitmapFactory.decodeStream(is));

        HuggyNotification.getInstance(this);
    }
}
