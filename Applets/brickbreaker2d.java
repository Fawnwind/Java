
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.io.PrintStream;
import java.awt.geom.*;

public class brickbreaker2d
  extends Applet
  implements Runnable
{
  int x_pos = 30;
  int y_pos = 100;
  int x_posr = 200;
  int y_posr = 300;
  int radius = 5;
  int x_speed = 1;
  int y_speed = 1;
  int x_speedr = 0;
  int y_speedr = 0;
  int[] brickcheck = new int[10];
  int appletsize_x = 0;
  int appletsize_y = 0;
  AudioClip miku;
  AudioClip hit;
  Image backImage;
  private Image dbImage;
  private Graphics dbg;
  Ellipse2D.Double ball = new Ellipse2D.Double(x_pos, y_pos, 2 * radius, 2 * radius);
  Rectangle2D.Double paddle = new Rectangle2D.Double(x_posr, y_posr, 200, 30);


  public void init()
  {
    backImage = getImage(getCodeBase(), "gt3.jpg");
    miku = getAudioClip(getCodeBase(), "miku.au");
    hit = getAudioClip(getCodeBase(),"hit.au");

    for (int i=0;i<10;i++)
    {
      brickcheck[i] = 1;
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
    Thread.currentThread().setPriority(1);
    for (;;)
    {
      appletsize_x = getWidth();
      appletsize_y = getHeight();

      if (ball.x + ball.width >= appletsize_x)
      {
        x_speed = -1;
      } else if (x_pos == 0)
      {
        x_speed = 1;
      }
      if (y_pos > appletsize_y - radius) {
        y_speed = -1;
      } else if (y_pos == 0) {
        y_speed = 1;
      }
      if (y_pos >= y_posr - radius && y_posr <= y_pos + 30 && x_pos >= x_posr && x_pos <= x_posr + 200) {
        y_speed = -1;
        hit.play();
      }
      ball.x += x_speed;
      ball.y += y_speed;

      x_posr += x_speedr;
      y_posr += y_speedr;

      //brick check code
      if ((y_pos-radius <= 70&&y_pos-radius >= 69  && y_speed<0)||(y_pos+radius >= 50&&y_pos+radius <= 51  && y_speed>0) )
      {
        //System.out.print("1");

        for(int i=0;i<10;i++)
        {
          //System.out.print("2");
          if (x_pos >= 50+i*40 && x_pos <= 50+i*40+40 && brickcheck[i] == 1)
          {

            brickcheck[i] = 0;
            y_speed = y_speed * -1;
            hit.play();
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
    g.setColor(Color.blue);

    g.drawImage(backImage, 0, 0, this);

    g.fillOval((int)ball.x, (int)ball.y,(int)ball.width,(int)ball.height);
    g.setColor(Color.black);
    g.drawOval((int)ball.x, (int)ball.y,(int)ball.width, (int)ball.height);

    g.setColor(Color.red);
    g.fillRect(x_posr, y_posr, 200, 30);
    g.setColor(Color.black);
    g.drawRect(x_posr, y_posr, 200, 30);

    for (int i=0;i<10;i++)
    {
      if((i%2)==0)
        g.setColor(Color.yellow);
      else
        g.setColor(Color.green);
      if (brickcheck[i]==1)
      {
        g.fillRect(50+i*40, 50, 40, 20);
        g.setColor(Color.black);
        g.drawRect(50+i*40, 50, 40, 20);
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
      x_speedr = -5;
    } else if (paramInt == 1007) {
      x_speedr = 5;
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
