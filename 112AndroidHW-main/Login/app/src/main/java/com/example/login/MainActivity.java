package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextAccount;
    EditText editTextPassword;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAccount = findViewById(R.id.editTextAccount);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void button(View view) {
        String account = editTextAccount.getText().toString();
        String password = editTextPassword.getText().toString();

        if (account.isEmpty()) {
            textViewResult.setText("帳號未輸入請輸入帳號");
        } else if (password.isEmpty()) {
            textViewResult.setText("密碼未輸入請輸入密碼");
        } else if (!account.equals("A111222029")) {
            textViewResult.setText("帳號錯誤");
        } else if (!password.equals("!QazTNT1123")) {
            textViewResult.setText("密碼錯誤");
        } else {
            textViewResult.setText("登錄成功");
        }
    }
}