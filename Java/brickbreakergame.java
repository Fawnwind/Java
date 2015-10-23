import java.applet.Applet;
import java.awt.*;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.io.PrintStream;
import java.awt.geom.*;
import java.awt.Font;
import javax.swing.*;





public class brickbreakergame extends JFrame implements Runnable {
  //Variable Declaration area
  int x_pos = 30;
  int y_pos = 200;
  int x_posr = 200;
  int y_posr = 400;
  int radius = 5;
  float x_speed = 1;
  float y_speed = 1;
  int x_speedr = 0;
  int dedset = 0;
  int y_speedr = 0;
  int[] brickcheck = new int[10];
  int[] brickcheck2 = new int[10];
  int appletsize_x = 0;
  int appletsize_y = 0;
  AudioClip miku;
  AudioClip hit;
  AudioClip ded;
  Image backImage;
  private Image dbImage;
  private Graphics dbg;
  int score = 0;
  int lives = 3;
  String scoretxt = "Score:" + score;
  String livetxt = "";
  Font s = new Font("Arial",Font.BOLD, 30);

  JPanel game = new JPanel();

  public static void main (String[ ] args)
  {
    new brickbreakergame();
  }

  public brickbreakergame (){
  //Create object and your code goes here
    backImage = getClass().getResource("back.jpg");
    miku = getAudioClip(getCodeBase(), "miku.au");
    hit = getAudioClip(getCodeBase(),"hit.au");
    ded = getAudioClip(getCodeBase(),"ded.au");
    this.setVisble(true);
  }
  public void run()
  {

  }
    public void paint(Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g.setColor(Color.blue);

    g.drawImage(backImage, 0, 0, this);

    g.fillOval(x_pos - radius, y_pos - radius, 2 * radius, 2 * radius);
    g.setColor(Color.black);
    g.drawOval(x_pos - radius, y_pos - radius, 2 * radius, 2 * radius);

    g.setColor(Color.red);
    g.fillRect(x_posr, y_posr, 130, 10);
    g.setColor(Color.black);
    g.drawRect(x_posr, y_posr, 130, 10);

    g.setColor(Color.black);
    scoretxt = "Score:" + score;
    g.setFont(s);
    g.drawString(scoretxt, 5,490);
    livetxt = "HP:"+ lives;
    g.drawString(livetxt, 420, 490);
    if (lives <=0)
    {
      g.drawString("Game Over", 170,200);
    }

    for (int i=0;i<10;i++)
    {
      if (brickcheck[i] == 2)
        g.setColor(Color.red);
      else
        g.setColor(Color.green);
      if (brickcheck[i]>0)
      {
        g.fillRect(50+i*40, 50, 40, 20);
        g.setColor(Color.black);
        g.drawRect(50+i*40, 50, 40, 20);
      }
    }
    for (int i=0;i<10;i++)
    {
      if (brickcheck2[i] == 2)
        g.setColor(Color.red);
      else
        g.setColor(Color.green);
      if (brickcheck2[i]>0)
      {
        g.fillRect(50+i*40, 100, 40, 20);
        g.setColor(Color.black);
        g.drawRect(50+i*40, 100, 40, 20);
      }
    }
  }
}




