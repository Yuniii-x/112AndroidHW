package com.example.menudemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class print extends AppCompatActivity {

    private TextView tvMainDish;
    private TextView tvSideDish;
    private TextView tvDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        tvMainDish = findViewById(R.id.tv_main_dish);
        tvSideDish = findViewById(R.id.tv_side_dish);
        tvDrink = findViewById(R.id.tv_drink);

        // 获取从MainActivity传递过来的数据
        String mainDish = getIntent().getStringExtra("main_dish");
        String sideDish = getIntent().getStringExtra("side_dish");
        String drink = getIntent().getStringExtra("drink");

        // 显示数据
        tvMainDish.setText(mainDish);
        tvSideDish.setText(sideDish);
        tvDrink.setText(drink);
    }
}