//A111222031
package com.example.raddiobuton1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int adultTicketPrice = 500;
    private int studentTicketPrice = 400;
    private int childTicketPrice = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String outputStr = "";
                RadioButton rdbBoy = (RadioButton) findViewById(R.id.rdbBoy);
                RadioButton rdbGirl = (RadioButton) findViewById(R.id.rdbGirl);
                if (rdbBoy.isChecked())
                    outputStr += getResources().getString(R.string.male) + "\n";
                else if (rdbGirl.isChecked())
                    outputStr += getResources().getString(R.string.female) + "\n";

                RadioGroup rgType = (RadioGroup) findViewById(R.id.rgType);
                int selectedTicketPrice = 0;
                if (rgType.getCheckedRadioButtonId() == R.id.rdbAdult) {
                    outputStr += getResources().getString(R.string.regularticket) + "\n";
                    selectedTicketPrice = adultTicketPrice;
                } else if (rgType.getCheckedRadioButtonId() == R.id.rdbChild) {
                    outputStr += getResources().getString(R.string.childticket) + "\n";
                    selectedTicketPrice = childTicketPrice;
                } else {
                    outputStr += getResources().getString(R.string.studentticket) + "\n";
                    selectedTicketPrice = studentTicketPrice;
                }

                EditText etTicketCount = (EditText) findViewById(R.id.etTicketCount);
                int ticketCount = Integer.parseInt(etTicketCount.getText().toString());

                int totalPrice = selectedTicketPrice * ticketCount;
                outputStr += "購買張數: " + ticketCount + "\n" + "總價錢: " + totalPrice + "元";

                TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
                lblOutput.setText(outputStr);
            }
        });
    }
}