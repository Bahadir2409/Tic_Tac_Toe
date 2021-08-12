package com.layercontent.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class PlayerSetup extends AppCompatActivity {
EditText play1,play2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);
        play1=findViewById(R.id.editTextTextPersonName);
        play2=findViewById(R.id.editTextTextPersonName2);

    }
    public void submitButttonClik(View view){
        String player1Nmae=play1.getText().toString().trim();
        String player2Nmae=play2.getText().toString().trim();
        Intent intent=new Intent(this,GameDisplay.class);
        intent.putExtra("PLAYER_NAMES",new String[]{player1Nmae,player2Nmae});
        startActivity(intent);

    }
}