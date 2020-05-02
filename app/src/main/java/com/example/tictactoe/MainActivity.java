package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button topLeftBtn;
    private Button middleLeftBtn;
    private Button bottomLeftBtn;
    private Button topMiddleBtn;
    private Button middleMiddleBtn;
    private Button bottomMiddleBtn;
    private Button topRightBtn;
    private Button middleRightBtn;
    private Button bottomRightBtn;
    private TextView playersTurnTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeButtons();
    }

    public void onClick(View view){
        Button currBtn = (Button) view;
        if(!isClicked(currBtn)){
            if(playersTurnTextView.getText().equals("Player X's Turn")){
                currBtn.setText(R.string.x);
                playersTurnTextView.setText(R.string.player_o_s_turn);
            }
            else{
                currBtn.setText(R.string.o);
                playersTurnTextView.setText(R.string.player_x_s_turn);
            }
        }
        if(isWinner("X") || isWinner("O") || areAllClicked()){
            String winner = determineWinner();
            displayDialog(winner);
            enableOrDisableButtons(false);
        }
    }

    public void onNewGameClick(View view){
        topLeftBtn.setText("");
        middleLeftBtn.setText("");
        bottomLeftBtn.setText("");
        topMiddleBtn.setText("");
        middleMiddleBtn.setText("");
        bottomMiddleBtn.setText("");
        topRightBtn.setText("");
        middleRightBtn.setText("");
        bottomRightBtn.setText("");
        playersTurnTextView.setText(R.string.player_x_s_turn);
        enableOrDisableButtons(true);
    }

    private void initializeButtons(){
        playersTurnTextView = findViewById(R.id.playersTurnTextView);
        topLeftBtn = findViewById(R.id.topLeftBtn);
        middleLeftBtn = findViewById(R.id.middleLeftBtn);
        bottomLeftBtn = findViewById(R.id.bottomLeftBtn);
        topMiddleBtn = findViewById(R.id.topMiddleBtn);
        middleMiddleBtn = findViewById(R.id.middleMiddleBtn);
        bottomMiddleBtn = findViewById(R.id.bottomMiddleBtn);
        topRightBtn = findViewById(R.id.topRightBtn);
        middleRightBtn = findViewById(R.id.middleRightBtn);
        bottomRightBtn = findViewById(R.id.bottomRightBtn);
    }

    private boolean isClicked(Button thisButton){
        return thisButton.getText().equals("X") || thisButton.getText().equals("O");
    }

    private boolean areAllClicked(){
        return isClicked(topLeftBtn) && isClicked(middleLeftBtn) && isClicked(bottomLeftBtn) &&
                isClicked(topMiddleBtn) && isClicked(middleMiddleBtn) && isClicked(bottomMiddleBtn) &&
                isClicked(topRightBtn) && isClicked(middleRightBtn) && isClicked(bottomRightBtn);
    }

    private String determineWinner(){
        if(isWinner("X")){
            return getString(R.string.x_is_winner);
        }
        else if(isWinner("O")){
            return getString(R.string.o_is_winner);
        }
        else {
            return getString(R.string.tie_game);
        }
    }

    private boolean isWinner(String player){
        return topLeftBtn.getText().equals(player) && middleLeftBtn.getText().equals(player) && bottomLeftBtn.getText().equals(player) ||
                topMiddleBtn.getText().equals(player) && middleMiddleBtn.getText().equals(player) && bottomMiddleBtn.getText().equals(player) ||
                topRightBtn.getText().equals(player) && middleRightBtn.getText().equals(player) && bottomRightBtn.getText().equals(player) ||
                topLeftBtn.getText().equals(player) && middleMiddleBtn.getText().equals(player) && bottomRightBtn.getText().equals(player) ||
                topRightBtn.getText().equals(player) && middleMiddleBtn.getText().equals(player) && bottomLeftBtn.getText().equals(player);
    }

    private void enableOrDisableButtons(boolean value){
        topLeftBtn.setClickable(value);
        middleLeftBtn.setClickable(value);
        bottomLeftBtn.setClickable(value);
        topMiddleBtn.setClickable(value);
        middleMiddleBtn.setClickable(value);
        bottomMiddleBtn.setClickable(value);
        topRightBtn.setClickable(value);
        middleRightBtn.setClickable(value);
        bottomRightBtn.setClickable(value);
    }

    private void displayDialog(String winnerMessage){
        new AlertDialog.Builder(this)
                .setTitle(R.string.game_over)
                .setMessage(winnerMessage)

                .setPositiveButton(android.R.string.yes, null)
                .show();
    }
}
