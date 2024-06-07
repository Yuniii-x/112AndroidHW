//a111222024

package com.example.hw_ticket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 找到 UI 元素
        Button button = (Button) findViewById(R.id.button); // 找到確認按鈕
        EditText edtQuantity = (EditText) findViewById(R.id.edtQuantity);
        // 找到輸入購買數量的文本框
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
        // 找到用於顯示結果的文本視圖

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 獲取購買數量
                int quantity;
                try {
                    quantity = Integer.parseInt(edtQuantity.getText().toString());
                } catch (NumberFormatException e) {
                    lblOutput.setText("請輸入有效的購買數量");
                    return;
                }

                if (quantity < 1) {
                    lblOutput.setText("購買數量應該至少為 1");
                    return;
                }

                // 獲取性別
                String gender = "";
                RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                // 找到男性選項
                RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                // 找到女性選項
                if (rdbBoy.isChecked()) {
                    gender = getResources().getString(R.string.male);
                    // 如果男性選項被選中，則將性別設置為男性
                } else if (rdbGirl.isChecked()) {
                    gender = getResources().getString(R.string.female);
                    // 如果女性選項被選中，則將性別設置為女性
                }

                // 獲取票券類型並計算總金額
                RadioGroup rgType = (RadioGroup) findViewById(R.id.rgType);
                // 找到票券類型的單選按鈕組
                int ticketPrice = 0;

                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    ticketPrice = 500; // 如果選中的是全票，則票價為 500 元
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    ticketPrice = 250; // 如果選中的是兒童票，則票價為 250 元
                } else {
                    ticketPrice = 400; // 如果選中的是學生票，則票價為 400 元
                }

                int totalAmount = ticketPrice * quantity; // 計算總金額

                // 構建輸出字串
                String outputStr = gender + "\n"; // 添加性別到輸出字串
                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    outputStr += getResources().getString(R.string.regularticket);
                    // 如果選中的是全票，則添加全票字串到輸出字串
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    outputStr += getResources().getString(R.string.childticket);
                    // 如果選中的是兒童票，則添加兒童票字串到輸出字串
                } else {
                    outputStr += getResources().getString(R.string.studentticket);
                    // 如果選中的是學生票，則添加學生票字串到輸出字串
                }

                outputStr += "\n購買數量: " + quantity; // 添加購買數量到輸出字串
                outputStr += "\n總金額: " + totalAmount; // 添加總金額到輸出字串

                lblOutput.setText(outputStr); // 顯示輸出字串到結果視圖
            }
            public void onConfirmButtonClick(View view) {
                // 創建一個 Intent 對象，指定要啟動的目標活動
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);

                // 啟動新活動
                startActivity(intent);
            }

        });
    }
}