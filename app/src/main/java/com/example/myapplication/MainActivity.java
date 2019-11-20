package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    int buffer;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op = '1';
        buffer = 0;
        txt = findViewById(R.id.txt);
        Button ans = findViewById(R.id.equal);

        ans.setOnClickListener(view -> {
            switch (op){
                case '+':
                    buffer += Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '-':
                    buffer -= Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '*':
                    buffer *= Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '/':
                    buffer /= Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
            }
        });
        Log.d("My label", "onCreate invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("My label", "onPause invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("My label", "onDestroy invoked");
    }

    public void ops(View view) {
        buffer = Integer.parseInt(txt.getText().toString());
        Button b = (Button) view;
        op = b.getText().charAt(0);
        txt.setText("");
        Log.d("ops", buffer + " " + op);
    }

    public void appendText(View view){
        Button b = (Button) view;
        txt.setText(txt.getText().toString() + b.getText().toString());
    }
}
