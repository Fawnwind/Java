
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

public class brickbreakerjar
  extends Applet
  implements Runnable
{
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


  public void init()
  {
    backImage = getImage(getCodeBase(), "back.jpg");
    miku = getAudioClip(getCodeBase(), "miku.au");
    hit = getAudioClip(getCodeBase(),"hit.au");
    ded = getAudioClip(getCodeBase(),"ded.au");

    for (int i=0;i<10;i++)
    {
      if((i%2)==0)
      brickcheck[i] = 1;
      else
      brickcheck[i] = 2;
    }

    for (int i=0;i<10;i++)
    {
      if((i%2)==0)
      brickcheck2[i] = 2;
      else
      brickcheck2[i] = 1;
    }
  }

  public void start()
  {
    Thread localThread = new Thread(this);

    localThread.start();
  }

  public void stop() {}

  public void destroy() {}

  public void run()
  {
    System.out.print(getWidth()+""+ getHeight());
    Thread.currentThread().setPriority(1);
    for (;;)
    {
      appletsize_x = getWidth();
      appletsize_y = getHeight();
      if (lives <= 0 && dedset == 0)
      {
        dedset = 1;
        ded.play();
      }
      if (x_pos > appletsize_x - radius)
      {
        x_speed = -1;
      } else if (x_pos == 0)
      {
        x_speed = 1;
      }
      if (y_pos > appletsize_y - radius) {
        y_speed = -1;
        lives = lives -1;
        y_speed = 1;
        x_pos = 150;
        y_pos = 200;
      } else if (y_pos == 0) {
        y_speed = 1;
      }
      //paddle check
      if((y_pos + radius >= 400 && y_pos - radius <= 410) && (x_pos + radius == x_posr || x_pos == x_posr +130))
      {
        x_speed = x_speed * -1;
        System.out.print("this works");
        hit.play();
      }
      else if (y_pos + radius >= 400 && y_pos - radius <= 410 && x_pos >= x_posr && x_pos <= x_posr + 130) {

        if(x_pos <= x_posr + 20)
        {
          System.out.print("left");
          x_speed = -1;
        }
        else if (x_pos >= x_posr + 110)
        {
          x_speed = +1;
          System.out.print("right");
        }
        y_speed = y_speed * -1;
        hit.play();
      }
      x_pos += x_speed;
      y_pos += y_speed;

      x_posr += x_speedr;
      y_posr += y_speedr;

      //brick check code
      if (y_pos + radius >= 50 && y_pos - radius <= 70)
      {
        //System.out.print("1");

        for(int i=0;i<10;i++)
        {
          //System.out.print("2");
          if (x_pos >= 50+i*40 && x_pos <= 50+i*40+40 && brickcheck[i] >0)
          {

            brickcheck[i] = brickcheck[i] -1;
            y_speed = y_speed * -1;
            hit.play();
            score = score + 30;
          }
          else if ((x_pos + radius == 50+i*40 || x_pos == 50+i*40+50) && brickcheck[i] >0)
          {
            brickcheck[i] = brickcheck[i] -1;
            x_speed = x_speed * -1;
            hit.play();
            score = score + 30;
          }
        }
      }
      //second row
      if (y_pos + radius >= 100 && y_pos - radius <= 120)
      {
        //System.out.print("1");

        for(int i=0;i<10;i++)
        {
          //System.out.print("2");
          if (x_pos >= 50+i*40 && x_pos <= 50+i*40+40 && brickcheck2[i] >0)
          {

            brickcheck2[i] = brickcheck2[i] -1;
            y_speed = y_speed * -1;
            hit.play();
            score = score + 30;
          }
          else if ((x_pos + radius == 50+i*40 || x_pos == 50+i*40+50) && brickcheck2[i] >0)
          {
            brickcheck2[i] = brickcheck2[i] -1;
            x_speed = x_speed * -1;
            hit.play();
            score = score + 30;
          }
        }
      }

      repaint();
      try
      {
        Thread.sleep(5L);
      }
      catch (InterruptedException localInterruptedException) {}
      Thread.currentThread().setPriority(10);
    }
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

  public void update(Graphics paramGraphics)
  {
    if (dbImage == null)
    {
      dbImage = createImage(getSize().width, getSize().height);
      dbg = dbImage.getGraphics();
    }
    dbg.setColor(getBackground());
    dbg.fillRect(0, 0, getSize().width, getSize().height);

    dbg.setColor(getForeground());
    paint(dbg);

    paramGraphics.drawImage(dbImage, 0, 0, this);
  }

  public boolean mouseDown(Event paramEvent, int paramInt1, int paramInt2)
  {
    x_speed = (-x_speed);

    return true;
  }

  public boolean keyDown(Event paramEvent, int paramInt)
  {
    if (paramInt == 1006) {
      x_speedr = -2;
    } else if (paramInt == 1007) {
      x_speedr = 2;
    } else if (paramInt == 32) {
      x_speedr = 0;
    } else {
      System.out.println("Charakter: " + (char)paramInt + " Integer Value: " + paramInt);
    }
    return true;
  }

  public boolean keyUp(Event paramEvent, int paramInt)
  {
    if (paramInt == 1006) {
      x_speedr = 0;
    } else if (paramInt == 1007) {
      x_speedr = 0;
    }
    return true;
  }
}
