package com.example.radiobutton1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        // 獲取傳遞的结果
        String result = getIntent().getStringExtra("result");

        // 在 TextView 中顯示结果
        TextView resultTextView = findViewById(R.id.Result);
        resultTextView.setText(result);
    }
}
