import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class tictacwin10 extends JFrame implements ActionListener{
  //---Var---//
  
  int t1 = 0 ;
  int t2 = 0 ;
  int t3 = 0 ;
  int t4 = 0 ;
  int t5 = 0 ;
  int t6 = 0 ;
  int t7 = 0 ;
  int t8 = 0 ;
  int t9 = 0 ;
  int turn = 0 ;
  int tie = 0 ;
  int win = 0 ;
  Font font = new Font("consolas", 32);
  
  
  //---JPVar---//
  
  
  JPanel Panel1= new JPanel() ;
  JLabel l1 = new JLabel ("   Player 1") ;
  JLabel l2 = new JLabel ("     Welcome to tic tac toe.") ;
  JButton b1 = new JButton ("1") ;
  JButton b2 = new JButton ("2") ;
  JButton b3 = new JButton ("3") ;
  JButton b4 = new JButton ("4") ;
  JButton b5 = new JButton ("5") ;
  JButton b6 = new JButton ("6") ;
  JButton b7 = new JButton ("7") ;
  JButton b8 = new JButton ("8") ;
  JButton b9 = new JButton ("9") ;
  JButton combo[] = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b1,b4,b7,b2,b5,b8,b3,b6,b9,b7,b5,b3,b1,b5,b9} ;
  
  public static void main(String[ ] args) 
  {
    new tictacwin10();
  }  
  
  public tictacwin10 (){
    
    Panel1.setLayout(new GridLayout(4,3)) ;
    
    
    Panel1.add(b1) ;
    Panel1.add(b2) ;
    Panel1.add(b3) ;
    Panel1.add(b4) ;
    Panel1.add(b5) ;
    Panel1.add(b6) ;
    Panel1.add(b7) ;
    Panel1.add(b8) ;
    Panel1.add(b9) ;
    Panel1.add(l1) ;
    Panel1.add(l2) ;
    
    this.add(Panel1) ;
    this.setSize(500,500) ;
    this.setVisible(true) ;
    this.setResizable(false) ;
    this.setTitle("Game") ;
    
    b1.addActionListener(this) ;
    b2.addActionListener(this) ;
    b3.addActionListener(this) ;
    b4.addActionListener(this) ;
    b5.addActionListener(this) ;
    b6.addActionListener(this) ;
    b7.addActionListener(this) ;
    b8.addActionListener(this) ;
    b9.addActionListener(this) ;
    label1.setIcon(new ImageIcon("b.jpg"));

    for (int i = 0; i<9;i++)
    {
      combo[i].setFont(font) ;
    }
    
  }
  
  public void actionPerformed (ActionEvent e) {
    if (e.getSource()==b1) {
      
      if (t1 == 0 && turn == 0) {
        b1.setText ("X") ;b1.setBackground(Color.black) ;
        turn = 1 ;
        t1 = 1 ;
        b1.setEnabled(false) ;
      }
      else if (t1 == 0 && turn == 1) {
        b1.setText ("O") ; b1.setBackground(Color.white) ; 
        turn = 0 ;
        t1 = 1 ;
        b1.setEnabled(false) ;
      }
    }
    if (e.getSource()==b2) {
      
      if (t2 == 0 && turn == 0) {
        b2.setText ("X") ;b2.setBackground(Color.black) ;
        turn = 1 ;
        t2 = 1 ;
        b2.setEnabled(false) ;
      }
      else if (t2 == 0 && turn == 1) {
        b2.setText ("O") ; b2.setBackground(Color.white) ; 
        turn = 0 ;
        t2 = 1 ;
        b2.setEnabled(false) ;
      }
    }
    if (e.getSource()==b3) {
      
      if (t3 == 0 && turn == 0) {
        b3.setText ("X") ;b3.setBackground(Color.black) ;
        turn = 1 ;
        t3 = 1 ;
        b3.setEnabled(false) ;
      }
      else if (t3 == 0 && turn == 1) {
        b3.setText ("O") ; b3.setBackground(Color.white) ; 
        turn = 0 ;
        t3 = 1 ;
        b3.setEnabled(false) ;
      }
    }
    if (e.getSource()==b4) {
      
      if (t4 == 0 && turn == 0) {
        b4.setText ("X") ;b4.setBackground(Color.black) ;
        turn = 1 ;
        t4 = 1 ;
        b4.setEnabled(false) ;
      }
      else if (t4 == 0 && turn == 1) {
        b4.setText ("O") ; b4.setBackground(Color.white) ; 
        turn = 0 ;
        t4 = 1 ;
        b4.setEnabled(false) ;
      }
    }
    if (e.getSource()==b5) {
      
      if (t5 == 0 && turn == 0) {
        b5.setText ("X") ;b5.setBackground(Color.black) ;
        turn = 1 ;
        t5 = 1 ;
        b5.setEnabled(false) ;
      }
      else if (t5 == 0 && turn == 1) {
        b5.setText ("O") ; b5.setBackground(Color.white) ; 
        turn = 0 ;
        t5 = 1 ;
        b5.setEnabled(false) ;
      }
    }
    if (e.getSource()==b6) {
      
      if (t6 == 0 && turn == 0) {
        b6.setText ("X") ;b6.setBackground(Color.black) ;
        turn = 1 ;
        t6 = 1 ;
        b6.setEnabled(false) ;
      }
      else if (t6 == 0 && turn == 1) {
        b6.setText ("O") ; b6.setBackground(Color.white) ; 
        turn = 0 ;
        t6 = 1 ;
        b6.setEnabled(false) ;
      }
    }
    if (e.getSource()==b7) {
      
      if (t7 == 0 && turn == 0) {
        b7.setText ("X") ;b7.setBackground(Color.black) ;
        turn = 1 ;
        t7 = 1 ;
        b7.setEnabled(false) ;
      }
      else if (t7 == 0 && turn == 1) {
        b7.setText ("O") ; b7.setBackground(Color.white) ; 
        turn = 0 ;
        t7 = 1 ;
        b7.setEnabled(false) ;
      }
    }
    if (e.getSource()==b8) {
      
      if (t8 == 0 && turn == 0) {
        b8.setText ("X") ;b8.setBackground(Color.black) ;
        turn = 1 ;
        t8 = 1 ;
        b8.setEnabled(false) ;
      }
      else if (t8 == 0 && turn == 1) {
        b8.setText ("O") ; b8.setBackground(Color.white) ; 
        turn = 0 ;
        t8 = 1 ;
        b8.setEnabled(false) ;
      }
    }
    if (e.getSource()==b9) {
      
      if (t9 == 0 && turn == 0) {
        b9.setText ("X") ;b9.setBackground(Color.black) ;
        turn = 1 ;
        t9 = 1 ;
        b9.setEnabled(false) ;
      }
      else if (t9 == 0 && turn == 1) {
        b9.setText ("O") ; b9.setBackground(Color.white) ; 
        turn = 0 ;
        t9 = 1 ;
        b9.setEnabled(false) ;
      }
      
      
    }
    wincheck () ;
    tie = tie + 1 ;
  }
  
  public void wincheck()
  {
    if (turn == 1)
    {
      l1.setText("   Player 1") ;
    }
    else if (turn == 00)
    {
      l1.setText("   Player 2") ;
    }
    
    for(int i=0; i<21; i+=3){
      if(combo[i].getText().equals(combo[i+1].getText())&&combo[i+1].getText().equals(combo[i+2].getText())){
        
        win= 1 ;
      }
    }
    if (win == 1) 
    {
      if (turn==0)
      {
        turn = 2 ; 
      }
      l2.setText("Player " + turn + " Wins!") ;
    }  
    if (tie == 8)
    {
      l2.setText("Tie Game.") ;
    }      
  }
}

