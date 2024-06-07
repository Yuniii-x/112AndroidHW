package com.example.hwcounter;

import android.os.Bundle;
import android.view.View;
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

    public void button_Click(View view)
    {
        int count;
        TextView output = (TextView) findViewById(R.id.textView);
        count = Integer.parseInt(output.getText().toString());
        count--;
        output.setText(Integer.toString(count));
    }

    public void button2_Click(View view)
    {
        TextView output = (TextView) findViewById(R.id.textView);
        output.setText(R.string.ini_value);
    }
}