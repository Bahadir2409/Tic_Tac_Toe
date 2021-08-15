package com.layercontent.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameDisplay extends AppCompatActivity {
private TicTacToeBoard ticTacToeBoard;
private TextView playerTurn;
private Button playAgainBTN,homeBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);
     String []playerNames=getIntent().getStringArrayExtra("PLAYER_NAMES");

         playAgainBTN=findViewById(R.id.play_again);
         homeBTN=findViewById(R.id.home_button);
         playerTurn=findViewById(R.id.player_display);
        ticTacToeBoard=findViewById(R.id.ticTacToeBoard);

        ticTacToeBoard.setupgame(playAgainBTN,homeBTN,playerTurn,playerNames);
        if (playerNames!=null){
            playerTurn.setText((playerNames[0]+"'s Turn"));
        }
        playAgainBTN.setVisibility(View.GONE);
        homeBTN.setVisibility(View.GONE);
    }
    public void playAgainButton(View view){
        //do fancy stıff
        ticTacToeBoard.reserGame();
        ticTacToeBoard.invalidate();

    }
    public void homeButtonClick(View view){
        startActivity(new Intent(GameDisplay.this,MainActivity.class));
        finish();
    }
}