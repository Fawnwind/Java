// Starter Template 
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class hangman extends JFrame implements ActionListener{ 
  //Variable and GUIObject Declaration area 
  
  JPanel phrase     = new JPanel();
  JPanel guess      = new JPanel();
  MyDrawPanel man   = new MyDrawPanel();
  
  JButton [] guessb = new JButton [26];
  JLabel [] blank   = new JLabel [26];
  JLabel [] phrasel = new JLabel [26];
  
  String [] answers = {"UNITED STATES OF AMERICA","REPUBLIC OF  NORTH KOREA","SOVIET UNION"};
  String current    = "";
  String charc      = "";
  
  
  int anum     = (int)(3*Math.random()); 
  int alen     = 0;
  int tnum     = 0;
  int waste    = 0;
  int wincount = 0;
  
  String winnospace = answers[anum].replace(" ","");
  int winnum = winnospace.length();
  
  
  public static void main(String[ ] args) 
  {
    new hangman();
  }  
  
  public hangman (){
    //Create object and your code goes here
    System.out.println(""+winnum);
    guess.setLayout(new GridLayout(4,7));
    phrase.setLayout(new GridLayout(4,13));
    this.setLayout(new GridLayout(1,3));
    
    
    this.add(phrase);
    this.add(man);
    this.add(guess);
    
    for (int i=0;i<26;i++)
    {
      guessb[i] = new JButton(""+(char)(i+65));
      guess.add(guessb[i]);
      guessb[i].addActionListener(this);
    }
    
    for (int i=0;i<26;i++)
    {
      phrasel[i]= new JLabel("",JLabel.CENTER);
      phrasel[i].setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
      phrase.add(phrasel[i]);
    }
    
    for (int i=0;i<26;i++)
    {
      blank[i]= new JLabel("",JLabel.CENTER);
      phrase.add(blank[i]); 
    }
    
    this.setSize(1050,300);
    this.setVisible(true);
    this.setResizable(false);
    
    current = answers [anum];
    alen = current.length();
    System.out.println(current);
    System.out.println(alen);
    
    
  } 
  
  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D)g;
      g2.drawOval(150,50,10,10);
      //Graphics commands go HERE
      if (tnum == 1)
      {
        g2.drawLine(155,60,155,80);
      }
      else if (tnum == 2)
      {
        g2.drawLine(155,60,155,80);

        g2.drawLine(155,80,150,90);
      }
      else if (tnum == 3)
      {
        g2.drawLine(155,60,155,80);

        g2.drawLine(155,80,150,90);

        g2.drawLine(155,80,160,90);
      }
      else if (tnum == 4)
      {
        g2.drawLine(155,60,155,80);

        g2.drawLine(155,80,150,90);

        g2.drawLine(155,80,160,90);

        g2.drawLine(155,70,150,65);
      }
      else if (tnum == 5)
      {
        g2.drawLine(155,60,155,80);

        g2.drawLine(155,80,150,90);

        g2.drawLine(155,80,160,90);

        g2.drawLine(155,70,150,65);

        g2.drawLine(155,70,160,65);
      }
      else if (tnum == 6)
      {
        System.out.println("waste man");
        JOptionPane.showMessageDialog(null,"You lose and are a waste man, go reevaluate your life choices.","You lost yea hi",JOptionPane.ERROR_MESSAGE);
        tnum = 1000;
        System.exit(0);
      }
    }
  }
  
  public void actionPerformed(ActionEvent e)
  {
    waste = 1;
    for (int i=0;i<26;i++)
    {
      if (e.getSource()==guessb[i])
      {
        for (int x=0;x<alen;x++)
        {
          charc = "" + current.charAt(x);
          if (guessb[i].getText().equals(charc))
          {
            System.out.println("good");
            phrasel[x].setText(charc);
            guessb[i].setEnabled(false);
            waste = 0;
            wincount = wincount+1;
            System.out.println(""+wincount);
          }
          else
          {
            
            guessb[i].setEnabled(false);
          }
        }
        if (waste == 1)
        {
          System.out.println("waste");
          tnum=tnum+1;
          repaint();
        }
        if (winnum == wincount)
        {
          JOptionPane.showMessageDialog(null,"You win and are not waste man, don't reevaluate your life choices.","You won yea hi",JOptionPane.PLAIN_MESSAGE);
          System.exit(0);
        }
      }  
    }
  }
}




