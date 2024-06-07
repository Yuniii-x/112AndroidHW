package com.example.hwlogin;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static final String DEFAULT_Account = "A111222028";
    public static final String DEFAULT_Password = "0000";

    public void button_Click(View view)
    {
        EditText edtAccount = (EditText) findViewById(R.id.edtAccount);
        EditText edtPassword = (EditText) findViewById(R.id.edtPassword);
        TextView txvShow = (TextView) findViewById(R.id.txvShow);

        String username = edtAccount.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.equals(DEFAULT_Account) && password.equals(DEFAULT_Password))
        {
            txvShow.setText("登入成功");
        } else if (username.equals(DEFAULT_Account))
        {
            txvShow.setText("密碼錯誤，登入失敗");
        } else if (password.equals(DEFAULT_Password))
        {
            txvShow.setText("帳號錯誤，登入失敗");
        } else
        {
            txvShow.setText("帳號和密碼錯誤，登入失敗");
        }
    }
}