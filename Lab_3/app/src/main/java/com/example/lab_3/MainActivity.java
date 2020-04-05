package com.example.lab_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;
    TextView tv_result;
    String string;
    String Fullstring;
    String st1;
    String st2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        tv_result = findViewById(R.id.tv_result);
    }

    public void onGenClick(View view) {
        string = Phraser.PhraserGen();
        textView.setText("Всё, что нам нужно – это "+string);
        Fullstring=(String)textView.getText();
        st1=Fullstring.substring(0,18);
        st2=Fullstring.substring(25);
        tv_result.setText((st2+" "+st1).substring(0,1).toUpperCase()+(st2+" "+st1).substring(2)+".");
    }

}
