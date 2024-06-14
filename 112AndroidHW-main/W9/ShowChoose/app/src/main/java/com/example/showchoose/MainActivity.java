package com.example.showchoose;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 获取传递过来的Intent对象
        Intent intent = getIntent();

        // 从Intent中获取数据
        if(intent != null && intent.getExtras() != null) {
            String outputText = intent.getExtras().getString("outputText");

            // 将数据设置给TextView
            TextView resultTextView = findViewById(R.id.lblresult);
            resultTextView.setText(outputText);
        }
    }
}