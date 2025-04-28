Mainactivity.java
package com.vivssecure.family;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MusicPlayer extends AppCompatActivity {

    EditText etNum1, etNum2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player);

        etNum1 = findViewById(R.id.etNum1);
        etNum2 = findViewById(R.id.etNum2);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> calculate('+'));
        btnSub.setOnClickListener(v -> calculate('-'));
        btnMul.setOnClickListener(v -> calculate('*'));
        btnDiv.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        String input1 = etNum1.getText().toString();
        String input2 = etNum2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double num1 = Double.parseDouble(input1);
        double num2 = Double.parseDouble(input2);
        double result = 0;

        switch (operator) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/':
                if (num2 == 0) {
                    tvResult.setText("Error: Division by zero");
                    return;
                } else {
                    result = num1 / num2;
                }
                break;
        }

        tvResult.setText("Result: " + result);
    }
}
Activity.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="24dp"
    android:gravity="center">

    <EditText
        android:id="@+id/etNum1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter first number"
        android:inputType="numberDecimal" />

    <EditText
        android:id="@+id/etNum2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter second number"
        android:inputType="numberDecimal"
        android:layout_marginTop="12dp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="16dp"
        android:gravity="center">

        <Button
            android:id="@+id/btnAdd"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="+" />

        <Button
            android:id="@+id/btnSub"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="-"
            android:layout_marginStart="12dp" />

        <Button
            android:id="@+id/btnMul"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="×"
            android:layout_marginStart="12dp" />

        <Button
            android:id="@+id/btnDiv"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="÷"
            android:layout_marginStart="12dp" />
    </LinearLayout>

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Result:"
        android:textSize="20sp"
        android:layout_marginTop="20dp" />
</LinearLayout>