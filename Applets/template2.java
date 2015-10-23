import java.applet.*;
import java.awt.*;
import java.awt.event.*;


public class colormaze extends Applet implements Runnable, KeyListener //add implements KeyListener
{
  private Image dbImage;
  private Graphics dbg;

  public void init()
  {
    addKeyListener(this); //add the KeyListener to the applet from
  }

  public void start()
  {
  }

  public void stop() {}

  public void destroy() {}

  public void run ()
  {

    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
    while (true)
    {
      try
      {
        Thread.sleep(20);
      }
      catch (InterruptedException ex)
      {
      }

      Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    }
  }


  public void paint (Graphics g)
  {
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
  public void keyReleased (KeyEvent e){}   // All 3 of these 'key' methyods need to be present
  public void keyTyped(KeyEvent e){}
  public void keyPressed (KeyEvent e)
  {
    int code =e.getKeyCode(); //Will convert the key that is pressed into an integer ASCII value that can be assessed by an IF statement

    System.out.print(code); //This will help you find out the ASCII value of each key OR you could google ASCII chart to find the numeric value of each key

    if (code == KeyEvent.VK_UP) //You can use that ASCII value in the IF statement but some of the common keyboard controls have built in 'constants' like this one for UP arrow
    {

    }

    else if (code == KeyEvent.VK_DOWN)
    {
    }
  }
}
