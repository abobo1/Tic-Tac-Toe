package edu.jsu.mcis;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TicTacToeGameBoard extends JPanel implements ActionListener {
    TicTacToeModel model;
    JFrame theframe;
    JButton[][] cutebuttons;
    JPanel thepanel,playerPanel,resetPanel;
    JLabel nextPlayer;
    JButton resetGame;
    
    private char[][] Board;
    public TicTacToeGameBoard(TicTacToeModel themodel){
                this.model=themodel;
                newGame();
                
        
    
}
    public void newGame()
    {
        resetGame = new JButton("Reset");
        resetGame.addActionListener(this);
        resetGame.setLocation(500,0);
        
        thepanel = new JPanel();
        thepanel.setSize(new Dimension(400,400));
        thepanel.setLayout(new GridLayout(3,3));
        thepanel.setLocation(40,20);
        cutebuttons = new JButton[3][3];
        
        playerPanel = new JPanel();
        playerPanel.setSize(new Dimension(100,36));
        playerPanel.setLocation(32,430);
        nextPlayer = new JLabel();
        nextPlayer.setText("Current turn: X");
        playerPanel.add(nextPlayer);
        resetPanel = new JPanel();
        resetPanel.add(resetGame);
        resetPanel.setLocation(350,430);
        resetPanel.setSize(100,32);
                
        
        theframe = new JFrame();
        
        
        theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theframe.setLayout(null);
        
       
        theframe.setSize(new Dimension(500,500));
        theframe.setResizable(false);
        
        
        for (int row = 0; row<3;row++){
            for( int col = 0; col<3;col++){
                cutebuttons[row][col]= new JButton();
                cutebuttons[row][col].setSize(new Dimension(150,150));
                
                cutebuttons[row][col].setText(row+","+col);
                cutebuttons[row][col].setLocation(row,col);
                cutebuttons[row][col].addActionListener(this);
                 
                
                thepanel.add(cutebuttons[row][col]);
                
            }
        }
        theframe.add(thepanel);
        theframe.add(playerPanel);
        theframe.add(resetPanel);
        theframe.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (!ae.getActionCommand().equals("Reset"))
        {
            model.setMarker(Integer.parseInt(ae.getActionCommand().split(",")[0]),Integer.parseInt(ae.getActionCommand().split(",")[1]));
        char mark = model.getMarker(Integer.parseInt(ae.getActionCommand().split(",")[0]),Integer.parseInt(ae.getActionCommand().split(",")[1]));
        if (mark == 'X')
        {
            cutebuttons[Integer.parseInt(ae.getActionCommand().split(",")[0])][Integer.parseInt(ae.getActionCommand().split(",")[1])].setText("X");
            nextPlayer.setText("Curent turn: O");
            findWinner();
        }
        
        else if (mark == 'O')
        {
            cutebuttons[Integer.parseInt(ae.getActionCommand().split(",")[0])][Integer.parseInt(ae.getActionCommand().split(",")[1])].setText("O");
            nextPlayer.setText("Curent turn: X");
            findWinner();
        }
        
      

        
       
        
    }  
     else if (ae.getActionCommand().equals("Reset"))
        {
            theframe.setVisible(false);
            newGame();
        }
}
      //checkfor the win here
         public void findWinner(){
             char winner = model.findWinner();
             String winningMessage = winner + " Won";
            if (winner != 'E' && winner != 'T')
                JOptionPane.showMessageDialog(this, winner);
             else if (winner == 'T')
             {
                 winningMessage = "It's a tie!";
                 JOptionPane.showMessageDialog(this, winner);
             }
                 
        }
     
         
           
      
        }