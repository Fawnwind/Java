
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.io.PrintStream;

public class ballgame
  extends Applet
  implements Runnable
{
  int x_pos = 30;
  int y_pos = 100;
  int x_posr = 200;
  int y_posr = 300;
  int radius = 20;
  int x_speed = 1;
  int y_speed = 1;
  int x_speedr = 0;
  int y_speedr = 0;
  int appletsize_x = 0;
  int appletsize_y = 0;
  AudioClip miku;
  Image backImage;
  private Image dbImage;
  private Graphics dbg;

  public void init()
  {
    backImage = getImage(getCodeBase(), "gt3.jpg");
    miku = getAudioClip(getCodeBase(), "miku.au");
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

      if (x_pos > appletsize_x - radius)
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
      }
      x_pos += x_speed;
      y_pos += y_speed;

      x_posr += x_speedr;
      y_posr += y_speedr;

      repaint();
      try
      {
        Thread.sleep(5L);
      }
      catch (InterruptedException localInterruptedException) {}
      Thread.currentThread().setPriority(10);
    }
  }

  public void paint(Graphics paramGraphics)
  {
    paramGraphics.setColor(Color.blue);

    paramGraphics.drawImage(backImage, 0, 0, this);

    paramGraphics.fillOval(x_pos - radius, y_pos - radius, 2 * radius, 2 * radius);

    paramGraphics.setColor(Color.red);
    paramGraphics.fillRect(x_posr, y_posr, 200, 30);
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
