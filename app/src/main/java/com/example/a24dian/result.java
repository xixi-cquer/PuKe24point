package com.example.a24dian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class result extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        TextView msgText = findViewById(R.id.result_text);
        String msg =getIntent().getStringExtra("result");
        msgText.setText(msg);

        Button backButton = findViewById(R.id.cx);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 点击按钮返回原来的页面
                finish();
            }
        });
    }



}
