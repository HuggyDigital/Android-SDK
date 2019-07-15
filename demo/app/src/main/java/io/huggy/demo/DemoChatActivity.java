package io.huggy.demo;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import io.huggy.chatsdk.HuggyChat;

public class DemoChatActivity extends AppCompatActivity {

    private static final String SDK_ID = "e15e394a-3314-467e-a049-99cd76210ae3";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_chat);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Huggy Chat");
        webView = findViewById(R.id.web_view);

        HuggyChat.getInstance(this.SDK_ID, getApplicationContext()).setUpWebView(webView);
    }
}
