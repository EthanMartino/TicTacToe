package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Button currBtn = (Button) view;
        TextView textView = findViewById(R.id.textView);
        if(textView.getText() == "Player X's Turn"){
            currBtn.setText("X");
            textView.setText("Player O's Turn");
        }
        else{
            currBtn.setText("O");
            textView.setText("Player X's Turn");
        }
    }
}
