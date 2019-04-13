package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private final static float USDRate = 30.9f;
    private EditText editNTD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        editNTD = findViewById(R.id.ntd);
    }

    public void calculate(View view) {
        String strNTD = editNTD.getText().toString();

        if ("".equals(strNTD)) {
            new AlertDialog.Builder(this).setTitle("Problem").setMessage("Please enter your NTD amount").
                    setPositiveButton("OK", null).show();

        } else {
            float floatNTD = Float.valueOf(strNTD);
            float result = floatNTD / USDRate;
            Log.d(TAG, "USD is " + result);
            new AlertDialog.Builder(this).setTitle("Result").setMessage("USD is " + result).
                    setPositiveButton("OK", null).show();

        }
    }

}
