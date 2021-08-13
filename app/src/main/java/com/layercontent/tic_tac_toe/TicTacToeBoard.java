package com.layercontent.tic_tac_toe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class TicTacToeBoard extends View {
    private final int boardColor;
    private final int xColor;
    private final int OColor;
    private final int winningLineColor;
    private final Paint paint = new Paint();
    private int cellSize = getWidth() / 3;
    private  GameLogic game=new GameLogic();

    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.getTheme().obtainStyledAttributes
                (attrs, R.styleable.TicTacToeBoard, 0, 0);
        try {
            boardColor = array.getInteger(R.styleable.TicTacToeBoard_boardColor, 0);
            xColor = array.getInteger(R.styleable.TicTacToeBoard_Xcolor, 0);
            OColor = array.getInteger(R.styleable.TicTacToeBoard_Ocolor, 0);
            winningLineColor = array.getInteger(R.styleable.TicTacToeBoard_winningLineColor, 0);
        } finally {
            array.recycle();
        }

    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        int dimensions = Math.min(getMeasuredWidth(), getMeasuredHeight());
        cellSize = dimensions / 3;
        setMeasuredDimension(dimensions, dimensions);

    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        drawGameBoard(canvas);

       drawMarkers(canvas);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
         float x=event.getX();
         float y=event.getY();

         int action=event.getAction();
         if (action==MotionEvent.ACTION_DOWN){
             int row=(int) Math.ceil(y/cellSize);
             int col=(int) Math.ceil(x/cellSize);

             if (game.updateGameBoard(row,col)){
                 invalidate();

                 if (game.getPlayer()%2==0){
                     game.setPlayer(game.getPlayer()-1);
                 }
             }

             invalidate();
             return true;
         }
      return false;
    }
@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
private void drawMarkers(Canvas canvas){

    for (int r=0; r<3;r++){
        for (int c=0;c<3;c++){
            if (game.getGameBoard()[r][c]!=0){
                if (game.getGameBoard()[r][c]==1){
                    drawX(canvas,r,c);
                }else {
                    drawO(canvas,r,c);
                }
            }
        }
    }
}
    private void drawGameBoard(Canvas canvas) {
        paint.setColor(boardColor);
        paint.setStrokeWidth(16);
        for (int c = 1; c < 3; c++) {
            canvas.drawLine(cellSize * c, 0, cellSize * c, canvas.getWidth(), paint);
        }
        for (int r = 1; r < 3; r++) {
            canvas.drawLine(0, cellSize * r, canvas.getWidth(), cellSize * r, paint);
        }
    }

    private void drawX(Canvas canvas, int row, int col) {
        paint.setColor(xColor);
        canvas.drawLine((float) ((col + 1) * cellSize - cellSize * 0.2)
                , (float) (row * cellSize + cellSize * 0.2)
                , (float) (col * cellSize + cellSize * 0.2)
                , (float) ((row + 1) * cellSize - cellSize * 0.2)
                , paint);
        canvas.drawLine((float) (col * cellSize + cellSize * 0.2)
                , (float) (row * cellSize + cellSize * 0.2)
                , (float) ((col + 1) * cellSize - cellSize * 0.2)
                , (float) ((row + 1) * cellSize - cellSize * 0.2)
                , paint);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void drawO(Canvas canvas, int row, int col) {
        paint.setColor(OColor);
        canvas.drawOval((float) (col * cellSize + cellSize * 0.2)
                , (float) (row * cellSize + cellSize * 0.2)
                , (float) ((col * cellSize + cellSize) - cellSize * 0.2)
                , (float) ((row * cellSize + cellSize) - cellSize * 0.2)
                , paint);

    }
}
