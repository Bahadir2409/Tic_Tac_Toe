package com.layercontent.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_display);
    }
    public void playAgainButton(View view){
        //do fancy stıff
    }
    public void homeButtonClick(View view){
        startActivity(new Intent(GameDisplay.this,MainActivity.class));
        finish();
    }
}