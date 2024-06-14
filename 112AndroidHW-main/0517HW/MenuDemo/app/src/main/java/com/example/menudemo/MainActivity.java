package com.example.menudemo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    private ListView subItemList;
    private TextView tvMainDish;
    private TextView tvSideDish;
    private TextView tvDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("SPandLV");

        Spinner orderSpinner = findViewById(R.id.order);
        subItemList = findViewById(R.id.subitem_list);
        tvMainDish = findViewById(R.id.tv_main_dish);
        tvSideDish = findViewById(R.id.tv_side_dish);
        tvDrink = findViewById(R.id.tv_drink);

        orderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateSubItemList(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        subItemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Spinner orderSpinner = findViewById(R.id.order);
                int orderPosition = orderSpinner.getSelectedItemPosition();
                updateSelectedItem(orderPosition, selectedItem);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_submit) {
            handlePrint();
            return true;
        } else if (itemId == R.id.action_cancel) {
            confirmCancel();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handlePrint() {
        String mainDish = tvMainDish.getText().toString();
        String sideDish = tvSideDish.getText().toString();
        String drink = tvDrink.getText().toString();

        Intent intent = new Intent(MainActivity.this, print.class);
        intent.putExtra("main_dish", mainDish);
        intent.putExtra("side_dish", sideDish);
        intent.putExtra("drink", drink);
        startActivity(intent);
    }

    private void confirmCancel() {
        new AlertDialog.Builder(this)
                .setTitle("確定取消")
                .setMessage("您確定要取消選擇嗎？")
                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        clearTextViews();
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    private void clearTextViews() {
        tvMainDish.setText("主餐：請選擇");
        tvSideDish.setText("附餐：請選擇");
        tvDrink.setText("飲料：請選擇");
    }

    private void updateSubItemList(int position) {
        int subItemArrayId;
        switch (position) {
            case 0: // 主餐
                subItemArrayId = R.array.main_dishes;
                break;
            case 1: // 附餐
                subItemArrayId = R.array.side_dishes;
                break;
            case 2: // 飲料
                subItemArrayId = R.array.drinks;
                break;
            default:
                subItemArrayId = 0;
                break;
        }

        if (subItemArrayId != 0) {
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    subItemArrayId, android.R.layout.simple_list_item_1);
            subItemList.setAdapter(adapter);
        } else {
            subItemList.setAdapter(null);
        }
    }

    private void updateSelectedItem(int position, String selectedItem) {
        switch (position) {
            case 0: // 主餐
                tvMainDish.setText("主餐：" + selectedItem);
                break;
            case 1: // 附餐
                tvSideDish.setText("附餐：" + selectedItem);
                break;
            case 2: // 飮料
                tvDrink.setText("飲料：" + selectedItem);
                break;
        }
    }
}