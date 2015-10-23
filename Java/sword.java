// Starter Template 
// import(s) at top of program b4 class line

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sword extends JFrame{ 
  //Variable and GUIObject Declaration area 
  
  MyDrawPanel p1=new MyDrawPanel();
  
  public static void main(String[ ] args) 
  {
    new sword();
  }  
  
  public sword (){
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
      
      g2.setStroke(new BasicStroke(2));
      //blade
      g2.drawLine(200,200,200,450);
      g2.drawLine(230,200,230,450);
      g2.drawLine(215,200,215,485);

      g2.drawLine(230,451,215,487);
      g2.drawLine(200,451,215,487);
      //hilt
      g2.drawLine(170,200,260,200);
      g2.drawLine(170,180,260,180);

      g2.drawLine(170,180,170,200);
      g2.drawLine(260,180,260,200);

      g2.drawLine(205,130,205,179);
      g2.drawLine(225,130,225,179);

      g2.drawRect(200,119,30,10);



      //shield

      g2.drawArc(300,180,220,280,359,359);
      g2.fillArc(300,180,220,280,360,360);
      g2.setColor(new Color(56,92,180));
      g2.drawArc(380,300,40,40,90,180);
      g2.drawArc(400,300,40,40,270,180);

      g2.setStroke(new BasicStroke(6));
      g2.drawRoundRect(4,4,583,561,20,20); 
    }
  }
}




