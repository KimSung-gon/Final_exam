package com.example.kimsunggon.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by KimSunggon on 2015-12-17.
 */
public class resultActivity extends AppCompatActivity {

    Button bt_return;
    Intent intent2;
    Intent intent3;
    TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        showResult = (TextView) findViewById(R.id.textView);
        intent2 = this.getIntent();
        showResult.setText(intent2.getStringExtra("name"));

        bt_return = (Button) findViewById(R.id.bt_back);
        intent3 = new Intent(this, MainActivity.class);

        bt_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent3);
            }
        });
    }
}