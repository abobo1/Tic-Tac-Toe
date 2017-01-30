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
            for (int w=0;w<3;w++)
            {
                 if (Board[h][0] == Board[h][1] && Board[h][1] == Board[h][2])
            {
                    myMark = Board[h][0];
            }
            else if (Board[0][h] == Board[1][h] && Board[1][h] == Board[2][h])
            {
                 myMark = Board[0][h];
                
            }
            
           else if (  Board[0][0] == Board[1][1] && Board[1][1] == Board[2][2])
            {
                myMark = Board[0][0];
            }
            else if( Board[0][2] == Board[1][1] && Board[1][1] == Board[2][0])
            {
               myMark = Board[0][2];
            }
            }
            
            
           
        }
        
        return myMark;
        
        
    }
    
    

    public char isEmpty()
    {
        char empt = 'E'; 
        for (int h=0;h<3;h++)
            for (int w=0;w<3;w++)
            {
                if (Board[h][w] != 'E')
                    empt = Board[h][w];
            }
            return empt;
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