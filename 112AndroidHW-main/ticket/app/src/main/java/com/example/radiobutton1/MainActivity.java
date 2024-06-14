//A111222032
package com.example.radiobutton1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText ednTicket = findViewById(R.id.ednTicket);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        RadioGroup rgType = findViewById(R.id.rgType);
        TextView output = findViewById(R.id.lblOutput);
        Button button = (Button) findViewById(R.id.button);

        // 監聽票數輸入變化
        ednTicket.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                updateOutput();
            }
        });

        // 監聽性別選擇變化
        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput();
            }
        });

        // 監聽票種選擇變化
        rgType.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                updateOutput();
            }
        });

        // 監聽按鈕點擊事件
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 更新结果
                updateOutput();

                // 啟動新的 Activity 並傳遞结果
                Intent intent = new Intent(MainActivity.this, result_activity.class);
                intent.putExtra("result", output.getText().toString());
                startActivity(intent);
            }
        });

        // 初始化输出
        updateOutput();
    }
    private void updateOutput() {
        EditText ednTicket = findViewById(R.id.ednTicket);
        RadioGroup rgGender = findViewById(R.id.rgGender);
        RadioGroup rgType = findViewById(R.id.rgType);
        TextView output = findViewById(R.id.lblOutput);

        int numTicket = 0;
        try {
            numTicket = Integer.parseInt(ednTicket.getText().toString());
        } catch (NumberFormatException e) {
            // 處理無法轉換為整數的情况
            e.printStackTrace();
        }

        String outputStr = "";
        if (rgGender.getCheckedRadioButtonId() == R.id.rdbBoy) {
            outputStr += getResources().getString(R.string.male) + "\n";
        } else if (rgGender.getCheckedRadioButtonId() == R.id.rdbGirl) {
            outputStr += getResources().getString(R.string.female) + "\n";
        }

        int price;
        if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
            price = 500 * numTicket;
            outputStr += getResources().getString(R.string.regularticket) + "\t" + String.valueOf(numTicket) +"張\n";
        } else if (rgType.getCheckedRadioButtonId() == R.id.rdbStudent) {
            price = 400 * numTicket;
            outputStr += getResources().getString(R.string.studentticket) + "\t" + String.valueOf(numTicket) +"張\n";
        } else {
            price = 250 * numTicket;
            outputStr += getResources().getString(R.string.childticket) + "\t" + String.valueOf(numTicket) +"\n";
        }
        outputStr += String.valueOf(price);

        output.setText(outputStr);
    }
}