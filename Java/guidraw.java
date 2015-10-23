// Starter Template 
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class guidraw extends JFrame{ 
  //Variable and GUIObject Declaration area 
  
  MyDrawPanel p1=new MyDrawPanel();
  
  public static void main(String[ ] args) 
  {
    new guidraw();
  }  
  
  public guidraw (){
    //Create object and your code goes here
    
    this.add(p1);
    this.setSize(600,600);
    this.setVisible(true);
    
  } 
  
  
  class MyDrawPanel extends JPanel {
    public void paintComponent(Graphics g) {

      Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      
      //house
      g2.setColor(new Color(60,60,120));
      g2.fillRect(00,00,600,600);
      g2.setColor(new Color(00,00,00));
      g2.setStroke(new BasicStroke(2));
      g2.drawRect(170,200,250,200);
      g2.setColor(new Color(220,60,60));
      g2.fillRect(171,201,249,199);
      g2.setColor(new Color(00,00,00));
      g2.drawRect(210,110,40,50);
      g2.setColor(new Color(56,92,92));
      g2.fillRect(211,111,39,49);
      int x[] = {151,300,440};
      int y[] = {197,98,197};
      g2.setColor(new Color(120,120,120));
      g2.fillPolygon(x,y,3);
      g2.setColor(new Color(00,00,00));
      g2.drawPolygon(x,y,3);
      g2.setColor(new Color(00,00,00));
      g2.drawRect(220,298,60,60);//window
      g2.setColor(new Color(56,92,92));
      g2.fillRect(221,299,59,59);//window
      g2.setColor(new Color(00,00,00));
      g2.drawLine(250,298,250,358);
      g2.drawLine(220,328,280,328);
      g2.drawRect(320,298,60,100);//door
      g2.setColor(new Color(56,92,92));
      g2.fillRect(321,299,59,99);//door
      g2.setColor(new Color(00,00,00));
      g2.drawOval(365,349,10,10);
      g2.setColor(new Color(00,220,140));
      g2.fillOval(366,350,9,9);

      //colour
      g2.setColor(new Color(56,92,92));
      
    }
  }
}




