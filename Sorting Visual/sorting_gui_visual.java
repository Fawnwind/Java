import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.io.*;
import java.net.URL;
import javax.imageio.*;
import java.awt.image.BufferedImage;


public class visual extends Applet implements Runnable, KeyListener //add implements KeyListener
{
  private Image dbImage;
  private Graphics dbg;

  BufferedImage image=null;
  int[] dataBuffInt;

  public void init()
  {
    addKeyListener(this); //add the KeyListener to the applet from


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

  }

  public void update (Graphics g)
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

    g.drawImage(dbImage, 0, 0, this);
  }
}
