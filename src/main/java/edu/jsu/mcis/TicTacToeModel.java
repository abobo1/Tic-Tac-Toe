package edu.jsu.mcis;

public class TicTacToeModel {
    private char[][] Board;
    private boolean xTurn;

    public TicTacToeModel()
    {
        initGame();
    }
    public void initGame()
    {
        Board = new char[3][3];
        for (int h=0;h<3;h++)
            for (int w=0;w<3;w++)
            {
                Board[h][w] = 'E';
            }
            xTurn = true;
    }

    public char findWinner()
    {
        char myMark = 'E';
        for (int h=0;h<3;h++)
        {
            if (Board[h][0] == Board[h][1] && Board[h][1] == Board[h][2] ||
            Board[0][h] == Board[1][h] && Board[1][h] == Board[2][h])
           
            {
                myMark = Board[h][h];
            }

        }
        return myMark;
    }

    public boolean isEmpty()
    {
        for (int h=0;h<3;h++)
            for (int w=0;w<3;w++)
            {
                if (Board[h][w] != 'E')
                    return false;
            }
            return true;
    }

    public void setMarker (int h, int w)
    {
        if (Board[h][w] == 'E')
        {
            if (xTurn)
                Board[h][w] = 'X';
            else
                Board[h][w] = 'O';                
        }
        xTurn = !xTurn;
    }

    public char getMarker(int h, int w)
    {
        return Board[h][w];
    }



	
}
