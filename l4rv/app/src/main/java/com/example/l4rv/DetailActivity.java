package com.example.l4rv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView td_id;
    TextView td_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

            String id = intent.getStringExtra("ARG_ITEM_ID");
            String details = intent.getStringExtra("ARG_ITEM_DETAILS");
            td_id = findViewById(R.id.textView);
            td_desc = findViewById(R.id.td_desc);
            td_id.setText(id);
            td_desc.setText(details);

    }
}
