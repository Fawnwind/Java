import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import java.awt.image.BufferedImage;


public class colormaze extends Applet implements Runnable, KeyListener //add implements KeyListener
{
  private Image dbImage;
  private Graphics dbg;
  int x = 0;
  int y = 100;
  int t = 0;
  int check1x = 0;
  int check2x = 0;
  int check3x = 0;
  int check4x = 0;
  int check1y = 0;
  int check2y = 0;
  int check3y = 0;
  int check4y = 0;
  int xspeed = 0;
  int yspeed = 0;
  int timer = 0;
  int score = 300;
  int level = 19;
  BufferedImage image=null;
  int w = 0;
  int h= 0;
  Color c = new Color(0,0,0);
  Color c1 = new Color(1,1,11);
  Color c2 = new Color(1,1,11);
  Color c3 = new Color(1,1,11);
  Color c4 = new Color(1,1,11);
  int[] dataBuffInt;

  public void init()
  {
    addKeyListener(this); //add the KeyListener to the applet from
    imgdraw();


  }

  public void start()
  {
    Thread localThread = new Thread(this);
    localThread.start();
  }

  public void stop() {}

  public void destroy() {}

  public void run ()
  {

    Thread.currentThread().setPriority(1);
    for (;;)
    {
      this.resize(w+80,h);
      w = image.getWidth();
      h = image.getHeight();

      x = x + xspeed;
      y = y + yspeed;
      check1x = x+7;
      check2x = x;//top right
      check3x = x+4;//bottom left
      check4x = x+4;//bottom right
      check1y = y+4;
      check2y = y+4;
      check3y = y;
      check4y = y+7;

      c1 = new Color(dataBuffInt[check1y*w+check1x]);
      c2 = new Color(dataBuffInt[check2y*w+check2x]);
      c3 = new Color(dataBuffInt[check3y*w+check3x]);
      c4 = new Color(dataBuffInt[check4y*w+check4x]);

      timer = timer + 1;


      if (timer == 100)
      {
        timer = 0;
        score = score -1;
      }

      if(c1.equals(Color.red))
      {
        x = 0;
        y = 100;
        level = level + 1;
        if (level>21)
          level = 19;
        imgdraw();
        score = score + 300;

      }

      if (c1.getRed() == c.getRed())
      {
        x = x - 1;
      }
      else if(c2.getRed() == c.getRed())
      {
        x = x + 1;
      }

      if(c3.getRed() == c.getRed())
      {
        y = y + 1;
      }
      if(c4.getRed() == c.getRed())
      {
        y = y - 1;
      }





      repaint();
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException ex){}
      Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

    }
  }

  public void paint (Graphics g)
  {
    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
    g.setColor(Color.red);
    g.drawImage(image, 0, 0, this);
    g.fillOval(x,y,8,8);

    if (t== 1)
      g.drawRect(check1x, check1y,1,1);
    String scoretxt = "Score:" + score;
    g.setColor(Color.black);
    g.setFont(new Font("Times New Roman", Font.BOLD, 16));
    g.drawString(scoretxt,w+5,20);
  }

  public void update (Graphics g)
  {
    if (dbImage == null || x == 0)
    {
      dbImage = createImage(w+80,h);
      dbg = dbImage.getGraphics();
    }
    dbg.setColor(getBackground());
    dbg.fillRect(0, 0, w+80, h);

    dbg.setColor(getForeground());
    paint(dbg);

    g.drawImage(dbImage, 0, 0, this);
  }

  public void keyReleased (KeyEvent e){
    int code = e.getKeyCode();

    if (code == 37)
      xspeed = 0;
    else if (code == 38)
      yspeed = 0;
    else if (code == 39)
      xspeed = 0;
    else if (code == 40)
      yspeed = 0;

  }

  public void keyTyped(KeyEvent e){}

  public void keyPressed (KeyEvent e)
  {
    int code = e.getKeyCode();
    //System.out.print(code);
    if (code == 37)
      xspeed = -1;
    else if (code == 38)
      yspeed = -1;
    else if (code == 39)
      xspeed = 1;
    else if (code == 40)
      yspeed = 1;
    else if (code == 97)
    {
      System.out.print(check1x);
      t = 1;
    }
    else if (code == 98)
      t = 0;

  }
  public void imgdraw(){
    try {
      image = ImageIO.read(new File("maze"+level+".gif"));

      w = image.getWidth();
      h = image.getHeight();
      dataBuffInt = image.getRGB(0, 0, w, h, null, 0, w);
    } catch (IOException e) {
    }

  }
}
