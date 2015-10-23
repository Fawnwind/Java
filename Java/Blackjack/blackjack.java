import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class blackjack extends JFrame implements ActionListener
{ 

  JPanel main     = new JPanel();
  JPanel dealer   = new JPanel();
  JPanel player   = new JPanel();
  JPanel menu     = new JPanel();
  JPanel instruct = new JPanel();

  JButton hit     = new JButton("Hit");
  JButton stay    = new JButton("Stay");
  JButton bet     = new JButton("Reset");
  JButton fold    = new JButton ("Fold");

  JLabel pcvalue  = new JLabel("Player:");
  JLabel dcvalue  = new JLabel("Dealer:");
  JLabel pwvalue  = new JLabel("Player Wins:");
  JLabel dwvalue  = new JLabel("Dealer Wins:");

  JLabel[] pcards = new JLabel[6];
  JLabel[] dcards = new JLabel[6];

  int[] ucards    = new int[52];
  int[] players   = new int [2];

  int pvalue      = 0;
  int dvalue      = 0;
  int cardpick    = 0;
  int cardworth   = 0;
  int cardnum     = 0;
  int pwins       = 0;
  int dwins       = 0;

  String []dir = {"Clubs","Diamonds","Hearts","Spades"};
  

  public static void main(String[ ] args) 
  {
    new blackjack();
  }  
  
  public blackjack (){

    System.out.println("");

    hit.addActionListener(this);
    stay.addActionListener(this);
    bet.addActionListener(this);
    fold.addActionListener(this);

    main.setLayout(new GridLayout(2,2));
    dealer.setLayout(new GridLayout(1,6));
    player.setLayout(new GridLayout(1,6));
    menu.setLayout(new GridLayout(2,3));
    instruct.setLayout(new GridLayout(2,2));

    dealer.setBackground(new Color(9,94,22));
    player.setBackground(new Color(9,94,22));
    menu.setBackground(new Color(145,123,86));
    instruct.setBackground(new Color(145,123,86));

    hit.setBackground(new Color(145,123,86));
    stay.setBackground(new Color(145,123,86));
    bet.setBackground(new Color(145,123,86));
    fold.setBackground(new Color(145,123,86));

    for (int i=0;i<6;i++)
    {
      pcards[i] = new JLabel("");
      player.add(pcards[i]);
    }

    for (int i=0;i<6;i++)
    {
      dcards[i] = new JLabel("");
      dealer.add(dcards[i]);
    }

    this.add(main);
    main.add(dealer);
    main.add(player);
    main.add(menu);
    main.add(instruct);

    menu.add(hit);
    menu.add(stay);
    menu.add(bet);
    menu.add(fold);

    hit.setBorder(BorderFactory.createLineBorder(Color.black));
    stay.setBorder(BorderFactory.createLineBorder(Color.black));
    bet.setBorder(BorderFactory.createLineBorder(Color.black));
    fold.setBorder(BorderFactory.createLineBorder(Color.black));

    menu.setBorder(BorderFactory.createLineBorder(Color.black));

    instruct.add(pcvalue);
    instruct.add(dcvalue);
    instruct.add(pwvalue);
    instruct.add(dwvalue);
   
    this.setSize(1000,600);
    this.setVisible(true);
  } 
  
  public void actionPerformed(ActionEvent e)
  {

    if (e.getSource()==hit)
    {
      if (cardnum <6)
      {
        int dirp = (int)(Math.random() * (3 - 0));
        int dird = (int)(Math.random() * (3 - 0));
        
        int r[]  = new int[2];
        r[0]     = (int)(Math.random() * (12 - 0)+1);
        r[1]     = (int)(Math.random() * (12 - 0)+1);

        System.out.println("|"+dir[dird]+"("+r[0]+")"+"|--|"+dir[dirp]+"("+r[1]+")"+"|");
        System.out.println("");  

        pcards[cardnum].setIcon(new ImageIcon(dir[dirp] + "/" + r[1] + ".png"));
        dcards[cardnum].setIcon(new ImageIcon(dir[dird] + "/" + r[0]+ ".png"));

        cardnum = cardnum + 1;

        for (int i=0;i<2;i++)
        {
          if(r[i]>9)
          {
            players[i] = players[i] + 10;
          }
          else if (r[i]==1)
          {
            if(players[i]<12)
            {
              players[i] = players[i] + 11; 
            }
            else
            {
              players[i] = players[i] + r[i];
            }
          }
          else
          {
            players[i] = players[i] + r[i];
          }
        }
        System.out.println("|"+players[0]+"|"+players[1]+"|");
        System.out.println("");

        pcvalue.setText("Player: "+players[1]);
        dcvalue.setText("Dealer: "+players[0]);

        wincheck();
        losecheck();

      }
      else
      {
        System.out.println("Player Wins!");
        pwins = pwins + 1;
        pwvalue.setText("Player Wins: "+pwins);

      }
    }
    if (e.getSource()==stay)
    {

      while (players[0]<17)
      {

        int dirs = (int)(Math.random() * (3 - 0));
        int rs = (int)(Math.random() * (12 - 0)+1);
        dcards[cardnum].setIcon(new ImageIcon(dir[dirs] + "/" + rs + ".png"));
        cardnum = cardnum + 1;
        System.out.println(players[0]);
        dcvalue.setText("Dealer: "+players[0]);

        if(rs>9)
        {
          players[0] = players[0] + 10;
        }
        else if (rs==1)
        {
          if(players[0]<12)
          {
            players[0] = players[0] + 11; 
          }
          else
          {
            players[0] = players[0] + rs;
          }
        }
        else
        {
          players[0] = players[0] + rs;
        }
      }
      dcvalue.setText("Dealer: "+players[0]);
      if (players[0]>21)
      {
        System.out.println("Dealer Busts, You Win");
        stay.setEnabled(false);
        hit.setEnabled(false);
        fold.setEnabled(false);

        pwins = pwins + 1;
        pwvalue.setText("Player Wins: "+pwins);
      }
      else if (players[0]>players[1])
      {
        System.out.println("Dealer Wins!");
        stay.setEnabled(false);
        hit.setEnabled(false);
        fold.setEnabled(false);

        dwins = dwins + 1;
        dwvalue.setText("Dealer Wins: "+dwins);
      }
      else if (players[1]>players[0])
      {
        System.out.println("Player Wins!");
        stay.setEnabled(false);
        hit.setEnabled(false);
        fold.setEnabled(false);

        pwins = pwins + 1;
        pwvalue.setText("Player Wins: "+pwins);
      }
      else
      {
        System.out.println("Tie Game.");
        stay.setEnabled(false);
        hit.setEnabled(false);
        fold.setEnabled(false);
      }
    }
    if (e.getSource()==bet)
    {
      stay.setEnabled(true);
      hit.setEnabled(true);
      fold.setEnabled(true);

      cardnum = 0;
      players[0] = 0;
      players[1] = 0;

      pcvalue.setText("Player: 0");
      dcvalue.setText("Dealer: 0");

      for (int i=0;i<6;i++)
      {
        pcards[i].setIcon(null);
        dcards[i].setIcon(null);  
      }

    }
    if (e.getSource()==fold)
    {
      System.out.println("You Fold Dealer Wins.");
      stay.setEnabled(false);
      hit.setEnabled(false);
      fold.setEnabled(false);

      dwins = dwins + 1;
      dwvalue.setText("Dealer Wins: "+dwins);
    }
  }

  public void wincheck()
  {
    if (players[1]==21)
    {
      System.out.println("You Win!");
      stay.setEnabled(false);
      hit.setEnabled(false);
      fold.setEnabled(false);

      pwins = pwins + 1;
      pwvalue.setText("Player Wins: "+pwins);
    }
    if (players[0]==21)
    {
      System.out.println("You lose!");
      stay.setEnabled(false);
      hit.setEnabled(false);
      fold.setEnabled(false);

      dwins = dwins + 1;
      dwvalue.setText("Dealer Wins: "+dwins);
    }
  }

  public void losecheck()
  {
    if (players[1]>21 && players[0]>21)
    {
      System.out.println("Tie game");
      stay.setEnabled(false);
      hit.setEnabled(false);
      fold.setEnabled(false);
    }
    else if (players[1]>21)
    {
      System.out.println("You Bust");
      stay.setEnabled(false);
      hit.setEnabled(false);
      fold.setEnabled(false);

      dwins = dwins + 1;
      dwvalue.setText("Dealer Wins: "+dwins);
    }
    else if (players[0]>21)
    {
      System.out.println("Dealer Busts, You Win!!");
      stay.setEnabled(false);
      hit.setEnabled(false);
      fold.setEnabled(false);

      pwins = pwins + 1;
      pwvalue.setText("Player Wins: "+pwins);
    }
  }
}