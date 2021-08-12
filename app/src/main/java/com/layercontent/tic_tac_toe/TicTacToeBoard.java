package com.layercontent.tic_tac_toe;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class TicTacToeBoard extends View {
    private final  int boardColor;
    private final  int xColor;
    private final  int OColor;
    private final  int winningLineColor;
    private final Paint paint=new Paint();
    private int cellSize=getWidth()/3;
    public TicTacToeBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray array=context.getTheme().obtainStyledAttributes
                (attrs,R.styleable.TicTacToeBoard,0,0);
        try {
            boardColor=array.getInteger(R.styleable.TicTacToeBoard_boardColor,0);
            xColor=array.getInteger(R.styleable.TicTacToeBoard_Xcolor,0);
            OColor=array.getInteger(R.styleable.TicTacToeBoard_Ocolor,0);
            winningLineColor=array.getInteger(R.styleable.TicTacToeBoard_winningLineColor,0);
        }finally {
            array.recycle();
        }

    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        int dimensions=Math.min(getMeasuredWidth(),getMeasuredHeight());
         cellSize=dimensions/3;
        setMeasuredDimension(dimensions,dimensions);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        drawGameBoard(canvas);

        super.onDraw(canvas);
    }
    private void drawGameBoard(Canvas canvas){
        paint.setColor(boardColor);
        paint.setStrokeWidth(16);
    for (int c=1;c<3;c++){
        canvas.drawLine(cellSize*c,0,cellSize*c,canvas.getWidth(),paint);
    }
        for (int r=1;r<3;r++){
            canvas.drawLine(0,cellSize*r,canvas.getWidth(),cellSize*r,paint);
        }
    }
}
