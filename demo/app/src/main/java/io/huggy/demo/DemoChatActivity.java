package io.huggy.demo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import io.huggy.chatsdk.HuggyAttachments;
import io.huggy.chatsdk.HuggyChat;

public class DemoChatActivity extends AppCompatActivity {
    private static final String SDK_ID = "40b1c6b7-c591-4e1a-a3c3-0560f41b1a51";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_chat);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Huggy Chat");
        webView = findViewById(R.id.web_view);

        HuggyChat.getInstance(this.SDK_ID).setUpWebView(webView, DemoChatActivity.this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        HuggyAttachments.handleAttachment(requestCode, resultCode, data);
    }
}
