package com.example.foodimgmenu_0503hw;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private CheckBox chk_Burger, chk_FrenchFry, chk_Soup, chk_Coffee, chk_SoftDrink;
    private ImageView output1, output2, output3, output4, output5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk_Burger = findViewById(R.id.chk_burger);
        chk_FrenchFry = findViewById(R.id.chk_frenchfry);
        chk_Soup = findViewById(R.id.chk_soup);
        chk_Coffee = findViewById(R.id.chk_coffee);
        chk_SoftDrink = findViewById(R.id.chk_softdrink);

        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        output3 = findViewById(R.id.output3);
        output4 = findViewById(R.id.output4);
        output5 = findViewById(R.id.output5);

        // 监听复选框的状态变化
        chk_Burger.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                output1.setVisibility(ImageView.VISIBLE);
            } else {
                output1.setVisibility(ImageView.GONE);
            }
        });

        chk_FrenchFry.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                output2.setVisibility(ImageView.VISIBLE);
            } else {
                output2.setVisibility(ImageView.GONE);
            }
        });

        chk_Soup.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                output3.setVisibility(ImageView.VISIBLE);
            } else {
                output3.setVisibility(ImageView.GONE);
            }
        });

        chk_Coffee.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                output4.setVisibility(ImageView.VISIBLE);
            } else {
                output4.setVisibility(ImageView.GONE);
            }
        });

        chk_SoftDrink.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                output5.setVisibility(ImageView.VISIBLE);
            } else {
                output5.setVisibility(ImageView.GONE);
            }
        });
    }
}