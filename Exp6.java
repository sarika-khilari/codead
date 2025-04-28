-	MainActivity.java
package com.example.webviewapp;
import android.os.Bundle;	
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.myWebView);

        // Enable JavaScript
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
                // Load your website
                myWebView.loadUrl("https://www.example.com");

                // Open links in the same WebView
                myWebView.setWebViewClient(new WebViewClient());
            }
        
            @Override
            public void onBackPressed() {
                if (myWebView.canGoBack()) {
                    myWebView.goBack();
                } else {
                    super.onBackPressed();
                }
            }
        }
        -	Activity_main.xml
	
        <?xml version="1.0" encoding="utf-8"?>
        <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
            android:layout_width="match_parent"
            android:layout_height="match_parent">
        
            <WebView
                android:id="@+id/myWebView"
                android:layout_width="match_parent"
                android:layout_height="match_parent" />
        </RelativeLayout>                        
