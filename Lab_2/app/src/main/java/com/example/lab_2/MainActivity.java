package com.example.lab_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    private double amount = 0.0; // Сумма счёта
    private double percent = 0.15; // Процент чаевых по умолчанию.
    private EditText et_amount; // Поле для ввода суммы счёта
    private SeekBar sb_percent; // Ползунок для процентов
    private TextView tv_percent; // Поле для значения процента
    private TextView tv_tip; // Поле для суммы чаевых
    private TextView tv_total; // Поле для итоговой суммы


    private final TextWatcher amountTextWatcher = new TextWatcher() {
        // Вызывается при изменении пользователем величины счета
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            amount = Double.parseDouble(s.toString());

            // Обновление полей с чаевыми и общей суммой
            final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            final NumberFormat percentFormat = NumberFormat.getPercentInstance();
            tv_percent.setText(percentFormat.format(percent));
            tv_tip.setText(currencyFormat.format(Calc.calculateTip(amount,percent)));
            tv_total.setText(currencyFormat.format(Calc.calculateTotal(amount, percent)));
        }
        @Override
        public void afterTextChanged(Editable s) { }
        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final SeekBar.OnSeekBarChangeListener sbListener = new SeekBar.OnSeekBarChangeListener() {
        // Обновление процента чаевых и итоговой суммы

        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
            final NumberFormat percentFormat = NumberFormat.getPercentInstance();
            percent = progress / 100.0; // Назначение процента чаевых
            // Вычисление чаевых и общей суммы. Вывод их на экран.
            tv_percent.setText(percentFormat.format(percent));
            tv_tip.setText(currencyFormat.format(Calc.calculateTip(amount,percent)));
            tv_total.setText(currencyFormat.format(Calc.calculateTotal(amount, percent)));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) { }
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) { }
    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_amount = findViewById(R.id.et_amount);
        sb_percent = findViewById(R.id.sb_percent);
        tv_percent = findViewById(R.id.tv_percent);
        tv_tip = findViewById(R.id.tv_tip);
        tv_total = findViewById(R.id.tv_total);
        et_amount.addTextChangedListener(amountTextWatcher);
        sb_percent.setOnSeekBarChangeListener(sbListener);


        tv_tip.setText("0.0");
        tv_total.setText("0.0");

    }


}
