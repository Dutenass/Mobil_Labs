package com.example.lab_1;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);



        String user = getIntent().getExtras().getString("username");
        String gift = getIntent().getExtras().getString("gift");

        EditText infoTextView = (EditText)findViewById(R.id.editText3);
        TextView infoTextView_2 = (TextView)findViewById(R.id.textView8);
        infoTextView.setText(user);
        infoTextView_2.setText(gift);

    }

}
