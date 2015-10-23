// Starter Template 
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class avg extends JFrame implements ActionListener{ 
  //Variable and GUIObject Declaration area 
  
  JPanel Panel1= new JPanel() ;

  JButton [] br ;
  JButton [] bb ;
  JLabel [] lt ;
  JLabel [] lb ;
  JLabel [] lbb;
  JLabel [] lr ;
  JLabel [] ll ;
  JTextField [] t ;

  //---Counters---//
  int clr = 0 ;
  int cbr = 0 ;
  int ct = 0 ;
  int cll = 0;
  
  //---Doubles---//
  double avg = 0.0;


  public static void main(String[ ] args) 
  {
    new avg();
  }  

  public avg (){
    //Create object and your code goes here 
    lt = new JLabel [6] ;
    lb = new JLabel [5] ;
    lbb = new JLabel [2] ;
    lr = new JLabel [3] ;
    ll = new JLabel [3] ;
    t = new JTextField [9] ;
    br = new JButton [4] ;
    bb = new JButton [4] ;

    Panel1.setLayout(new GridLayout (6,6)) ;
    
    this.add(Panel1) ;
   
//---Array_Set---//

//---Row_1---//
    for (int i=0;i<6;i++)
    {
      lt[i]=new JLabel("test");
      Panel1.add(lt[i]);
    }
    lt[0].setText("");
    lt[1].setText("Math");
    lt[2].setText("Sci");
    lt[3].setText("Eng");
    lt[4].setText("Avg");
    lt[5].setText("");
//---Row_2-4---//
    for (int i=0;i<18;i++)
    {
      lr[clr]=new JLabel("test");
      Panel1.add(lr[clr]);
      clr++;
      i++;
      for (int j=0;j<3;j++)
      {
        t[ct]=new JTextField(""+(int)(100*Math.random()+1));
        Panel1.add(t[ct]);
        ct++;
        i++;
      }
      ll[cll]=new JLabel("");
      Panel1.add(ll[cll]);
      cll ++;
      i++;
      br[cbr]=new JButton("Calc");
      Panel1.add(br[cbr]);
      br[cbr].addActionListener(this);
      cbr++;
    }
    
    lr[0].setText("Bob");
    lr[1].setText("Sally");
    lr[2].setText("Mark");
//---Row_5---//
    for (int i=0;i<5;i++)
    {
      lb[i]=new JLabel("");
      Panel1.add(lb[i]);
    }
    br[3]=new JButton("Calc");
    Panel1.add(br[3]);
    br[3].addActionListener(this);
    
    lb[0].setText("Avg");
//---Row_6---//

    lbb[0]=new JLabel("");
    Panel1.add(lbb[0]);
    
    for (int i=0;i<4;i++)
    {
      bb[i]=new JButton("Calc");
      Panel1.add(bb[i]);
      bb[i].addActionListener(this);
    }
    
    lbb[1]=new JLabel("");
    Panel1.add(lbb[1]);
    
    this.setSize(390,200) ;
    this.setVisible(true) ;
  }
  
  public void actionPerformed (ActionEvent e) {
    avg = 0.0;
    if (e.getSource()==br[3] || e.getSource()==bb[3])
    {
      for (int i=0;i<9;i++)
      {
        avg = avg + Double.parseDouble(t[i].getText());
      }
      avg = avg/9.0;
      lb[4].setText("" + avg);
    }
    else
    {
      for (int i=0;i<3;i++)
      {
        if (e.getSource()==br[i])
        {
          ll[i].setText(""+((Double.parseDouble(t[i*3].getText()) + Double.parseDouble(t[i*3+1].getText()) + Double.parseDouble(t[i*3+2].getText()))/3.0));
        }
        else if (e.getSource()==bb[i])
        {
          lb[i+1].setText(""+((Double.parseDouble(t[i].getText()) + Double.parseDouble(t[i+3].getText()) + Double.parseDouble(t[i+6].getText()))/3.0));
        }
      }
    }
  }  
}



