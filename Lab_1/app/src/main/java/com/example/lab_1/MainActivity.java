package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    double liters;
    double gallons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView4);

    }

    public void onButtonClick(View v) {
        liters = Double.parseDouble(editText.getText().toString());
        gallons = liters*0.264172;
        textView.setText(String.valueOf(gallons));
    }

    public void onClickHelp(View view) {
        EditText userEditText = (EditText) findViewById(R.id.editText);
        TextView giftEditText = (TextView) findViewById(R.id.textView4);
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        intent.putExtra("username", userEditText.getText().toString());
        // в ключ gift пихаем текст из второго текстового поля
        intent.putExtra("gift", giftEditText.getText().toString());
        startActivity(intent);
    }

}
