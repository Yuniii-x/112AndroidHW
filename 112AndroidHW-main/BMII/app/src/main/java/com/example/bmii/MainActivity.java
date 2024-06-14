package com.example.bmii;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txvShow;
    private EditText edtHeight;
    private EditText edtWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtHeight = findViewById(R.id.edtHeight);
        edtWeight = findViewById(R.id.edtWeight);
        txvShow = findViewById(R.id.txvShow);
        txvShow.setTextSize(36);

        Button btnCalc = findViewById(R.id.btnCalc);
        Button btnClear = findViewById(R.id.btnClear);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidInput()) {
                    double height = Double.parseDouble(edtHeight.getText().toString());
                    double weight = Double.parseDouble(edtWeight.getText().toString());
                    double bmi = weight / Math.pow(height / 100.0, 2);
                    if (bmi >= 24)
                        txvShow.setTextColor(Color.RED);
                    else if (bmi < 18.5)
                        txvShow.setTextColor(Color.BLUE);
                    else
                        txvShow.setTextColor(Color.GREEN);

                    txvShow.setText(String.format("%.2f", bmi));
                } else {
                    txvShow.setTextColor(Color.BLACK);
                    txvShow.setText("輸入錯誤，請重新輸入！");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtHeight.setText("");
                edtWeight.setText("");
                txvShow.setText("");
            }
        });
    }

    private boolean isValidInput() {
        String heightStr = edtHeight.getText().toString();
        String weightStr = edtWeight.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty())
            return false;

        try {
            double height = Double.parseDouble(heightStr);
            double weight = Double.parseDouble(weightStr);
            // 检查身高和体重是否大于0
            if (height <= 0 || weight <= 0)
                return false;
        } catch (NumberFormatException e) {
            return false; // 输入不是有效的数字
        }

        return true;
    }
}