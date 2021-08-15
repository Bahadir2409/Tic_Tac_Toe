package com.layercontent.tic_tac_toe;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameLogic {

    private int [][] gameBoard;

    private Button playAgainBTN;
    private Button homeBtn;
   private TextView playerTurn;
   private String[] playerNames={"Player1","Player2"};

   //1st element -->row, 2nd element --> col ,3nd element --> Line type
private int []winType={-1,-1,-1};

    private int player=1;
    GameLogic(){
        gameBoard=new int[3][3];
        for (int r=0; r<3;r++){
            for (int c=0;c<3;c++){
                gameBoard [r][c]=0;
            }
        }
    }
public boolean updateGameBoard(int row,int col){
        if (gameBoard[row-1][col-1]==0){
            gameBoard[row-1][col-1]=player;
            if (player==1){
                playerTurn.setText((playerNames[1]+"'s Turn"));
            }
            else{
                playerTurn.setText((playerNames[0]+"'s Turn"));
            }
            return true;
        }
        else {
            return false;
        }

}


    public void setGameBoard(int[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setPlayAgainBTN(Button playAgainBTN) {
        this.playAgainBTN = playAgainBTN;
    }

    public void setHomeBtn(Button homeBtn) {
        this.homeBtn = homeBtn;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }
    public void setPlayerNames(String[] playerNames) {
        this.playerNames = playerNames;
    }
public boolean winnerCheck(){

        boolean isWinner=false;

        //horizantaş checl  (win type=1)
        for (int r=0;r<3;r++){
            if (gameBoard[r][0]==gameBoard[r][1]&& gameBoard[r][0]==gameBoard[r][2]&& gameBoard[r][0]!=0){
                winType=new int[]{r,0,1};
               isWinner=true;
            }
        }
        //Vertical Check (win type=2)
    for (int c=0;c<3;c++){
        if (gameBoard[c][0]==gameBoard[c][1]&& gameBoard[c][0]==gameBoard[c][2]&& gameBoard[c][0]!=0){
            winType=new int[]{0,c,2};
            isWinner=true;
        }
    }

    //Negative diagonal check() (win type=3)
    if (gameBoard[0][0]==gameBoard[1][1]&& gameBoard[0][0]==gameBoard[2][2]&& gameBoard[0][0]!=0){
        winType=new int[]{0,2,3};
        isWinner=true;
    }
    //positive diagonal check() (win type=4)
    if (gameBoard[2][0]==gameBoard[1][1]&& gameBoard[2][0]==gameBoard[0][2]&& gameBoard[2][0]!=0){
        winType=new int[]{2,2,4};
        isWinner=true;
    }
    int boardFiled=0;
    for (int r=0; r<3;r++){
        for (int c=0;c<3;c++){
            if (gameBoard[r][c]!=0){
                boardFiled+=1;
            }
        }
    }

    if (isWinner){
        playAgainBTN.setVisibility(View.VISIBLE);
        homeBtn.setVisibility(View.VISIBLE);
        playerTurn.setText(playerNames[player-1]+ " Won!!!!!");
        return true;

    }
    else if (boardFiled==9){
        playAgainBTN.setVisibility(View.VISIBLE);
        homeBtn.setVisibility(View.VISIBLE);
        playerTurn.setText("Tie Game!!!");
        return true;
    }
    else{
        return false;
    }

}
    public void resetGame(){
    for (int r=0; r<3;r++){
        for (int c=0;c<3;c++){
            gameBoard [r][c]=0;
        }
    }
    player=1;
    playAgainBTN.setVisibility(View.GONE);
        homeBtn.setVisibility(View.GONE);
        playerTurn.setText((playerNames[0]+ "s Turn"));
}
    public int[][] getGameBoard() {
        return gameBoard;
    }
    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public int[] getWinType() {
        return winType;
    }
}
