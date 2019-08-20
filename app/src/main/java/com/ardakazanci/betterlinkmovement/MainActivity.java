package com.ardakazanci.betterlinkmovement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.util.Linkify;
import android.widget.TextView;
import android.widget.Toast;

import me.saket.bettermovementmethod.BetterLinkMovementMethod;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfoContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInfoContent = findViewById(R.id.txtDemo);
        BetterLinkMovementMethod.linkify(Linkify.ALL, tvInfoContent)
                .setOnLinkClickListener(new BetterLinkMovementMethod.OnLinkClickListener() {
                    @Override
                    public boolean onClick(TextView textView, String url) {

                        if (url.contains("tel : ")) {
                            Toast.makeText(MainActivity.this, "PHONE : " + url.replace("tel:", ""), Toast.LENGTH_SHORT).show();
                        } else if (url.contains("mailto:")) {
                            Toast.makeText(MainActivity.this, "E-MAIL : " + url.replace("mailto:", ""), Toast.LENGTH_SHORT).show();
                        } else if (url.contains("http")) {
                            Toast.makeText(MainActivity.this, "WEB-SITE : " + url, Toast.LENGTH_SHORT).show();
                        }

                        return false;

                    }
                });

    }
}
