package com.example.order;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox chk1, chk2, chk3, chk4, chk5;
    private ImageView output1, output2, output3, output4, output5;
    private TextView showOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = findViewById(R.id.chk1);
        chk2 = findViewById(R.id.chk2);
        chk3 = findViewById(R.id.chk3);
        chk4 = findViewById(R.id.chk4);
        chk5 = findViewById(R.id.chk5);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);
        output5 = findViewById(R.id.output5);

        showOrder = findViewById(R.id.showOrder);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateShowOrder();
                output1.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateShowOrder();
                output2.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateShowOrder();
                output3.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        chk4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateShowOrder();
                output4.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        chk5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                updateShowOrder();
                output5.setVisibility(isChecked ? View.VISIBLE : View.GONE);
            }
        });

        // 更新 showOrder 的方法
    }

    private void updateShowOrder() {
        if (chk1.isChecked() || chk2.isChecked() || chk3.isChecked() || chk4.isChecked() || chk5.isChecked()) {
            showOrder.setText("您的餐點如下");
        } else {
            showOrder.setText("請點餐");
        }
    }
}
