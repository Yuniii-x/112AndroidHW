package com.example.hw_ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // 從 Intent 中獲取 lblOutput 的內容
        Intent intent = getIntent();
        String outputText = intent.getStringExtra("outputText");

        // 找到結果畫面中的 TextView
        TextView resultTextView = findViewById(R.id.resultTextView);
        // 將 lblOutput 的內容設置到結果畫面中的 TextView 中
        resultTextView.setText(outputText);
    }


}
