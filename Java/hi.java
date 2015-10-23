// Starter Template 
// import(s) at top of program b4 class line
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class hi extends JFrame implements ActionListener{
  JButton stringpos = new JButton ("Null");
  JLabel blank = new JLabel (""); 
  JTextField textpos = new JTextField ("",10);
  JTextField num = new JTextField ("",1);
  JLabel output = new JLabel (""); 
  String pos = "null";
  int x = 1;
  int y = 1;
  String c = "null";

  JButton substring = new JButton("Null");
  JTextField textsub = new JTextField ("",10);
  JTextField num2 = new JTextField ("",1);
  JTextField sublen = new JTextField ("",5);
  JLabel output2 = new JLabel (""); 

  JButton backwards = new JButton("Null");
  JTextField textbackwards = new JTextField ("",10);
  JLabel blank2 = new JLabel (""); 
  JLabel blank3 = new JLabel (""); 
  JLabel output3 = new JLabel ("");

  JButton even = new JButton("Null");
  JTextField texteven = new JTextField ("",10);
  JLabel blank4 = new JLabel (""); 
  JLabel blank5 = new JLabel (""); 
  JLabel output4 = new JLabel (""); 


  
  JPanel Panel1= new JPanel();
  MyDrawPanel p1=new MyDrawPanel();

  public static void main(String[ ] args) 
  {
    new hi ();
  }  

  public hi (){
    stringpos.addActionListener(this);
    backwards.addActionListener(this);
    substring.addActionListener(this);
    even.addActionListener(this);
    Panel1.setLayout(new GridLayout(4,5));

    Panel1.add(stringpos);
    Panel1.add(textpos);
    Panel1.add(num);
    Panel1.add(blank);
    Panel1.add(output);
    
    Panel1.add(substring);
    Panel1.add(textsub);
    Panel1.add(num2);
    Panel1.add(sublen);
    Panel1.add(output2);
    
    Panel1.add(backwards);
    Panel1.add(textbackwards);
    Panel1.add(blank2);
    Panel1.add(blank3);
    Panel1.add(output3);

    Panel1.add(even);
    Panel1.add(texteven);
    Panel1.add(blank4);
    Panel1.add(blank5);
    Panel1.add(output4);

    this.add(Panel1);
    this.setSize(400,100);
    this.setVisible(true);
  }
    class MyDrawPanel extends JPanel{

  	public void paintComponent(Graphics g) {

      Graphics2D g2 = (Graphics2D)g;

      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
  	}
  }
  public void actionPerformed (ActionEvent e) {
    c="";
    if (e.getSource()==stringpos)
    { 
      x = Integer.parseInt(num.getText()) - 1;
      pos ="" + textpos.getText().charAt(x);
      output.setText(pos);
    }
    if (e.getSource()==substring)
    {
      x = Integer.parseInt(num2.getText()) - 1;
      y = Integer.parseInt(sublen.getText());
      pos = "" + textsub.getText().substring(x,y);
      output2.setText(pos);
    }
    if (e.getSource()==backwards)
    {
      pos = "";
      output3.setText(pos);
      x = textbackwards.getText().length() -1;
      for (int i=x;x>=0;x--)
      {
        c =""+ textbackwards.getText().charAt(x);
        pos = pos + c;
      }
      output3.setText(pos);
    }
    if (e.getSource()==even)
    {
      x = texteven.getText().length();
      for (int i=1;i<=x;i=i+2)
      {
        pos = ""+ texteven.getText().charAt(i);
        c = c + pos;
        output4.setText(c);
        pos = "";
      }
    }  
  }
}
/*
                                               .--.
                                               `.  \
                                                 \  \
                                                  .  \
                                                  :   .
                                                  |    .
                                                  |    :
                                                  |    |
  ..._  ___                                       |    |
 `."".`''''""--..___                              |    |
 ,-\  \             ""-...__         _____________/    |
 / ` " '                    `""""""""                  .
 \                                                      L
 (>                                                      \
/                                                         \
\_    ___..---.                                            L
  `--'         '.                                           \
                 .                                           \_
                _/`.                                           `.._
             .'     -.                                             `.
            /     __.-Y     /''''''-...___,...--------.._            |
           /   _."    |    /                ' .      \   '---..._    |
          /   /      /    /                _,. '    ,/           |   |
          \_,'     _.'   /              /''     _,-'            _|   |
                  '     /               `-----''               /     |
                  `...-'                                       `...-'
*/

               

